package com.example.demo.jdk8.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/17 17:42
 * Description: TODO
 */
public class TestCache {

    private volatile LoadingCache<Long, List<Long>> availableCouponsCache;

    public void init() {
        availableCouponsCache = CacheBuilder.newBuilder()
                .maximumSize(20000)
                .expireAfterAccess(15, TimeUnit.MINUTES)
                .weakKeys()
                .softValues()
                .build(new CacheLoader<Long, List<Long>>() {

                    @Override
                    public List<Long> load(Long venderId) throws Exception {
                        return findAvailableEvtIdsCache(venderId);
                    }

                });
    }

    public List<Long> findAvailableEvtIdsCache(Long venderId) {
        List<Long> ids = new ArrayList();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        return ids;
    }

    public void display(Long venderId){
        if (availableCouponsCache == null) {
            synchronized (TestCache.class) {
                if (availableCouponsCache == null) {
                    init();
                }
            }
        }
        try {
            //第一次会执行 load(Long venderId)方法
            List<Long> availableEvtIds = availableCouponsCache.get(venderId);
            System.out.println(JSON.toJSONString(availableEvtIds));

            List<Long> ids = availableCouponsCache.get(venderId);
            System.out.println(JSON.toJSONString(ids));

        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TestCache cache = new TestCache();
        cache.display(1L);
    }
}
