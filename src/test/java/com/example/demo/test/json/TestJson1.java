package com.example.demo.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson1 {

    public static void main(String[] args) {

        List<Map<String, Object>> listMap = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("drawPins", "123");
        map.put("leadFollowers", "");
        listMap.add(map);

        List<ShopGiftDetail> data = JSON.parseObject(JSON.toJSONString(listMap), new TypeReference<List<ShopGiftDetail>>(){});

        System.out.println(JSON.toJSONString(data));
    }
}
