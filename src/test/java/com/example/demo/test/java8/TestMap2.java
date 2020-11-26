package com.example.demo.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMap2 {
    public static void main(String[] args) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("name", "张三");
        map1.put("age", 1);
        map1.put("school", "北京大学");

        Map map2 = new HashMap();
        map2.put("name", "张三");
        map2.put("age", 2);
        map2.put("school", "清华大学");

        Map map3 = new HashMap();
        map3.put("name", "张三");
        map3.put("age", 3);
        map3.put("school", "青岛大学");

        Map map4 = new HashMap();
        map4.put("name", "李四");
        map4.put("age", 9);
        map4.put("school", "人民大学");

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        Map<Object,List<Map<String,Object>>> group = mapList.stream().collect(Collectors.groupingBy(m -> m.get("name")));
        System.out.println(group);

        // {李四=[{school=人民大学, name=李四, age=9}], 张三=[{school=北京大学, name=张三, age=1}, {school=清华大学, name=张三, age=2}, {school=青岛大学, name=张三, age=3}]}

        mapList = mapList.stream().collect(Collectors.groupingBy(e -> e.get("name")))
                .entrySet().stream().map(e -> {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("items", e.getValue());
                    resultMap.put("name", e.getKey());
                    return resultMap;
                }).collect(Collectors.toList());
        System.out.println(mapList);
        //[{name=李四, items=[{school=人民大学, name=李四, age=9}]}, {name=张三, items=[{school=北京大学, name=张三, age=1}, {school=清华大学, name=张三, age=2}, {school=青岛大学, name=张三, age=3}]}]

    }

}
