package com.example.demo.jdk8.thread.queue;

import com.alibaba.fastjson.JSON;
import com.example.demo.jdk8.thread.PoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ArrayBlockingQueueTest {

    /**
     * 待提交的线程任务
     */
    class ArrayBlockingQueueTask implements Callable<String> {

        private Long testId;
        private String testName;

        public ArrayBlockingQueueTask(Long testId, String testName) {
            this.testId = testId;
            this.testName = testName;
        }

        @Override
        public String call() throws Exception {
            log.info("ArrayBlockingQueueTask-->call, testId:{}, testName:{}", testId, testName);
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
            cs.submit(new ArrayBlockingQueueTask(i, "test_" + i));
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
        log.info("ArrayBlockingQueueTask-->submitThread, lst:{}", JSON.toJSONString(lst));
    }

    public static void main(String[] args) {
        //线程池
        ExecutorService executorService = new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(2),
                new BasicThreadFactory.Builder()
                        .namingPattern("ArrayBlockingQueue-%d")
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        ArrayBlockingQueueTest test = new ArrayBlockingQueueTest();
        test.submitThread(executorService);
    }


}
