package com.example.demo.lru;

public class TestLRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put("abc", "123");
        cache.put("def", "456");
        cache.put("ghi", "789");
        cache.put("jkl", "987");
    }
}
