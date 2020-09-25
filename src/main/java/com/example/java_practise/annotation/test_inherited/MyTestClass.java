package com.example.java_practise.annotation.test_inherited;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class MyTestClass {
    public static void main(String[] args) {
        {
            //类继承关系中，子类会继承父类使用的注解中被@Inherited修饰的注解。
            // 继承的和不继承的注释，都继承了
            Annotation[] annotations = Son.class.getAnnotations();
            System.out.println(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));//true
            System.out.println(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInheritedAnnotation.class)));//true
        }
        {
            //接口继承关系中，子接口不会继承父接口中的任何注解，不管父接口中使用的注解有没有被@Inherited修饰
            Annotation[] annotations = SonInterface.class.getAnnotations();
            System.out.println(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class))); //false
            System.out.println(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInheritedAnnotation.class)));//true
        }
        {
            //类实现接口时不会继承任何接口中定义的注解
            Annotation[] annotations = Son2.class.getAnnotations();
            System.out.println(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class))); //false
            System.out.println(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInheritedAnnotation.class)));//true
        }


        {
            //父接口
            Annotation[] annotations = FatherInterface.class.getAnnotations();
            System.out.println(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class))); //true
            System.out.println(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInheritedAnnotation.class)));//false
        }
    }
}
