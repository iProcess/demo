package com.example.demo;

import java.math.BigDecimal;

public class TestMain {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("23213.8780").divide(new BigDecimal(10000), 2, BigDecimal.ROUND_UP);
        System.out.println(bigDecimal.toString());
    }
}
