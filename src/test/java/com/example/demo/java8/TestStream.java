package com.example.demo.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    public static Integer handle(String i){
        System.out.println("handle-->" + i);
        int j = Integer.parseInt(i);
        if(j > 3){
            return j + 1;
        }else{
            return j - 1;
        }
    }

    public static void main(String[] args) {
        /**
         * handle-->3
         * handle-->2
         * handle-->2
         * handle-->3
         * 4
         * [2, 1, 1, 2]
         */
        List<String> numbers = Arrays.asList("3", "2", "2", "3", "7", "3", "5");
        List<Integer> lst = numbers.stream().map(i -> TestStream.handle(i)).limit(4).collect(Collectors.toList());
        System.out.println(lst.size());
        System.out.println(lst.toString());

        /**
         * handle-->1
         * handle-->5
         * handle-->4
         * handle-->2
         * 4
         * [0, 6, 5, 1]
         */
        HashMap<String, String> lm =  new LinkedHashMap<>();
        lm.put("1", "test1");
        lm.put("5", "test5");
        lm.put("4", "test4");
        lm.put("2", "test2");
        lm.put("3", "test3");
        List<Integer> lst1 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).limit(4).collect(Collectors.toList());
        System.out.println(lst1.size());
        System.out.println(lst1.toString());

        /**
         * handle-->1
         * handle-->5
         * handle-->4
         * handle-->2
         * handle-->3
         * 2
         * [6, 5]
         */
        List<Integer> lst2 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).filter(j -> j >= 5).limit(4).collect(Collectors.toList());
        System.out.println(lst2.size());
        System.out.println(lst2.toString());

        /**
         * handle-->1
         * handle-->5
         * handle-->4
         * 2
         * [6, 5]
         */
        List<Integer> lst3 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).filter(j -> j >= 5).limit(2).collect(Collectors.toList());
        System.out.println(lst3.size());
        System.out.println(lst3.toString());

        /**
         * handle-->1
         * handle-->5
         * handle-->4
         * 2
         * [0, 5]
         */
        List<Integer> lst4 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).filter(j -> j <= 5).limit(2).collect(Collectors.toList());
        System.out.println(lst4.size());
        System.out.println(lst4.toString());

        /**
         * handle-->1
         * handle-->5
         * 2
         * [0, 6]
         */
        List<Integer> lst5 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).filter(j -> j % 2 == 0).limit(2).collect(Collectors.toList());
        System.out.println(lst5.size());
        System.out.println(lst5.toString());

        /**
         * handle-->1
         * handle-->5
         * handle-->4
         * handle-->2
         * handle-->3
         * 1
         * [0]
         */
        List<Integer> lst6 = lm.entrySet().stream().map(e -> TestStream.handle(e.getKey())).filter(j -> j == 0).limit(2).collect(Collectors.toList());
        System.out.println(lst6.size());
        System.out.println(lst6.toString());

        /**
         * 第一次
         * handle-->3
         * handle-->2
         * handle-->5
         * handle-->4
         * handle-->1
         * 2
         * [6, 5]
         * 第二次
         * handle-->4
         * handle-->1
         * handle-->5
         * handle-->3
         * handle-->2
         * 2
         * [6, 5]
         * 第三次
         * handle-->1
         * handle-->2
         * handle-->3
         * handle-->5
         * handle-->4
         * 2
         * [6, 5]
         * 第四次
         * handle-->4
         * handle-->1
         * handle-->2
         * handle-->3
         * handle-->5
         * 2
         * [6, 5]
         */
        List<Integer> lst7 = lm.entrySet().parallelStream().map(e -> TestStream.handle(e.getKey())).filter(j -> j >= 5).limit(2).collect(Collectors.toList());
        System.out.println(lst7.size());
        System.out.println(lst7.toString());
    }
}
