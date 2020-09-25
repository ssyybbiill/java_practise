package com.example.java_practise.annotation.test_inherited;

@IsInheritedAnnotation
@NoInheritedAnnotation
public interface FatherInterface {

}

interface SonInterface extends FatherInterface {

}