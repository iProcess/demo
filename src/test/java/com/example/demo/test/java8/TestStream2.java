package com.example.demo.test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream2 {

    public static void main(String[] args) {

        //java.lang.NullPointerException
//        List<String> numbers = null;
        List<String> numbers = Arrays.asList("3", "2", "2", "3", "7", "3", "5");
        List<Integer> lst = numbers.stream()
                .map(i -> Integer.parseInt(i))
                .map(j -> {
                    j++;
                    return j;
                })
                .filter(f -> f >= 10)//不会抛出异常
                .map(m -> {//不会抛出异常
                    m++;
                    return m;
                })
                .collect(Collectors.toList());//不会抛出异常
        System.out.println(lst.size());//不会抛出异常
        System.out.println(lst.toString());//不会抛出异常


    }
}
