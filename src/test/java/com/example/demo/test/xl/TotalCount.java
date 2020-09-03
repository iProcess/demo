package com.example.demo.test.xl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 限流：https://www.iteye.com/blog/jinnianshilongnian-2305117
 * 限流某个接口的总并发/请求数
 */
public class TotalCount {

    private AtomicLong atomic = new AtomicLong(0);
    /**
     * 同一时刻最大两个请求数
     */
    private static final Integer VISIT_COUNT = 2;

    //限流某个接口的总并发/请求数
    public int getCustomer(){
        try {
            long i = atomic.incrementAndGet();
            if(i > VISIT_COUNT) {
                //拒绝请求
                //System.out.println(Thread.currentThread().getName() + "->拒绝请求->i=" + i);
                return 0;
            }
            //处理请求
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "->处理请求-i=" + i);
            return 1;
        } finally {
            atomic.decrementAndGet();
        }
    }

    public static void main(String[] args) {
        TotalCount test = new TotalCount();

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

        one.start();
        two.start();
        three.start();

    }

}
