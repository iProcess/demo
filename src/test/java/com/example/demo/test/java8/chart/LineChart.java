package com.example.demo.test.java8.chart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LineChart {
    /**
     * 日期范围
     */
    private List<String> categories;
    /**
     * 日期范围对应指标数据
     */
    private List<LineChartData> series;
}
