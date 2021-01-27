package com.example.demo.test.java8.chart;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class TestLineChart {
    public static void main(String[] args) {
        List<Map<String, Object>> results = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("timestamp", "2020-11-01");
        map1.put("uv", "123");
        map1.put("actiNum", "456");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("timestamp", "2020-11-02");
        map2.put("uv", "789");
        map2.put("actiNum", "147");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("timestamp", "2020-11-03");
        map3.put("uv", "258");
        map3.put("actiNum", "369");

        results.add(map1);
        results.add(map2);
        results.add(map3);

        List<String> dateRange = DateUtil.getDatesFormat("2020-11-01", "2020-11-30", DateUtil.YYYY_MM_DD, DateUtil.YYYYMMDD);

        LineChart chart = encaseTrend(dateRange, results, "timestamp");

        System.out.println(JSON.toJSONString(chart));

    }
    public static LineChart encaseTrend(List<String> dateRange, List<Map<String, Object>> results, String dateField){
//        Map<String, Map<String, Object>> keyMap = new LinkedHashMap<>();
//
//        Set<String> groupKey = new HashSet<>();
//        for(String key : groupKey){
//            Map<String, Map<String, Object>> pdMap = results.stream().collect(Collectors.toMap(map -> String.valueOf(map.get(key)),
//                    Function.identity(), (k1, k2) -> k2, ConcurrentHashMap::new));
//
//            Map<Object, List<Map<String, Object>>> group = results.stream().collect(Collectors.groupingBy(map -> map.get(key)));
//
//            results.stream().collect(Collectors.groupingBy(map -> map.get(key))).entrySet().stream().map(e -> {
//                ChartData trendData = new ChartData();
//                trendData.setCode(String.valueOf(e.getKey()));
//
//                List<Map<String, Object>> listMap = e.getValue();
//
//                e.getValue().stream().map(s -> s.entrySet().stream().map( -> {}))
//
//            })
//
//            List<Map<String, Object>> mapList = new ArrayList<>();
//
//            mapList = results.stream().collect(Collectors.groupingBy(map -> map.get(key)))
//
//                    .entrySet().stream().map(e -> {
//                        Map<String, Object> resultMap = new HashMap<>();
//                        resultMap.put("items", e.getValue());
//                        resultMap.put("name", e.getKey());
//                        return resultMap;
//                    }).collect(Collectors.toList());
//
//        }

        List<Map<String, List<LineChartData>>> chartDatas =
        results.stream().map(map -> {
            //map.values();
            Map<String, List<LineChartData>> mapList = new HashMap<>();
            List<LineChartData> trendDataList = new ArrayList<>();
            map.forEach((k, v) -> {
                LineChartData trendData = new LineChartData(k, Arrays.asList(v == null ? "0" : v.toString()));
                trendDataList.add(trendData);
            });
            mapList.put(dateField, trendDataList);
            return mapList;
            //Set<String> keys = map.keySet();
        }).collect(Collectors.toList());
        //}).collect(Collectors.toMap( return dateField;},
        //            Function.identity(), (k1, k2) -> k2, ConcurrentHashMap::new));


        //Collectors.groupingBy(ChartData::getCode)


        List<List<LineChartData>> chartDatas1 =
                results.stream().map(map -> {
                    //map.values();
                    //Map<String, List<ChartData>> mapList = new HashMap<>();
                    List<LineChartData> trendDataList = new ArrayList<>();
                    map.forEach((k, v) -> {
                        LineChartData trendData = new LineChartData(k, Arrays.asList(v == null ? "0" : v.toString()));
                        trendDataList.add(trendData);
                    });
                    //mapList.put(dateField, trendDataList);
                    return trendDataList;
                    //Set<String> keys = map.keySet();
                }).collect(Collectors.toList());
        //}).collect(Collectors.toMap( return dateField;},
        //            Function.identity(), (k1, k2) -> k2, ConcurrentHashMap::new));


        //Collectors.groupingBy(ChartData::getCode)

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

            return new LineChartData(entry.getKey(), ls);
        }).collect(Collectors.toList());


        LineChart chart = new LineChart(dateRange, a);
        return chart;
    }
}
