package com.example.demo;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/11 15:39
 * Description: TODO
 */
public class TestBeanUtils {

    public static void main(String[] args) {
        A a = new A();
        a.getA().add(new XA());
        B b= new B();
        BeanUtils.copyProperties(a,b);
        List<XB> a1 = b.getA();
        /**
         * Exception in thread "main" java.lang.ClassCastException: com.example.demo.XA cannot be cast to com.example.demo.XB
         * 	at com.example.demo.TestBeanUtils.main(TestBeanUtils.java:21)
         */
        for (XB xb : a1) {
            System.out.println("AAA");
        }
        List<XA> a2 = a.getA();
        for (XA xb : a2) {
            System.out.println("AAA");
        }
    }

}
