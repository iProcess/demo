package com.example.demo.jdk8.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/1 18:32
 * Description: cookie转换为map
 */
public class TestMap4 {

    public static void main(String[] args) {

        Cookie[] cookies = new Cookie[]{};

        Map<String, String> cookieMap = Arrays.stream(cookies).collect(
                Collectors.toMap(Cookie::getName, Cookie::getValue, (o1, o2) -> o2));

        Map<String, String> cookieMap1 = Arrays.stream(cookies).collect(
                Collector.of(HashMap::new,
                        (m, ck) -> m.put(ck.getName(),ck.getValue()),
                        (k, v) -> v,
                        Collector.Characteristics.IDENTITY_FINISH));
    }
}
