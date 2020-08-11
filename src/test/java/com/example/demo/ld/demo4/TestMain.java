package com.example.demo.ld.demo4;

import com.example.demo.ld.Apple;
import com.example.demo.ld.Banana;
import com.example.demo.ld.Orange;

import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {

        JmqConfig config = new JmqConfig("testApp");
        String sinkTopic = "calc_level";

        /**
         * Lambda表达式实现只有一个方法的接口
         */
        JmqSink<Apple, Banana> jk = new JmqSink(config, sinkTopic, (MessageCreator<Apple, Banana>)(x, y, z) -> {
            System.out.println("x=" + x.getColor() + ",y=" + y.getType() + ",z=" + z.getPlace());
            return Collections.singletonList(new Message(x.getColor(), z.getPlace()));
        });

        Apple apple = new Apple();
        apple.setColor("red");

        Banana banana = new Banana();
        banana.setType("XL");

        Orange orange = new Orange();
        orange.setPlace("CN");

        jk.invoke(apple, banana, orange);

        jk.getCreator().encaseMsg(apple, banana, orange);

    }
}
