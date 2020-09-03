package com.example.demo.test.ali.aly;

import java.util.concurrent.Semaphore;

/**
 * 三个线程分别打印A，B，C，要求这三个线程一起运行，打印n次，输出形如“ABCABCABC....”的字符串。
 * https://segmentfault.com/a/1190000016773721
 */
public class ThreadPrint2 {

    private int times;
    //信号量，只允许 1个线程同时访问
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public ThreadPrint2(int times) {
        this.times = times;
    }

    public static void main(String[] args) {

        ThreadPrint2 printABC = new ThreadPrint2(10);

        // 非静态方法引用  x::toString   和() -> x.toString() 是等价的！
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();

//        new Thread(() -> printABC.printA()).start();
//        new Thread(() -> printABC.printB()).start();
//        new Thread(() -> printABC.printC()).start();
    }

    public void printA() {
        try {
            print("A", semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            print("B", semaphoreB, semaphoreC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            print("C", semaphoreC, semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name, Semaphore current, Semaphore next) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            // 从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
            current.acquire();
            System.out.print(name);
            if("C".equals(name)){
                System.out.println();
            }
            // 释放一个许可，将其返回给信号量。
            next.release();
        }
    }

}
