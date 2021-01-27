package com.example.demo.test.java8.chart;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class TestLineChart2 {
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
    public static LineChart encaseTrend(List<String> dateRange, List<Map<String, Object>> results){


        List<List<LineChartData>> chartDatas1 =
                results.stream().map(map -> {
                    List<LineChartData> trendDataList =
                    map.entrySet().stream().map(entry -> {
                        LineChartData trendData = new LineChartData(entry.getKey(), Arrays.asList(entry.getValue() == null ? "0" : entry.getValue().toString()));
                        return trendData;
                    }).collect(Collectors.toList());
                    return trendDataList;
                }).collect(Collectors.toList());

        List<LineChartData> d =
        chartDatas1.stream().flatMap(f -> f.stream()).collect(Collectors.toList());

        Map<String, List<LineChartData>> group =
        d.stream().collect(Collectors.groupingBy(LineChartData::getCode));

        List<LineChartData> a =
        group.entrySet().stream().map(entry -> {
            List<String> ls =
            entry.getValue().stream().map(t -> {
                return t.getData();
            }).flatMap(l -> l.stream()).collect(Collectors.toList());
            LineChartData cd = new LineChartData(entry.getKey(), ls);
            return cd;
        }).collect(Collectors.toList());

        LineChart chart = new LineChart(dateRange, a);
        return chart;
    }
}
