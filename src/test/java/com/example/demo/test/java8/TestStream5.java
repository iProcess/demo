package com.example.demo.test.java8;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream5 {

    public static void main(String[] args) {

        System.out.println(1 << 30);//1073741824
        System.out.println(Integer.MAX_VALUE);//2147483647 2^31 - 1

        System.out.println(1 << 1);

        //java.lang.NullPointerException
//        List<Ant> antList = null;
        List<Ant> antList = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            antList.add(new Ant("ant_" + i, i));
        }

        TestStream5 stream5 = new TestStream5();

        List<Ant> lst = antList.stream()
                .map(a -> {
                    a.setAntAge(20);
                    return a;
                }).map(t -> stream5.encaseAnt(t))
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

    private Ant encaseAnt(Ant a){
//        Ant ant = testAnt(10);
//        a.setAntName(ant.getAntName());//NullPointerException
//        return a;

//        Optional<Ant> ant = Optional.of(testAnt(10));
        Optional<Ant> ant = Optional.ofNullable(testAnt(10));

        a.setAntName(ant.orElse(new Ant("testAnt", 12)).getAntName());
        return a;

    }

    private Ant testAnt(Integer i){
        if(i == 10){
            return null;
        }
        return new Ant("testAnt", 12);
    }
}
