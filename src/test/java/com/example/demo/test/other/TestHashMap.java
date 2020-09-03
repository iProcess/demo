package com.example.demo.test.other;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("abc", "123");
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.keySet());
        System.out.println(map.values());

        String p = map.put("abc", "123abc");

        System.out.println(p);
        System.out.println(map.get("abc"));

        map.put(null, "testNull");//正常

        map.put("nullKey", null);//正常

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
