package com.example.java_practise.annotation.test_inherited;

@IsInheritedAnnotation
@NoInheritedAnnotation
public class Father {

}

class Son extends Father {

}

class Son2 implements FatherInterface {

}