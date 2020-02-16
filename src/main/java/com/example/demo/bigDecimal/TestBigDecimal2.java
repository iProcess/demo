package com.example.demo.bigDecimal;

import java.math.BigDecimal;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/2/12 9:04
 * Description: TODO
 */
public class TestBigDecimal2 {

    public static void main(String[] args) {
        BigDecimal decimal1 = new BigDecimal(201);
        BigDecimal decimal2 = new BigDecimal(100);
        BigDecimal decimal3 = new BigDecimal(0.5);

        BigDecimal divide = decimal2.divide(decimal1, 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);

        System.out.println(decimal3.compareTo(divide));

    }
}
