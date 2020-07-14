package com.example.demo.jdk8.map.fm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntersectByKeyTest {

    public static void main(String[] args) {

        List<Data2> listOfData2 = new ArrayList<Data2>();
        listOfData2.add(new Data2(10501, "JOE"  , "Type1"));
        listOfData2.add(new Data2(10603, "SAL"  , "Type5"));
        listOfData2.add(new Data2(40514, "PETER", "Type4"));
        listOfData2.add(new Data2(59562, "JIM"  , "Type2"));
        listOfData2.add(new Data2(29415, "BOB"  , "Type1"));
        listOfData2.add(new Data2(61812, "JOE"  , "Type9"));
        listOfData2.add(new Data2(98432, "JOE"  , "Type7"));
        listOfData2.add(new Data2(62556, "JEFF" , "Type1"));
        listOfData2.add(new Data2(10599, "TOM"  , "Type4"));


        List<Data1> listOfData1 = new ArrayList<Data1>();
        listOfData1.add(new Data1(10501, "JOE"    ,3000000));
        listOfData1.add(new Data1(10603, "SAL"    ,6225000));
        listOfData1.add(new Data1(40514, "PETER"  ,2005000));
        listOfData1.add(new Data1(59562, "JIM"    ,3000000));
        listOfData1.add(new Data1(29415, "BOB"    ,3000000));

        List<OutputData> result = listOfData1.stream()
                .flatMap(x -> listOfData2.stream()
                        .filter(y -> x.getId() == y.getId())
                        .map(y -> new OutputData(y.getId(), x.getName(), y.getType(), x.getAmount())))
                .collect(Collectors.toList());
        System.out.println(result);
        //list 转 list<Map>
        List<Map<String, Object>> list = JSON.parseObject(JSON.toJSONString(result), List.class);
        System.out.println(JSON.toJSONString(list));

        /*difference by key*/
        List<Data1> data1IntersectResult = listOfData1.stream()
                .filter(data1 -> listOfData2.stream()
                        .map(Data2::getId)
                        .collect(Collectors.toList())
                        .contains(data1.getId()))
                .collect(Collectors.toList());
        System.out.println(data1IntersectResult);
    }

}
