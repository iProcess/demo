package com.example.demo.jdk8.thread.pool;

import com.alibaba.fastjson.JSON;
import com.example.demo.jdk8.thread.PoolUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class CachedThreadPoolTest {

    /**
     * 待提交的线程任务
     */
    class CachedThreadPoolTask implements Callable<String> {

        private Long testId;
        private String testName;

        public CachedThreadPoolTask(Long testId, String testName) {
            this.testId = testId;
            this.testName = testName;
        }

        @Override
        public String call() throws Exception {
            log.info("CachedThreadPoolTask-->call, testId:{}, testName:{}", testId, testName);
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
            cs.submit(new CachedThreadPoolTask(i, "test_" + i));
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
        log.info("CachedThreadPoolTask-->submitThread, lst:{}", JSON.toJSONString(lst));
    }

    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        CachedThreadPoolTest test = new CachedThreadPoolTest();
        test.submitThread(executorService);
    }


}
