package com.example.demo.test.ali.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class Consumer implements Callable<Integer> {

    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public Integer call() throws Exception {
        if(resource == null){
            return 0;
        }
        int result = resource.getResource().decrementAndGet();
        log.info("Consumer-->call, result:{}", result);
        return result;
    }

}
