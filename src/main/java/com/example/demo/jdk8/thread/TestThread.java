package com.example.demo.jdk8.thread;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/17 18:21
 * Description: TODO
 */
public class TestThread {

    public ExecutorService executorService = new ThreadPoolExecutor(20, 50, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(),

/**
 * 创建ThreadFactory实例的多种方式
 * spring的CustomizableThreadFactory
 *
 * guava的ThreadFactoryBuilder链式方法。这个最好用
 *
 * commons-lang3的BasicThreadFactory
 */
//            new ThreadFactory() {
//                @Override
//                public Thread newThread(Runnable r) {
//                    Thread thread = new Thread(r);
//                    thread.setName("pull javadoc thread" + thread.getId());
//                    return thread;
//                }
//            },

            Executors.defaultThreadFactory(),

            new ThreadPoolExecutor.AbortPolicy());


    class AreaStockAndRealPrice implements Callable<String> {

        private String name;
        private Long venderId;

        public AreaStockAndRealPrice(String name, Long venderId) {
            this.name = name;
            this.venderId = venderId;
        }

        @Override
        public String call() throws Exception {
            System.out.println("name=" + name + ", venderId=" + venderId);
            return "name=" + name + ", venderId=" + venderId;
        }

    }

    public void threadMethod(){
        CompletionService<String> cs = new ExecutorCompletionService<>(executorService);
        for(Long i = 0L; i < 5L; i++) {
            cs.submit(new AreaStockAndRealPrice("test", i));
        }
        List<String> lst = new ArrayList<>();
        for(Long i = 0L; i < 4L; i++) {
            try {
                String str = cs.take().get(200,TimeUnit.MILLISECONDS);
                lst.add(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(JSON.toJSONString(lst));

    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.threadMethod();
    }

}
