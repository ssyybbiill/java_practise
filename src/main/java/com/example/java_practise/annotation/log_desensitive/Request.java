package com.example.java_practise.annotation.log_desensitive;


public class Request {

    @SensitiveInfo(type = SensitiveType.NAME)
    private String name;
    @SensitiveInfo(type = SensitiveType.ID_CARD)
    private String idcard;
    @SensitiveInfo(type = SensitiveType.PHONE)
    private String phone;
    @SensitiveInfo(type = SensitiveType.IMG_BASE64)
    private String imgBase64;

}