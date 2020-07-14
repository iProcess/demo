package com.example.demo.jdk8.map;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListMapTest {
    public static void main(String[] args) {
        List<Cookie> cookies = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Cookie cookie = new Cookie();
            cookie.setName("name_" + i);
            cookie.setValue("value_" + i);
            cookies.add(cookie);
        }

        List<Map> listMap = JSON.parseArray(JSON.toJSONString(cookies), Map.class);
        System.out.println(JSON.toJSONString(listMap));

    }
}
