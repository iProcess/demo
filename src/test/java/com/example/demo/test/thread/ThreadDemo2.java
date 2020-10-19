package com.example.demo.test.thread;


public class ThreadDemo2 {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread A = new Thread(() -> {
            System.out.println("INFO: A 等待锁");
            synchronized (lock) {
                System.out.println("INFO: A 得到了锁 lock");
                ThreadUtil.print(1, 1);
                try {
                    System.out.println("INFO: A 准备进入等待状态，放弃锁 lock 的控制权");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("INFO: 有人唤醒了 A, A 重新获得锁 lock");
                ThreadUtil.print(2, 2);
                ThreadUtil.print(3, 3);
            }
        });

        Thread B = new Thread(() -> {
            System.out.println("INFO: B 等待锁");
            synchronized (lock) {
                System.out.println("INFO: B 得到了锁 lock");
                ThreadUtil.print(1, 3);
                System.out.println("INFO: B 打印完毕，调用 notify 方法");
                lock.notify();
            }
        });
        A.start();
        B.start();
    }


}
