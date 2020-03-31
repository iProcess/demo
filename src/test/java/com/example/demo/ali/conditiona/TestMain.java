package com.example.demo.ali.conditiona;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者、消费者交叉生产和消费
 * 注：A线程沉睡后，唤起B线程，B线程沉睡后唤起A线程，此时A线程从沉睡的地方开始运行
 */
public class TestMain {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition produce = lock.newCondition();
        Condition consume = lock.newCondition();
        Resource resource = new Resource(0);

        Producer producer = new Producer(lock, produce, consume, resource);
        Consumer consumer = new Consumer(lock, produce, consume, resource);

        consumer.start();
        producer.start();

    }
}
