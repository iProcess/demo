package com.example.demo.test.myhashmap;

import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.putIfAbsent("test", "123");
    }
}
