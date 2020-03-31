package com.example.demo.jdk8.thread.queue;

import com.alibaba.fastjson.JSON;
import com.example.demo.jdk8.thread.PoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class LinkedBlockingQueueTest {

    /**
     * 待提交的线程任务
     */
    class LinkedBlockingQueueTask implements Callable<String> {

        private Long testId;
        private String testName;

        public LinkedBlockingQueueTask(Long testId, String testName) {
            this.testId = testId;
            this.testName = testName;
        }

        @Override
        public String call() throws Exception {
            log.info("LinkedBlockingQueueTask-->call, testId:{}, testName:{}", testId, testName);
            Thread.sleep(5000);
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
        for(Long i = 1L; i <= 5L; i++) {
            cs.submit(new LinkedBlockingQueueTask(i, "test_" + i));
        }
        PoolUtil.monitor(executorService);
        List<String> lst = new ArrayList<>();
        for(Long i = 1L; i <= 5L; i++) {
            try {
                String str = cs.take().get(200,TimeUnit.MILLISECONDS);
                lst.add(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PoolUtil.monitor(executorService);
        log.info("LinkedBlockingQueueTask-->submitThread, lst:{}", JSON.toJSONString(lst));
    }

    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(),
                new BasicThreadFactory.Builder()
                        .namingPattern("LinkedBlockingQueue-%d")
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        LinkedBlockingQueueTest test = new LinkedBlockingQueueTest();
        test.submitThread(executorService);
    }


}
