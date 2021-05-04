package com.example.demo.test.xl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 限流：https://www.iteye.com/blog/jinnianshilongnian-2305117
 * 限流某个接口的时间窗请求数
 */
public class AvgCount {

    /**
     * 1秒内最大请求数
     */
    private Long limit = 5L;

    private LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long seconds) throws Exception {
                    return new AtomicLong(0);
                }
            });

    public void getCustomer(){
        //得到当前秒
        Long currentSeconds = System.currentTimeMillis() / 1000;
        try {
            if(counter.get(currentSeconds).incrementAndGet() > limit) {
                //System.out.println(Thread.currentThread().getName() + "->拒绝请求->currentSeconds=" + currentSeconds);
                return;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //业务处理
        //处理请求
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "->处理请求->currentSeconds=" + currentSeconds);
    }

    public static void main(String[] args) {
        AvgCount test = new AvgCount();

        Thread one = new Thread(() -> {
           while (true){
               test.getCustomer();
           }
        });

        Thread two = new Thread(() -> {
            while (true){
                test.getCustomer();
            }
        });

        Thread three = new Thread(() -> {
            while (true){
                test.getCustomer();
            }
        });

        Thread four = new Thread(() -> {
            while (true){
                test.getCustomer();
            }
        });

        Thread five = new Thread(() -> {
            while (true){
                test.getCustomer();
            }
        });

        Thread six = new Thread(() -> {
            while (true){
                test.getCustomer();
            }
        });

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();

    }

}
