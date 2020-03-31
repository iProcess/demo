package com.example.demo.jdk8.thread.queue;

import com.alibaba.fastjson.JSON;
import com.example.demo.jdk8.thread.PoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class SynchronousQueueTest {

    /**
     * 待提交的线程任务
     */
    class SynchronousQueueTask implements Callable<String> {

        private Long testId;
        private String testName;

        public SynchronousQueueTask(Long testId, String testName) {
            this.testId = testId;
            this.testName = testName;
        }

        @Override
        public String call() throws Exception {
            log.info("SynchronousQueueTask-->call, testId:{}, testName:{}", testId, testName);
            Thread.sleep(10000);
            return "testId=" + testId + "&testName=" + testName;
        }

    }

    /**
     * 提交任务
     * @param executorService
     */
    public void submitThread(ExecutorService executorService){
        CompletionService<String> cs = new ExecutorCompletionService<>(executorService);
        PoolUtil.monitor(executorService);
        for(Long i = 1L; i <= 10L; i++) {
            cs.submit(new SynchronousQueueTask(i, "test_" + i));
        }
        PoolUtil.monitor(executorService);
        List<String> lst = new ArrayList<>();
        for(Long i = 1L; i <= 10L; i++) {
            try {
//                String str = cs.take().get(200,TimeUnit.MILLISECONDS);
                String str = cs.take().get();
                lst.add(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PoolUtil.monitor(executorService);
        log.info("SynchronousQueueTask-->submitThread, lst:{}", JSON.toJSONString(lst));
    }

    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 8, 1, TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>(),
                new BasicThreadFactory.Builder()
                        .namingPattern("SynchronousQueueTask-%d")
                        .build(),
                new ThreadPoolExecutor.AbortPolicy());

        SynchronousQueueTest test = new SynchronousQueueTest();
        test.submitThread(executorService);
    }


}
