package com.example.demo.ld.demo1;

import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {

        JmqConfig config = new JmqConfig();
        String sinkTopic = "calc_level";

//        MessageCreator<CustomerRecord> creator = new MessageCreator<CustomerRecord>() {
//            @Override
//            public List<Message> create(String var1, CustomerRecord var2) {
//                return null;
//            }
//        };
//        JmqSink<CustomerRecord> jk1 = new JmqSink(config, sinkTopic, creator);
//
//
//        JmqSink<CustomerRecord> jk2 = new JmqSink(config, sinkTopic, new MessageCreator<CustomerRecord>() {
//            @Override
//            public List<Message> create(String var1, CustomerRecord var2) {
//                return null;
//            }
//        });
        /**
         * Lambda表达式实现只有一个方法的接口
         */
        JmqSink<CustomerRecord> jk3 = new JmqSink(config, sinkTopic, (MessageCreator<CustomerRecord>)(x, y, z) -> {
            System.out.println("x=" + x + ",y=" + y.getCardNo() + ",z=" + z);
            return Collections.singletonList(new Message(x, y.getCardNo()));
        });

        CustomerRecord record = new CustomerRecord();
        record.setCardNo("1234567890");
        jk3.invoke(record);

    }
}
