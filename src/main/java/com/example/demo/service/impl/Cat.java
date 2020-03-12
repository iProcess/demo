package com.example.demo.service.impl;

import com.example.demo.service.MaoService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 3)
public class Cat implements MaoService {
    @Override
    public void say() {
        System.out.println("Cat");
    }
}
