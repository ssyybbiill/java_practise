package com.example.java_practise.collection;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.hashCode() + age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }

        Person p = (Person) object;
        return this.age == p.age && this.name.equals(p.name);
    }

    @Override
    public String toString() {
        return "Person: name=" + this.name + ",age=" + this.age;
    }
}
