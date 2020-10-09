package com.example.demo.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

import java.util.*;

public class JSONTest {

    public static void main(String[] args) {
        String json = "[\n" +
                "    {\n" +
                "        \"strategy\": [1001, 1002,1003], \n" +
                "        \"category\": [123, 456, 789]\n" +
                "    }, \n" +
                "    {\n" +
                "        \"strategy\": [1001, 1002, 1004], \n" +
                "        \"category\": [456, 789, 234]\n" +
                "    }, \n" +
                "    {\n" +
                "        \"strategy\": [1002, 1003, 1004], \n" +
                "        \"category\": [234, 567, 890]\n" +
                "    }\n" +
                "]";

        List<CustomSort> customSorts = JSON.parseObject(json, new TypeReference<List<CustomSort>>(){});
        System.out.println(customSorts);

        Set<Long> strategys = new LinkedHashSet<>();
        for(CustomSort cs : customSorts){
            strategys.addAll(cs.getStrategy());
        }
        System.out.println(strategys);



    }
}
