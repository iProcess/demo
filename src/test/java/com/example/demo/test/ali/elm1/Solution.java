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
public class Solution {

    public static int i = 1;
    public volatile static int j = 1;
    public volatile static boolean flag = false;
    public static int count = 0;

    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();

    private static CountDownLatch latch = new CountDownLatch(2);
    private static AtomicInteger numA = new AtomicInteger();
    private static AtomicInteger numB = new AtomicInteger();

    private static byte[] block = new byte[0];

    public static void main(String[] args) {
        test5();
    }

    /**
     * （5）使用 synchronized 和 wait notifyAll 来实现
     */
    public static void test5() {
        new Thread(() -> {
            while (i < 10) {
                synchronized (block) {
                    if (flag) {
                        try {
                            block.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = true;
                        block.notifyAll();
                    }

                }
            }
        }).start();

        new Thread(() -> {
            while (j < 10) {
                synchronized (block) {

                    if (!flag) {
                        try {
                            block.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (j++));
                        flag = false;
                        block.notifyAll();
                    }

                }
            }
        }).start();
    }

    /**
     * （4）利用 AtomicInteger 和 volatile
     */
    public static void test4() {

        new Thread(() -> {
            while (numA.get() < 10) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (numA.incrementAndGet()));
                    flag = true;
                }
                //   latch.countDown();

            }
        }).start();

        new Thread(() -> {
            while (numB.get() < 10) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (numB.incrementAndGet()));
                    flag = false;
                }
                //	latch.countDown();

            }
        }).start();

    }

    /**
     * （3）使用Lock 和 Condition 类实现，更加灵活一点
     */
    public static void test3() {

        new Thread(() -> {
            try {
                lock.lock();
                while (i < 10) {
                    if (flag) {
                        conditionA.await();
                    }
                    flag = true;
                    System.out.println(Thread.currentThread().getName() + "----"
                            + (i++));
                    conditionB.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }	).start();

        new Thread(() -> {

            try {
                lock.lock();
                while (j < 10) {
                    if (!flag) {
                        conditionB.await();
                    }
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "----"
                            + (j++));
                    conditionA.signal();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }	).start();
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

    /**
     * （1）使用信号去判断
     */
    public static void test1() {
        new Thread(() -> {
            while (i < 10) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (i++));
                    flag = true;
                }
            }
        }).start();

        new Thread(() -> {
            while (j < 10) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (-j++));
                    flag = false;
                }
            }
        }).start();
    }


}
