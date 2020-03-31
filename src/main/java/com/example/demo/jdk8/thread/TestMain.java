package com.example.demo.jdk8.thread;

public class TestMain {

    public static void main(String[] args) {

        int res = Runtime.getRuntime().availableProcessors();
        System.out.println(res);
    }
}
