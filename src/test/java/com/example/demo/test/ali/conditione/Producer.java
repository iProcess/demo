package com.example.demo.test.ali.conditione;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private Lock lock;
    private Condition produce;
    private Condition consume;
    private Resource resource;

    public Producer(Lock lock, Condition produce, Condition consume, Resource resource){
        this.lock = lock;
        this.produce = produce;
        this.consume = consume;
        this.resource = resource;
    }

    @Override
    public void run() {
        produce();
    }

    volatile boolean flag = true;
    private void produce() {
//        lock.lock();
        while (flag){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() +  "生产开始," + resource.getResource().get());
                if(resource.getResource().get() > 0){
                    try {
//                        System.out.println("资源大于0，唤醒消费，生产沉睡");
                        consume.signal();
                        produce.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        flag = false;
                    }
                }
//                System.out.println("资源小于0，准备生产");
                int res = resource.getResource().incrementAndGet();
                System.out.println(Thread.currentThread().getName() +  "生产后：" + res);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } finally{
//                System.out.println("生产：unlock");
                lock.unlock();
            }
        }
    }

}
