package com.example.demo.test.ali.conditionb;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {

    private int queueSize = 10;

    private Lock lock;
    private Condition produce;
    private Condition consume;
    private PriorityQueue<Integer> queue;

    public Producer(Lock lock, Condition produce, Condition consume, PriorityQueue<Integer> queue){
        this.lock = lock;
        this.produce  = produce ;
        this.consume = consume;
        this.queue = queue;
    }

    @Override
    public void run() {
        produce();
    }

    volatile boolean flag = true;
    private void produce() {
        while(flag){
            lock.lock();
            try {
                while(queue.size() == queueSize){
                    try {
                        System.out.println("队列满，等待有空余空间");
                        consume.signal();
                        produce.await();
                    } catch (InterruptedException e) {
                        flag = false;
                    }
                }
                queue.offer(1);        //每次插入一个元素
//                notEmpty.signal();
                System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally{
                lock.unlock();
            }
        }
    }
}
