package com.example.demo.test.lru.lru3;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 基于JavaLinkedHashMap实现
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int CACHE_SIZE;

    //保存传递进来的最大数据量
    public LRUCache(int cacheSize){
        //设置hashmap的初始大小，同时最后一个true指的是让linkedhashmap按照访问顺序来进行排序，
        //最近访问的放在头，最老访问的放在尾
        //super((int)Math.ceil(cacheSize / 0.75) + 1,0.75f,true);
        super(cacheSize,0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        //当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        System.out.println(5 / 0.75);
        System.out.println(Math.ceil(5 / 0.75));

        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        System.out.println(JSON.toJSONString(cache));

        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));

        System.out.println(JSON.toJSONString(cache));

        cache.put(6, 6);

        System.out.println(JSON.toJSONString(cache));


    }

}
