package com.example.demo.test.ali.aly;

/**
 * 1、编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"
 * https://www.cnblogs.com/gaopengpy/p/12913519.html
 */
public class ThreadPrint {

    /**
     * 只有一个线程在加和判断，故不用考虑原子性和内存可见性；
     * 第三个线程count++之后，先判断了count是否等于10，如等于就停止了，不等于才会给a赋值，所以，其它两个线程一直在运行，但a值不符合条件，所以不会打印
     */
    private Integer count = 0;

    /**
     * volatile保证了内存可见性，当a值变更时，其它线程能立即获取到最新值。
     * 注：a即使是静态变量也不能保证值发生变化后，其它线程能立即获取到最新值。
     */
//    private static Integer a = 0;
    private volatile Integer a = 0;

    Thread one = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                if(a == 0){
                    System.out.print("X");
                    a = 1;
                }
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        }
    });

    Thread two = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                if(a == 1){
                    System.out.print("Y");
                    a = 2;
                }
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        }
    });

    Thread three = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                if(a == 2){
                    System.out.println("Z");
                    count++;
                    if(count == 10){
                        System.exit(0);
                    }
                    a = 0;

                }
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        }
    });

    public void run(){
        one.start();
        two.start();
        three.start();
    }

    public static void main(String[] args) {
        ThreadPrint print = new ThreadPrint();
        print.run();
    }

}
