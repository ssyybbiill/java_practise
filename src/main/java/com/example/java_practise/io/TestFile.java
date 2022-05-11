package com.example.java_practise.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:hxl
 * @Date:2021/8/20 2:42
 * @Email:hxlsybil@126.com
 * @Blog：https://www.cnblogs.com/sybil-hxl/
 * @Description：
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsoluteFile().getParent());
        String path = "D:/考研英语单词";
        String goal = "G:/我的一些东西/学习相关/考研/我自己要用的资料/19考研/考研英语单词";

        //parseFunctionByExp("");


    }


    public static List<String> parseFunctionByExp(String expRemark) {
        expRemark = "ssize_t (*read) (struct file *, char __user *, size_t, loff_t *);";

        // type_name
        String[] strs = Arrays.stream(expRemark.split("\\(|\\)|;")).filter(s -> !s.trim().equals("")).toArray(String[]::new);

        String func_name = strs[1].replace("*", "");
        String param_in = strs[2].replaceAll("struct|\\*|__user| ", "");
        String param_out = strs[0];

        System.out.println("===" + func_name + "====");
        System.out.println("===" + param_in + "====");
        System.out.println("===" + param_out + "====");

        List<String> list = new ArrayList<>();
        list.add(func_name);
        list.add(param_in);
        list.add(param_out);

        return list;
    }
}
