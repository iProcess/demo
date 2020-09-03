package com.example.demo.test.java8;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream3 {

    public static void main(String[] args) {

        //java.lang.NullPointerException
//        List<Ant> antList = null;
        List<Ant> antList = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            antList.add(new Ant("ant_" + i, i));
        }

        List<Ant> lst = antList.stream()
                .map(a -> {
                    a.setAntAge(20);
                    return a;
                })
                .filter(t -> StringUtils.isEmpty(t.getAntName()))
                .map(n -> {
                    System.out.println("map-->n:" + JSON.toJSONString(n));
                    return n;
                })
                .collect(Collectors.toList());//不会抛出异常

        System.out.println(lst.size());//不会抛出异常
        System.out.println(lst.toString());//不会抛出异常

        System.out.println(lst != null && !lst.isEmpty());

    }
}
