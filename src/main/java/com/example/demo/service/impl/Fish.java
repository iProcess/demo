package com.example.demo.service.impl;

import com.example.demo.service.MaoService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 2)
public class Fish implements MaoService {
    @Override
    public void say() {
        System.out.println("Fish");
    }
}
