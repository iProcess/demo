package com.example.demo.test.ali.conditione;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {

    private Lock lock;
    private Condition produce;
    private Condition consume;
    private Resource resource;

    public Consumer(Lock lock, Condition produce, Condition consume, Resource resource){
        this.lock = lock;
        this.produce = produce;
        this.consume = consume;
        this.resource = resource;
    }

    @Override
    public void run() {
        consume();
    }

    volatile boolean flag = true;
    private void consume() {

//        lock.lock();
        while (flag){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() +  "消费开始," + resource.getResource().get());
                if(resource.getResource().get() <= 0){
                    try {
//                        System.out.println("资源小于等于0，唤醒生产，消费沉睡");
                        produce.signal();
                        consume.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        flag = false;
                    }
                }

//                System.out.println("资源大于0，准备消费");
                int res = resource.getResource().decrementAndGet();
                System.out.println(Thread.currentThread().getName() +  "消费后：" + res);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } finally{
//                System.out.println("消费：unlock");
                lock.unlock();
            }
        }

    }
}
