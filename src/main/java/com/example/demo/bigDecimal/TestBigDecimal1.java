package com.example.demo.bigDecimal;

import java.math.BigDecimal;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/2/12 9:04
 * Description: TODO
 */
public class TestBigDecimal1 {

    public static void main(String[] args) {
        BigDecimal decimal1 = new BigDecimal(0.5);
        BigDecimal decimal2 = new BigDecimal(0.5000);
        BigDecimal decimal3 = new BigDecimal(0.50000001);

        //0
        System.out.println(decimal1.compareTo(decimal2));
        //0
        System.out.println(decimal2.compareTo(decimal1));

        //-1
        System.out.println(decimal1.compareTo(decimal3));
        //1
        System.out.println(decimal3.compareTo(decimal1));

        //-1
        System.out.println(decimal2.compareTo(decimal3));
        //1
        System.out.println(decimal3.compareTo(decimal2));

    }
}
