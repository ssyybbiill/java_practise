package com.example.java_practise.annotation.log_desensitive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class Util {
    public static String toJSONString(Object object) {
        try {
            return JSON.toJSONString(object, getValueFilter());
        } catch (Exception e) {
            return ToStringBuilder.reflectionToString(object);
        }
    }

    private static ValueFilter getValueFilter() {
        return (obj, key, value) -> {
            // obj-对象 key-字段名 value-字段值
            try {
                // 通过反射获取获取每个类的属性
                Field[] fields = obj.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!field.getName().equals(key)) {
                        continue;
                    }
                    // 判定属性是否有相应的 SensitiveInfo 注解
                    SensitiveInfo annotation = field.getAnnotation(SensitiveInfo.class);
                    // 若有，则执行相应字段的脱敏方法
                    if (null != annotation) {
                        switch (annotation.type()) {
                            case PHONE:
                                return "电话脱敏";
                            case ID_CARD:
                                return "身份证脱敏";
                            case NAME:
                                return "姓名脱敏";
                            case IMG_BASE64:
                                return ""; // 图片的 base 64 不展示，直接返回空
                            default:
                                // 这里可以抛异常
                        }
                    }
                }
            } catch (Exception e) {
                Logger logger = LogManager.getLogger();
                logger.error("To JSON String fail", e);
                //log.error("To JSON String fail", e);//垃圾log死活弄不成！
            }
            return value;
        }

                ;
    }
}