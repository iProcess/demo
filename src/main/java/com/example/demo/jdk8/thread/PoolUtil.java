package com.example.demo.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolUtil {

    /**
     * 监控
     * @param executorService
     */
    public static void monitor(ExecutorService executorService) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        System.out.println("【线程池任务】线程池中曾经创建过的最大线程数：" + threadPoolExecutor.getLargestPoolSize());
        System.out.println("【线程池任务】线程池中线程数：" + threadPoolExecutor.getPoolSize());
        System.out.println("【线程池任务】线程池中活动的线程数：" + threadPoolExecutor.getActiveCount());
        System.out.println("【线程池任务】队列中等待执行的任务数：" + threadPoolExecutor.getQueue().size());
        System.out.println("【线程池任务】线程池已执行完任务数：" + threadPoolExecutor.getCompletedTaskCount());
    }
}
