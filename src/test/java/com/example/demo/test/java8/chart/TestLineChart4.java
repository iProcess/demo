package com.example.demo.test.java8.chart;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class TestLineChart4 {
    public static void main(String[] args) {
        List<Map<String, Object>> results = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("timestamp", "2020-11-01");
        map1.put("uv", "123");
        map1.put("actiNum", "456");
        map1.put("mainUv", "100");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("timestamp", "2020-11-02");
        map2.put("uv", "789");
        map2.put("actiNum", "147");
        map2.put("mainUv", "200");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("timestamp", "2020-11-03");
        map3.put("uv", "258");
        map3.put("actiNum", "369");
        map3.put("mainUv", "300");

        results.add(map1);
        results.add(map2);
        results.add(map3);

        List<String> dateRange = DateUtil.getDatesFormat("2020-11-01", "2020-11-30", DateUtil.YYYY_MM_DD, DateUtil.YYYYMMDD);

        LineChart chart = encaseTrend(dateRange, results);

        System.out.println(JSON.toJSONString(chart));

    }


    public static LineChart encaseTrend(List<String> categories, List<Map<String, Object>> results){

        Map<String, List<LineChartData>> group = results.stream()
                .map(map -> map.entrySet().stream().map(entry -> new LineChartData(entry.getKey(), Arrays.asList(entry.getValue() == null ? "0" : entry.getValue().toString()))).collect(Collectors.toList()))
                .collect(Collectors.toList())
                .stream()
                .flatMap(f -> f.stream())
                .collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(LineChartData::getCode));

        List<LineChartData> series = group.entrySet().stream()
                .map(entry -> new LineChartData(entry.getKey(), entry.getValue().stream().map(c -> c.getData()).flatMap(d -> d.stream()).collect(Collectors.toList())))
                .collect(Collectors.toList());

        return new LineChart(categories, series);
    }
}
