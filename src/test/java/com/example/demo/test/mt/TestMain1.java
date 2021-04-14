package com.example.demo.test.mt;

import java.util.concurrent.TimeUnit;

/**
 * A、B、C三个线程，分别打印A、B、C，要求打印出ABC，打印100次
 * 另一个例子：
 * com.example.demo.test.ali.aly.ThreadPrint
 */
public class TestMain1 {

    private int count = 10;
    /**
     * volatile保证了内存可见性，当a值变更时，其它线程能立即获取到最新值。
     * 注：即使是静态变量也不能保证值发生变化后，其它线程能立即获取到最新值。
     */
    private volatile int sign = 0;

    Thread threadA = new Thread(() -> {
                while (true){
                    if(sign == 0){
                        System.out.print("A");
                        sign++;
                    }
                    sleep();
                }
            }
    );

    Thread threadB = new Thread(() -> {
        while (true){
            if(sign == 1){
                System.out.print("B");
                sign++;
            }
            sleep();
        }
    });

    Thread threadC = new Thread(() -> {
        while (true){
            if(sign == 2){
                System.out.println("C");
                count--;
                if(count == 0){
                    System.exit(0);
                }
                sign = 0;
            }
            sleep();
        }
    });

    public void run(){
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        TestMain1 main = new TestMain1();
        main.run();
    }


}
