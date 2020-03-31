package com.example.demo.ali.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class Producer implements Callable<Integer> {

    private Resource resource;

    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public Integer call() throws Exception {
        if(resource == null){
            return 0;
        }
        int result = resource.getResource().incrementAndGet();
        log.info("Producer-->call, result:{}", result);
        return result;
    }
}
