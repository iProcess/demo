package com.example.demo.exception;

public class TestD {

    public void getTestD(int a) throws ClientTimeoutException{
        System.out.println(a);
        throw new RuntimeException("getTestD");

    }

}
