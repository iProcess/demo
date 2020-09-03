package com.example.demo.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrinter {
    //计数器，计数到36程序结束
    public int counter = 1;
    //线程执行顺序
    private int order = 1;
    //线程锁
    final Lock lock = new ReentrantLock();
    final Condition c1 = lock.newCondition();
    final Condition c2 = lock.newCondition();
    final Condition c3 = lock.newCondition();

    public void print(int seq) {
        lock.lock();
        try {
            //控制线程执行，没有轮到自己执行时，进入await
            while (order != seq) {
                if (seq == 1) {
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (seq == 2) {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        c3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //计数器小于36，继续执行计数，每个线程执行三次
            if (counter <= 36) {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + counter++);
                }
                System.out.println();
            }
            //控制线程执行顺序
            if (seq == 1) {
                order = 2;
                c2.signal();
            } else if (seq == 2) {
                order = 3;
                c3.signal();
            } else {
                order = 1;
                c1.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ThreadPrinter printer = new ThreadPrinter();
        new Thread(() -> {
            while (printer.counter <= 36) {
                printer.print(1);
            }
        }, "线程1").start();

        new Thread(() -> {
            while (printer.counter <= 36) {
                printer.print(2);
            }
        }, "线程2").start();

        new Thread(() -> {
            while (printer.counter <= 36) {
                printer.print(3);
            }
        }, "线程3").start();
    }

}
