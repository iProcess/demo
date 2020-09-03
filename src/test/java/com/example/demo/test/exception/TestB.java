package com.example.demo.test.exception;

public class TestB {

    public void getTestB(int a) throws Throwable {
        System.out.println(a);
        throw new Throwable("getTestB");
    }

}
