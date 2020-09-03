package com.example.demo.interview;

public class Singleton {

    //volatile关键字，保证volatile变量的内存可见性，并阻止CPU指令重排
    private static volatile Singleton singleton = null;

    //私有化构造方法，确保不会在其他地方产生新的对象
    private Singleton() {
    }

    //提供唯一方法获取唯一实例
    public static Singleton getInstance() {
        //如果为null则创建实例，否则直接返回，为了在多线程下提高效率，这里不加锁，否则每次只有一个线程可访问获取实例
        if (singleton == null) {
            //可以保证同一时间只会有一个线程进入实例化对象，保证实例的唯一性，并且在第一次实例化完成后，之后的线程在此调用该方法的时候会在前面的if处过滤掉，不会进入锁中，提高效率
            synchronized (Singleton.class) {
                //如果在实例还未被创建时候，有多个线程同时进入第一层if，在此处进行二次判断，可避免多次创建实例
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Singleton.getInstance());
        }, "线程1").start();

        new Thread(() -> {
            System.out.println(Singleton.getInstance());
        }, "线程2").start();

        new Thread(() -> {
            System.out.println(Singleton.getInstance());
        }, "线程3").start();
    }

}
