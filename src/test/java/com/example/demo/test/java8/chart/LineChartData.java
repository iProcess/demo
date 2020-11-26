package com.example.demo.test.java8.chart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LineChartData {
    /**
     * 指标标识
     */
    private String code;
    /**
     * 指标数据
     */
    private List<String> data;
}
