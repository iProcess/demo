package com.example.demo.test.ali.conditione;

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

        Producer producer1 = new Producer(lock, produce, consume, resource);
        Producer producer2 = new Producer(lock, produce, consume, resource);

        Consumer consumer1 = new Consumer(lock, produce, consume, resource);
        Consumer consumer2 = new Consumer(lock, produce, consume, resource);

        /**
         * 有问题
         *
         * Thread-1生产后：2
         * Thread-1生产开始,2
         * Thread-2消费后：1
         * Thread-3消费后：0
         * Thread-2消费开始,0
         * Thread-3消费开始,0
         * Thread-0生产后：1
         * Thread-0生产开始,1
         * Thread-1生产后：2
         *
         */
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();

    }
}
