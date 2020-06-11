package com.example.demo.ld.demo3;

import com.example.demo.ld.Apple;

import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {

        JmqConfig config = new JmqConfig("testApp");
        String sinkTopic = "pop_crm_calc_level";

        /**
         * Lambda表达式实现只有一个方法的接口
         */
        JmqSink jk = new JmqSink(config, sinkTopic, (x, y, z) -> {
            System.out.println("x=" + x + ",y=" + y + ",z=" + z.getColor());
            return Collections.singletonList(new Message(x, z.getColor()));
        });

        Apple apple = new Apple();
        apple.setColor("red");
        jk.invoke(config, sinkTopic, apple);

        jk.getCreator().encaseMsg("a", "b", apple);

    }
}
