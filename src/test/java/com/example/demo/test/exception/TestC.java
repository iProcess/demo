package com.example.demo.test.exception;

public class TestC {

    public void getTestC(int a) throws RuntimeException{
        System.out.println(a);
        throw new RuntimeException("getTestC");
    }

}
