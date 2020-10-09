package com.example.demo.test.mythreadlocal;

/**
 * https://zhuanlan.zhihu.com/p/139214244
 */
public class ThreadLocalDemo {

    public static ThreadLocal<String> threadLocal =  new ThreadLocal<String>();

    public static void main(String[] args) {
        ThreadLocalDemo.threadLocal.set("hello world main");
        System.out.println("创建新线程前，主线程" + Thread.currentThread().getName() + "的threadlocal字符值为："  + ThreadLocalDemo.threadLocal.get());

        try {
            Thread thread1 = new Thread(() -> {
                ThreadLocalDemo.threadLocal.set("new thread-1");
                System.out.println("新线程：" + Thread.currentThread().getName() + "的threadlocal字符值为：" + ThreadLocalDemo.threadLocal.get());
            }, "线程1");
            thread1.start();
            thread1.join();

            System.out.println("主线程继续执行...");

            Thread thread2 = new Thread(() -> {
                ThreadLocalDemo.threadLocal.set("new thread-2");
                System.out.println("新线程：" + Thread.currentThread().getName() + "的threadlocal字符值为：" + ThreadLocalDemo.threadLocal.get());
            }, "线程2");
            thread2.start();
            thread2.join();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("创建新线程后，主线程" + Thread.currentThread().getName() + "的threadlocal字符值为："  + ThreadLocalDemo.threadLocal.get());

    }

}
