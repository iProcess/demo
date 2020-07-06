package com.example.demo.cdl;

public class JoinTest {

    Thread one = new Thread(() -> {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread two = new Thread(() -> {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread three = new Thread(() -> {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread four = new Thread(() -> {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public void run() throws InterruptedException {
        one.start();;
        one.join();

        two.start();
        two.join();

        three.start();
        four.start();
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        joinTest.run();
    }

}
