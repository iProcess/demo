package com.example.demo.test.ali.findc;

import java.util.Map;
import java.util.stream.Collectors;

public class FindC1 {

    public static void main(String[] args) {
        String s = "aab122coo221!!@baa.com";
        System.out.println(s.chars());
        System.out.println(s.chars().boxed());
        Map result = s.chars().boxed()
                .collect(Collectors.groupingBy(i -> (char) i.intValue(), Collectors.counting()));
        System.out.println(result);


    }
}
