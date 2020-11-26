package com.example.demo.test.java8.chart;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class TestLineChart5 {
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

        Map<String, Object> map4 = new HashMap<>();
        map4.put("timestamp", "2020-11-15");
        map4.put("uv", "2581");
        map4.put("actiNum", "3691");
        map4.put("mainUv", "3001");

        Map<String, Object> map5 = new HashMap<>();
        map5.put("timestamp", "2020-11-20");
        map5.put("uv", "2582");
        map5.put("actiNum", "3692");
        map5.put("mainUv", "3002");

        Map<String, Object> map6 = new HashMap<>();
        map6.put("timestamp", "2020-11-26");
        map6.put("uv", "2583");
        map6.put("actiNum", "3693");
        map6.put("mainUv", "3003");

        results.add(map1);
        results.add(map2);
        results.add(map3);
        results.add(map4);
        results.add(map5);
        results.add(map6);

        List<String> dateRange = DateUtil.getDates("2020-11-01", "2020-11-30");

        LineChart chart1 = lineChart(dateRange, results, "timestamp");
        System.out.println(JSON.toJSONString(chart1));

    }
    
    
    public static LineChart lineChart(List<String> dateRange, List<Map<String, Object>> results, String dateField){
        results = fill(dateRange, results, dateField);
        Map<String, List<LineChartData>> groupMap = results.stream()
                .map(map -> map.entrySet().stream().map(entry -> {
                    List<String> data = Arrays.asList(entry.getValue() == null ? "0" : entry.getValue().toString());
                    return new LineChartData(entry.getKey(), data);
                }).collect(Collectors.toList()))
                .flatMap(f -> f.stream())
                .collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(LineChartData::getCode));

        List<LineChartData> chartDataList = groupMap.entrySet().stream()
                .map(entry -> {
                    List<String> data = entry.getValue().stream().map(c -> c.getData()).flatMap(d -> d.stream()).collect(Collectors.toList());
                    return new LineChartData(entry.getKey(), data);
                }).collect(Collectors.toList());

        List<String> categories = chartDataList.stream().filter(c -> dateField.equals(c.getCode())).collect(Collectors.toList()).get(0).getData();
        List<LineChartData> series = chartDataList.stream().filter(c -> !dateField.equals(c.getCode())).collect(Collectors.toList());

        return new LineChart(categories, series);
    }

    public static List<Map<String, Object>> fill(List<String> dateRange, List<Map<String, Object>> results, String dateField){
        Map<String, List<Map<String, Object>>> groupMap = results.stream().collect(Collectors.groupingBy(map -> String.valueOf(map.get(dateField))));
        Set<String> keys = results.stream().map(map -> map.keySet()).flatMap(f -> f.stream()).collect(Collectors.toSet());
        List<Map<String, Object>> fills = new ArrayList<>();
        for(String date : dateRange){
            if(groupMap.get(date) != null){
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            for(String key : keys){
                map.put(key, "0");
            }
            map.put(dateField, date);
            fills.add(map);
        }
        results.addAll(fills);
        return results.stream().sorted(Comparator.comparing(curr -> curr.get(dateField).toString())).collect(Collectors.toList());
    }

}
