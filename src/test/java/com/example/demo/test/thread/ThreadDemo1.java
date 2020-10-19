package com.example.demo.test.thread;

/**
 * 如何让两个线程依次执行？
 * 假设有两个线程，一个是线程 A，另一个是线程 B，两个线程分别依次打印 1-3 三个数字即可
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        Thread A = new Thread(() -> ThreadUtil.print(1, 3));
        Thread B = new Thread(() -> {
            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadUtil.print(1, 3);
        });
        B.start();
        A.start();
    }

}
