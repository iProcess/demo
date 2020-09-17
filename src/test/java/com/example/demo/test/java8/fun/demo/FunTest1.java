package com.example.demo.test.java8.fun.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunTest1 {


    public List<Map<String, Object>> display(String name, Function<String, List<Map<String, Object>>> function){

        return function.apply(name);
    }

    public List<Map<String, Object>> encaseName(String name, boolean flag){
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        if(flag){
            map.put(name, "1");
        }else {
            map.put(name, "2");
        }
        listMap.add(map);
        return listMap;
    }

    public void handle(){
        System.out.println(display("测试", (name) -> encaseName(name, true)));
    }


    public static void main(String[] args) {
        FunTest1 test = new FunTest1();
        test.handle();
    }

}
