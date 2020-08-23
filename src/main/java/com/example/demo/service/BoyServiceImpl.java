package com.example.demo.service;

import com.example.demo.asp.Retry;
import org.springframework.stereotype.Service;

@Service
public class BoyServiceImpl implements BoyService {

    @Retry
    @Override
    public String sayHi(String hi) {
        int i = 1;
        int j = i / 0;
        System.out.println("BoyServiceImpl-->sayHi");
        return "拼接：" + hi;
    }
}
