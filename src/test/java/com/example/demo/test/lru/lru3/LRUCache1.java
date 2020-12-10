package com.example.demo.test.lru.lru3;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K, V> extends LinkedHashMap<K, V> {

    //常量必须初始化：1、指定初始值；2、在构造函数中进行初始化
    private final int CACHE_SIZE;

    LRUCache1(int cacheSize){
        super(cacheSize, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }

}
