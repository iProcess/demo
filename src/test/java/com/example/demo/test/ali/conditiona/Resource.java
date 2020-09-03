package com.example.demo.test.ali.conditiona;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Resource {

    private volatile AtomicInteger resource;

    public Resource(int initialValue){
        resource = new AtomicInteger(initialValue);
    }
}
