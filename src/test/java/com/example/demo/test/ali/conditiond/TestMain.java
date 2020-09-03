package com.example.demo.test.ali.conditiond;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition实现生产者、消费者模式（队列有数据就开始消费）
 * https://blog.csdn.net/andyzhaojianhui/article/details/79361454
 *
 * Conditon中的await()对应Object的wait()；
 * Condition中的signal()对应Object的notify()；
 * Condition中的signalAll()对应Object的notifyAll()。
 *
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {

        int queueSize = 10;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
        Lock lock = new ReentrantLock();
        Condition produce = lock.newCondition();
        Condition consume = lock.newCondition();

        Producer producer1 = new Producer(lock, produce, consume, queue);
//        Producer producer2 = new Producer(lock, produce, consume, queue);

        Consumer consumer1 = new Consumer(lock, produce, consume, queue);
        Consumer consumer2 = new Consumer(lock, produce, consume, queue);
        Consumer consumer3 = new Consumer(lock, produce, consume, queue);

        producer1.start();
//        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

    }
}
