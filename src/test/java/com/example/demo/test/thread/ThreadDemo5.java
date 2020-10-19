package com.example.demo.test.thread;


import java.util.Random;
import java.util.concurrent.*;

public class ThreadDemo5 {

    public static void doTaskWithResultInWorker() {
        Callable<Integer> callable = () -> {
            System.out.println("Task starts");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += i;
            }
            System.out.println("Task finished and return result");
            return result;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result:" + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }


}
