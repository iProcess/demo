package com.example.demo.test.xl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GuavaCacheTest {

    public static LoadingCache<Long, AtomicLong> COUNTER = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long seconds) throws Exception {
                    System.out.println("LoadingCache-->load..., seconds=" + seconds);
                    return new AtomicLong(0);
                }
            });

    public static void main(String[] args) throws ExecutionException {
        long result1 = COUNTER.get(123L).get();
        System.out.println(result1);
        long result2 = COUNTER.get(123L).get();
        System.out.println(result2);
    }

}
