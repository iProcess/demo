package com.example.demo.test.thread;


import java.util.concurrent.CountDownLatch;

public class ThreadDemo3 {

    public static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(() -> {
            System.out.println("D is waiting for other three threads");
            try {
                countDownLatch.await();
                System.out.println("All done, D starts working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (char threadName='A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(() -> {
                System.out.println(tN + " is working");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(tN + " finished");
                countDownLatch.countDown();
            }).start();
        }
    }

    public static void main(String[] args) {
        runDAfterABC();
    }


}
