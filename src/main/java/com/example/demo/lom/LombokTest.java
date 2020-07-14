package com.example.demo.lom;

public class LombokTest {

    public static void main(String[] args) {
        CustomerScaleOrderDataVO dataVO = CustomerScaleOrderDataVO.builder()
                .totalCustCount(100)
                .ordCustCount(10)
                .activeCustCount(5)
                .newCustCount(1)
                .build();
        System.out.println(dataVO);
    }

}
