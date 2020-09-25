package com.example.java_practise.annotation.pay_format;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface BankAPI {
    String url() default "";

    String desc() default "";
}
