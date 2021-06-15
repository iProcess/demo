package com.example.demo.test.ali.elm1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 经典线程面试题-两个线程交替打印
 *
 * 看到群里发了个面试题，实现两个线程交替打印从1到100，很基础，但是也很考验多线程的基本功，
 * 自己开始能想到的是synchronized 和 wait notifyAll 和Lock ，其他的都是参考网上的博客自己调试整理的
 * 不多说，直接上代码
 * 通用字段，注意volatile的使用，保证可见性
 * ————————————————
 * 版权声明：本文为CSDN博主「xiaoxiaoyunlu」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/afsvsv/article/details/86521789
 *
 */
public class Solution2 {

    public static int i = 1;
    public volatile static int j = 1;
    public volatile static boolean flag = false;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        test2();
    }

    /**
     * （2）使用Lock 实现
     */
    public static void test2() {
        new Thread(() -> {
            while (i < 10) {

                try {
                    lock.lock();
                    while (!flag) {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (j < 10) {

                try {
                    lock.lock();
                    while (flag) {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (j++));
                        flag = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}
