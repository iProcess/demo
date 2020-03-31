package com.example.demo.ali.thread;

import java.util.concurrent.*;

/**
 * 有问题，还未调试好
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {

        //创建资源
        Resource resource = new Resource(0);
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 1,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletionService<Integer> cs = new ExecutorCompletionService<>(executorService);

        int i = 0;
        while (i <= 100){
            //提交任务
            cs.submit(producer);
            cs.submit(consumer);
            i ++;
        }

//        int j = 0;
//        while (j <= 100){
//            Integer res = cs.take().get(200,TimeUnit.MILLISECONDS);
//            System.out.println("TestMain-->main, res:" + res);
//            j ++;
//        }


    }

}
