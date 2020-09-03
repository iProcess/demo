package com.example.demo.test.big;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestBig {

    public String getAmount(Double amount) {
        if(amount == null){
            return null;
        }
        if(amount >= 0) {
            if (amount % 100 == 0) {
                return amount / 100 + "";
            } else {
                BigDecimal moneyBig = new BigDecimal(amount);
                return moneyBig.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString();
            }
        }
        return amount.toString();
    }

    public String getAmount1(String amount) {
        BigInteger moneyBig = new BigInteger(amount);
        return moneyBig.divide(new BigInteger("10000")).toString();
    }


    public static void main(String[] args) {
        TestBig big = new TestBig();
        System.out.println(Long.MAX_VALUE);
        String s1 = big.getAmount(9223372036854776000d);
        System.out.println(s1);
        String s2 = big.getAmount(9223372036854775807d);
        System.out.println(s2);

        String s3 = big.getAmount1("9223372036854776000");
        System.out.println(s3);
    }

}
