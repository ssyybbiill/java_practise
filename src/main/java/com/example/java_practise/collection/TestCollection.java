package com.example.java_practise.collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        Person p1 = new Person("user1", 10);
        Person p2 = new Person("user2", 20);
        Person p3 = new Person("王五", 18);

        Collection list1 = new ArrayList();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);

        Collection list2 = new ArrayList();
        Person p4 = new Person("user2", 20);

        list2.add(p1);
        list2.add(p4);

        System.out.println(list1.isEmpty());
        System.out.println(list1.size());
        System.out.println(list1.contains(p4)); //contains中调用了重写的equals方法，所以list包含p2=p4
        System.out.println(list1.toArray().toString());
        System.out.println(list1.toString());//这里用的是重写了的Person的toString方法。
        System.out.println(list1);//默认调用toString方法。
        System.out.println(list1.containsAll(list2));
        list1.remove(p2);
        System.out.println(list1);
        System.out.println(list1.containsAll(list2));

        list1.clear();
        System.out.println(list1);


        List list3 = new ArrayList();//也可以存储不同类型的数据！！
        list3.add("dddd");
        list3.add(2);
        list3.add(p1);
        System.out.println(list3);
        Object obj = list3.set(2, p4); //设置索引2为一个新数据，并返回原数据
        System.out.println(obj);
        System.out.println(list3);

        list3.add(2);
        // indexOf(Object o) 返回第一次出现的指定元素的角标
        int indexOf = list3.indexOf(2);
        System.out.println(indexOf); // 1
        System.out.println(list3.indexOf(3));// 没有找到，返回-1

        // lastIndexOf 返回最后出现的指定元素的角标
        int lastIndexOf = list3.lastIndexOf(2);
        System.out.println(lastIndexOf); // 3
    }
}
