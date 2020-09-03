package com.example.demo.test.cdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.voidcn.com/article/p-coyequpg-ez.html
 * CountDownLatch学习笔记
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        int workerCount = 10;
        CountDownLatch latch = new CountDownLatch(workerCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < workerCount; i++) {
            service.execute(new Worker(i, latch));
        }
        long time = System.currentTimeMillis();
        try {
            //租塞线程，等待工人工作结束
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工作结束，共耗时:" + (System.currentTimeMillis() - time));
        service.shutdown();
    }

}

class Worker implements Runnable {
    private int id;
    private CountDownLatch latch ;
    public Worker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            System.out.println("工人" + this.id + "开始工作." + System.currentTimeMillis());
            Thread.sleep((int)(Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            System.out.println("工人" + this.id + "已完成." + System.currentTimeMillis());
            latch.countDown();
        }
    }
}
