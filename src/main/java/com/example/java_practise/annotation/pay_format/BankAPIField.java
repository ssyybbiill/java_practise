package com.example.java_practise.annotation.pay_format;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {
    String type() default "";

    int length() default -1;

    int order() default -1;

}
