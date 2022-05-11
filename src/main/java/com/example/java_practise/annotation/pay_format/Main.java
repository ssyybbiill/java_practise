package com.example.java_practise.annotation.pay_format;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.client.fluent.Request;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.Logger;

public class Main {
    private static String remoteCall(AbstractAPI api) throws IOException {
        //从BankAPI注解获取请求地址
        BankAPI bankAPI = api.getClass().getAnnotation(BankAPI.class);
        bankAPI.url();//不知道有什么用？仅仅是打印输出？log输出？
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("==============");
        System.out.println(api.getClass().getDeclaredFields());
        System.out.println(api.getClass());
        System.out.println("==============");
        Arrays.stream(api.getClass().getDeclaredFields()) //获得所有字段
                .filter(field -> field.isAnnotationPresent(BankAPIField.class)) //查找标记了注解的字段
                .sorted(Comparator.comparingInt(a -> a.getAnnotation(BankAPIField.class).order())) //根据注解中的order对字段排序
                .peek(field -> field.setAccessible(true)) //设置可以访问私有字段
                .forEach(field -> {
                    //获得注解
                    BankAPIField bankAPIField = field.getAnnotation(BankAPIField.class);
                    Object value = "";
                    try {
                        //反射获取字段值
                        value = field.get(api);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    //根据字段类型以正确的填充方式格式化字符串
                    switch (bankAPIField.type()) {
                        case "S": {
                            stringBuilder.append(String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_'));
                            break;
                        }
                        case "N": {
                            stringBuilder.append(String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0'));
                            break;
                        }
                        case "M": {//不懂这个处理逻辑！
                            if (!(value instanceof BigDecimal))
                                throw new RuntimeException(String.format("{} 的 {} 必须是BigDecimal", api, field));
                            stringBuilder.append(String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
                            break;
                        }
                        default:
                            break;
                    }
                });
        //签名逻辑
        stringBuilder.append(DigestUtils.md2Hex(stringBuilder.toString()));
        String param = stringBuilder.toString();
        long begin = System.currentTimeMillis();
        //发请求
        //下面这个地址明显有问题怎么改？？？这个应该就是那个接口规范中的“baseUrl”，是应该自己写一个虚拟的服务端接口吧？
        // 具体怎么写，还需要弄清没有用注解的时候怎么请求的，那个弄清怎么处理baseUrl了，这里一样。
        String result = Request.Post("http://localhost:45678/reflection" + bankAPI.url())
                .bodyString(param, ContentType.APPLICATION_JSON) //请求体body为Json字符串的文本类型
                .execute().returnContent().asString();

        Logger logger = LogManager.getLogger();
        logger.info("调用银行API {} url:{} 参数:{} 耗时:{}ms", bankAPI.desc(), bankAPI.url(), param, System.currentTimeMillis() - begin);
        //log.info("调用银行API {} url:{} 参数:{} 耗时:{}ms", bankAPI.desc(), bankAPI.url(), param, System.currentTimeMillis() - begin);

        return result;
    }

    //创建用户方法
    public static String createUser(CreateUserAPI request) throws IOException {
        return remoteCall(request);
    }

    //支付方法
    public static String pay(PayAPI request) throws IOException {
        return remoteCall(request);
    }

    public static void main(String[] args) throws IOException {
        CreateUserAPI cuapi = new CreateUserAPI("user1", "122222222222222222", "11111111111", 12);
        createUser(cuapi);
    }
}
