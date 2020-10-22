package com.example.demo.test.ali.city;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/acbdfe131/article/details/100116972
 */
public class ThreadPrint1 {

    public int num = 1;
    private int bs = 1;
    final Lock lock = new ReentrantLock();
    final Condition c1 = lock.newCondition();
    final Condition c2 = lock.newCondition();
    final Condition c3 = lock.newCondition();

    public void printFive() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + num++);
        }
        System.out.println("                       ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fun(int i) {
        lock.lock();
        try {
            while (bs != i) {
                if (i == 1) {
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (i == 2) {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        c3.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            //功能
            if (num <= 36) {
                printFive();
            }

            if (i == 1) {
                bs = 2;
                c2.signal();
            } else if (i == 2) {
                bs = 3;
                c3.signal();
            } else {
                bs = 1;
                c1.signal();
            }
        } finally {
            // TODO: handle finally clause
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreadPrint1 numPrint = new ThreadPrint1();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (numPrint.num <= 36) {
                    numPrint.fun(1);
                }
            }
        }, "线程1").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (numPrint.num <= 36) {
                    numPrint.fun(2);
                }
            }
        }, "线程2").start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (numPrint.num <= 36) {
                    numPrint.fun(3);
                }
            }
        }, "线程3").start();
    }

}
