package com.example.java_practise.annotation.pay_format;

import java.math.BigDecimal;

@BankAPI(url = "/bank/pay", desc = "支付接口")
//@Data //不知道这个Data是什么里面的，pom中引入也没有用。
public class PayAPI extends AbstractAPI {
    @BankAPIField(order = 1, type = "N", length = 20)
    private long userId;
    @BankAPIField(order = 2, type = "M", length = 10)
    private BigDecimal amount;
}


