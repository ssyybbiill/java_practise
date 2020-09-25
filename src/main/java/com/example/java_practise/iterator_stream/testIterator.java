package com.example.java_practise.iterator_stream;

import java.util.ArrayList;
import java.util.Iterator;

public class testIterator {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        // 获取迭代器
        Iterator<String> it = sites.iterator();
        while (it.hasNext()) {//第一次就用尽了，因为是hasNext
            System.out.println(it.next());
        }
        System.out.println("+++++++++++++++");
        while (it.hasNext()) {//第二次根本就没有了，进不了循环
            System.out.println(it.next());
        }

        //stream
//        sites.stream().filter()

    }
}
