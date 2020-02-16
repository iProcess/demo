package com.example.demo.exception;

public class TestC {

    public void getTestC(int a) throws RuntimeException{
        System.out.println(a);
        throw new RuntimeException("getTestC");
    }

}
