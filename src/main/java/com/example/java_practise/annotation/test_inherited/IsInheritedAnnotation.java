package com.example.java_practise.annotation.test_inherited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface IsInheritedAnnotation {
}
