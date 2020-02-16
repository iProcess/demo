package com.example.demo.util;

import java.util.concurrent.*;

public class AddTask implements Callable<Integer> {

    private int a,b;

    public AddTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        Thread.sleep(5000);  // 模拟送货时间
        Integer result = a + b;
        System.out.println(Thread.currentThread().getName() + ":" + result);
        return result;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            Future<Integer> future = executor.submit(new AddTask(1, 2));
            Integer result = future.get(1L, TimeUnit.SECONDS);// 只有当future的状态是已完成时(future.isDone() = true),get()方法才会返回
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
