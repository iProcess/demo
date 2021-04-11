package com.example.demo.test.mt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    public static void main(String[] args) {
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newFixedThreadPool(10);
    }
}
