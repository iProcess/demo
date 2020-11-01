package com.example.demo.test.ali.aly;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 3、通过阻塞队列实现写一个生产者-消费者队列
 * https://www.cnblogs.com/gaopengpy/p/12952910.html
 */
public class BlockingQueue {

    private final int MAX_CAPACITY = 10;
    private ArrayBlockingQueue<Object> goods = new ArrayBlockingQueue<>(MAX_CAPACITY);

    Thread producer = new Thread(() -> {
        while (true) {
            // 每隔 1000 毫秒生产一个商品
            try {
                Thread.sleep(1000);
                goods.put(new Object());
                System.out.println("Produce goods, total: " + goods.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread consumer = new Thread(() -> {
        while (true) {
            // 每隔 5000 毫秒消费一个商品
            try {
                Thread.sleep(5000);
                goods.take();
                System.out.println("Consume goods, total: " + goods.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public void run(){
        producer.start();
        consumer.start();
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        queue.run();
    }

}
