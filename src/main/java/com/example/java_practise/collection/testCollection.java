package com.example.java_practise.collection;


import java.util.ArrayList;
import java.util.Collection;

public class testCollection {
    public static void main(String[] args) {
        Person p1 = new Person("user1", 10);
        Person p2 = new Person("user2", 20);
        Person p3 = new Person("王五", 18);

        Collection list = new ArrayList();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collection list2 = new ArrayList();
        Person p4 = new Person("user2", 20);

        list2.add(p1);
        list2.add(p4);

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.contains(p4)); //contains中调用了重写的equals方法，所以list包含p2=p4
        System.out.println(list.toArray().toString());
        System.out.println(list.toString());//这里用的是重写了的Person的toString方法。
        System.out.println(list);//默认调用toString方法。
        System.out.println(list.containsAll(list2));
        list.remove(p2);
        System.out.println(list);
        System.out.println(list.containsAll(list2));

        list.clear();
        System.out.println(list);

    }
}
