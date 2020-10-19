package com.example.demo.test.thread;

public class ThreadUtil {

    public static void print(int start, int end) {
        System.out.println(Thread.currentThread().getName() + " print:" + start);
        if(start >= end){
            return;
        }
        print(start + 1, end);
    }


}
