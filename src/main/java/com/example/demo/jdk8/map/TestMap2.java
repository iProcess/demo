package com.example.demo.jdk8.map;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/1 11:29
 * Description: TODO
 */
public class TestMap2 {

    public static void main(String[] args) {
        String[] strs = new String[]{"a:1","b:2","c:3","d:4","e:5","f:6","g:7"};

        List<String[]> result = Arrays.stream(strs).map(ck -> ck.split(":")).collect(Collectors.toList());
        //[["a","1"],["b","2"],["c","3"],["d","4"],["e","5"],["f","6"],["g","7"]]
        System.out.println(JSON.toJSONString(result));

        List<String> result1 = Arrays.stream(strs).flatMap(ck -> Arrays.stream(ck.split(":"))).collect(Collectors.toList());
        //["a","1","b","2","c","3","d","4","e","5","f","6","g","7"]
        System.out.println(JSON.toJSONString(result1));

        HashMap<String, String> map = Arrays.stream(strs).collect(
                Collector.of(
                // supplier参数用于生成结果容器，容器类型为R
                HashMap::new,
                // accumulator用于消费元素，也就是归纳元素，这里的T就是元素，它会将流中的元素一个一个与结果容器R发生操作
                (m, per) -> m.put(per.split(":")[0], per.split(":")[1]),
                // combiner用于两个两个合并并行执行的线程的执行结果，将其合并为一个最终结果R
                (k, v) -> v,
                // characteristics表示当前Collector的特征值，拥有三个值：CONCURRENT（多线程并行），UNORDERED（无序），IDENTITY_FINISH（无需转换结果）
                Collector.Characteristics.IDENTITY_FINISH));
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.get("a"));

    }

}
