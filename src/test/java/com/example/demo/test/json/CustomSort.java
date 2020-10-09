package com.example.demo.test.json;

import lombok.Data;

import java.util.List;

@Data
public class CustomSort {
    /** 策略编码 */
    List<Long> strategy;
    /** 一级类目id */
    List<Long> category;
}
