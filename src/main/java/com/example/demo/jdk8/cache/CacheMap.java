package com.example.demo.jdk8.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/oFeiHongYe/article/details/88666477
 * @param <K>
 * @param <V>
 */
@Slf4j
public class CacheMap<K, V> {

    private Cache<K, V> cache;
    private ExpiredCallback<K, V> _callback;

    public CacheMap(long maximumSize, long expireAfterWriteSeconds,
                    ExpiredCallback<K, V> callback) {
        _callback = callback;

        RemovalListener<K, V> removalListeners = RemovalListeners.asynchronous(
                notification -> {
                    _callback.expire(notification.getKey(),notification.getValue());
                    },
                Executors.newSingleThreadExecutor());

        cache = CacheBuilder.newBuilder().maximumSize(maximumSize)
                .expireAfterWrite(expireAfterWriteSeconds, TimeUnit.SECONDS)
                .initialCapacity(10)
                .removalListener(removalListeners).build();
    }

    public CacheMap(long maximumSize, long expireAfterWriteSeconds) {
        cache = CacheBuilder.newBuilder().maximumSize(maximumSize)
                .expireAfterWrite(expireAfterWriteSeconds, TimeUnit.SECONDS)
                .initialCapacity(10)
                .removalListener((RemovalListener<K, V>) rn -> System.out.println("被移除缓存:" + rn.getKey() + rn.getValue())).build();
    }

    public interface ExpiredCallback<K, V> {
        void expire(K key, V val);
    }

    private void rotate(K key, V val) {
        if (_callback != null) {
            _callback.expire(key, val);
        }
    }

    public V get(K key) {
        return key != null ? cache.getIfPresent(key) : null;
    }

    public void put(K key, V value) {
        if (key != null && value != null) {
            cache.put(key, value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> value1 = new ArrayList<>();
        value1.add("val1");

        ExpiredCallback<String, ArrayList<String>> expiredCallback = (key, val) -> System.out.println(key + ":" + val);
        CacheMap<String, ArrayList<String>> cacheMap = new CacheMap<>(10000, 5,expiredCallback);
        cacheMap.put("key1", value1);
        System.out.println("是否删除 key1");
        cacheMap.cache.cleanUp();
        Thread.sleep(4000);
//        cacheMap.get("key1").add("val2");
        //加入一个key2
        ArrayList<String> value2 = new ArrayList<>();
        value2.add("val21");
        cacheMap.put("key2", value2);
        Thread.sleep(2000);//key2不会过期，key1过期，并且没有触发监听器内容
        System.out.println("是否删除 key1");
        cacheMap.cache.cleanUp();//触发监听器内容
        Thread.sleep(4000);
        System.out.println("是否删除 key2");
        cacheMap.cache.cleanUp();
    }
}
