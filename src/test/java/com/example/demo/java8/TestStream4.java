package com.example.demo.java8;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class TestStream4 {

    public static void main(String[] args) {

        List<Ant> antList = new ArrayList<>();
        for(int i = 1; i <= 1; i++){
            antList.add(new Ant("ant_" + i, i));
        }

        Tao tao = new Tao();
        Cat cat = new Cat();

        List<Cat> marketings1 = antList.stream()
                .map(a -> {
                    Tao t = tao.encaseTao(a.getAntName(), a.getAntAge());
                    log.info("TestStream4-->main, t:{}", JSON.toJSONString(t));
                    return t;
                })
                .map(t -> {
                    Cat c = cat.encaseCat(t.getTaoName(), t.getTaoAge());
                    log.info("TestStream4-->main, t:{}", JSON.toJSONString(c));
                    log.info("TestStream4-->main, t:{}", c == null);
                    log.info("TestStream4-->main, t:{}", "null".equals(c));
                    return c;
                })
//                .filter(ct -> ct != null)
//                或
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        /**
         * 如不进行null处理：filter(ct -> ct != null)
         * 则返回：[null]
         */
        log.info("TestStream4-->main, marketings1:{}", JSON.toJSONString(marketings1));
        log.info("TestStream4-->main, result1:{}", (marketings1 != null && !marketings1.isEmpty()));
        log.info("TestStream4-->main, result2:{}", (marketings1 == null));
        log.info("TestStream4-->main, result3:{}", (marketings1.isEmpty()));
        log.info("TestStream4-->main, result4:{}", (marketings1 != null));
        log.info("TestStream4-->main, result5:{}", (!marketings1.isEmpty()));

        Optional<List<Cat>> opt = Optional.of(marketings1);
        System.out.println(opt.isPresent());//true
        if(opt.isPresent()){
            System.out.println(JSON.toJSONString(opt.get()));//[null]
        }

        Optional<List<Cat>> opt1 = Optional.ofNullable(marketings1);
        System.out.println(opt1.isPresent());//true
        if(opt1.isPresent()){
            System.out.println(JSON.toJSONString(opt1.get()));//[null]
        }




    }
}
