package com.example.demo.test.proxy.nondynamic;

//目标对象RealSubject
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }
}
