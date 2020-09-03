package com.example.demo.test.ali.conditionb;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {

    private Lock lock;
    private Condition produce;
    private Condition consume;
    private PriorityQueue<Integer> queue;

    public Consumer(Lock lock, Condition produce, Condition consume, PriorityQueue<Integer> queue){
        this.lock = lock;
        this.produce  = produce ;
        this.consume = consume;
        this.queue = queue;
    }

    @Override
    public void run() {
        consume();
    }

    volatile boolean flag = true;
    private void consume() {
        while(flag){
            lock.lock();
            try {
                while(queue.size() == 0){
                    try {
                        System.out.println("队列空，等待数据");
                        produce.signal();
                        consume.await();
                    } catch (InterruptedException e) {
                        flag = false;
                    }
                }
                queue.poll();                //每次移走队首元素
//                notFull.signal();
                System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
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
