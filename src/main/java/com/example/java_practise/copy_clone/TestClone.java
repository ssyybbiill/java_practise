package com.example.java_practise.copy_clone;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Addr a1 = new Addr("Paris");
        Person p1 = new Person();
        p1.addr = a1;
        Person p2 = (Person) p1.clone();

        System.out.println("=====Paris=====");
        System.out.println(p1.addr.place);
        System.out.println(p2.addr.place);
        System.out.println(p1.addr);
        System.out.println(p2.addr);


        System.out.println("=====北京=====");
        a1.setPlace("北京");
        System.out.println(p1.addr.place);
        System.out.println(p2.addr.place);
        System.out.println(p1.addr);
        System.out.println(p2.addr);

        System.out.println("=====天津=====");
        a1 = new Addr("天津");
        System.out.println(p1.addr.place);
        System.out.println(p2.addr.place);
        System.out.println(p1.addr);
        System.out.println(p2.addr);

        System.out.println("=====上海=====");
        p1.addr.setPlace("上海");
        System.out.println(p1.addr.place);
        System.out.println(p2.addr.place);
        System.out.println(p1.addr);
        System.out.println(p2.addr);

        System.out.println("=====墨尔本=====");
        p1.addr = new Addr("墨尔本");
        System.out.println(p1.addr.place);
        System.out.println(p2.addr.place);
        System.out.println(p1.addr);
        System.out.println(p2.addr);

    }
}

class Person implements Cloneable {
    Addr addr;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Addr {
    String place;

    public Addr(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}