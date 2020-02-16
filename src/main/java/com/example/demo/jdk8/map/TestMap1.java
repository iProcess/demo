package com.example.demo.jdk8.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 18:51
 * Description: TODO
 */
public class TestMap1 {

    public static void main(String[] args) {
        Stream<String> words = Stream.of("Hello","World");
        List<String[]> result = words.map(word -> word.split(""))
                .collect(Collectors.toList());
        System.out.println(result);
        result.forEach(r ->Arrays.stream(r).forEach(x -> System.out.print(x)));
        System.out.println();
        Stream<String> words1 = Stream.of("Hello","World");
        Stream<String> result1 = words1.flatMap(word -> Arrays.stream(word.split("")));
        result1.forEach(r1 -> System.out.print(r1));

        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("b");
        lst.add("c");

//        lst.stream().parallel()
//
//        lst.parallelStream();
//        lst.stream().

    }
}
