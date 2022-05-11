package com.example.java_practise.extends_implements;

public class Type {
    Type scope;
    Type list1;
    Type list2;
    Type father;

    public static void main(String[] args) {
        Type func1 = new Function();
        Type file1 = new File();
        func1.father = file1;
        if(func1.father instanceof File){ // 恒真，意义不大了。。
            System.out.println("我是全局函数啦！");
        }
    }
}

class Linux extends Type{
    Dentry list1;
}
class Dentry extends Type {
    Dentry[] list1; //List<Type[]> list1; // Dentry[]或 File[]
    File[] list2;
    Linux father;
}
class File extends Type {
    Function[] list1;
    Struct[] list2;
    Dentry father;
}
class Function extends Type {
    File scope;
    Type[] list1; // ParamIn list1;
    Type[] list2; // ParamOut list2;
    File father;
}

class Struct extends Type{
    File scope;
    Type[] list1;
    Method[] list2;
    File father;
}

class Method extends Type {
    Struct scope;
    Type[] list1; // ParamIn list1;
    Type[] list2; // ParamOut list2;
    Struct father;
}

class Base extends Type{

}