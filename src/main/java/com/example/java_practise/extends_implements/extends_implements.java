package com.example.java_practise.extends_implements;

public class extends_implements {

}


class Father {
    public String name;
    private int age;
    public String nation;

    public Father() {//最好要有，否则，子类中必须要调用有参的super(name, age, nation);

    }

    public Father(String name, int age, String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;
    }

    public void introduce() {
        System.out.println("Je m'appelle " + this.name + ". " +
                "J'ai " + this.age + " ans. " +
                "Je suis " + this.nation);
    }
}

class Son extends Father {

    public Son(String name, int age, String nation) {
        super(name, age, nation);
    }


}
