package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/25 15:18
 * Description: TODO
 */
public class TestMap {

    public static void main(String[] args) {

        List<String> lst = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        List<MapA> mapA = lst.parallelStream()
                .map(x -> {
                    MapA a = new MapA();
                    a.setUserId(Integer.parseInt(x));
                    a.setUserName("test-" + x);
                    return a;
                })
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(mapA));


//        lst.parallelStream()
////                .mapToInt(x -> Integer.parseInt(x))
////                .filter(x -> x > 5)
////                .flatMap(x -> {
////                    MapA a = new MapA();
////                    a.setUserId(x);
////                    a.setUserName("test-" + x);
////                    return a;
////                })
//
//
//                .map(x -> {
//                    MapA a = new MapA();
//                    a.setUserId(x);
//                    a.setUserName("test-" + x);
//                    return a;
//                })
//                .collect()



    }

}
