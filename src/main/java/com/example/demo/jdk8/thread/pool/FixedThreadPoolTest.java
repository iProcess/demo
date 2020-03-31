package com.example.demo.jdk8.thread.pool;

import com.alibaba.fastjson.JSON;
import com.example.demo.jdk8.thread.PoolUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class FixedThreadPoolTest {

    /**
     * 待提交的线程任务
     */
    class FixedThreadPoolTask implements Callable<String> {

        private Long testId;
        private String testName;

        public FixedThreadPoolTask(Long testId, String testName) {
            this.testId = testId;
            this.testName = testName;
        }

        @Override
        public String call() throws Exception {
            log.info("FixedThreadPoolTask-->call, testId:{}, testName:{}", testId, testName);
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
            cs.submit(new FixedThreadPoolTask(i, "test_" + i));
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
        log.info("FixedThreadPoolTask-->submitThread, lst:{}", JSON.toJSONString(lst));
    }



    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FixedThreadPoolTest test = new FixedThreadPoolTest();
        test.submitThread(executorService);
    }


}
