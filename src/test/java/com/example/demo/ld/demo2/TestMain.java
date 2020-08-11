package com.example.demo.ld.demo2;

import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {

        JmqConfig config = new JmqConfig("testApp");
        String sinkTopic = "calc_level";

        /**
         * Lambda表达式实现只有一个方法的接口
         */
        JmqSink jk = new JmqSink(config, sinkTopic, (x, y, z) -> {
            System.out.println("x=" + x + ",y=" + y + ",z=" + z);
            return Collections.singletonList(new Message(x, y));
        });

        CustomerRecord record = new CustomerRecord();
        record.setCardNo("1234567890");
        jk.invoke(config);

        jk.getCreator().encaseMsg("a", "b", 100);

    }
}
