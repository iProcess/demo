package com.example.demo.ld.demo3;

import com.alibaba.fastjson.JSON;
import com.example.demo.ld.Apple;
import lombok.Data;

import java.util.List;

@Data
public class JmqSink {
    private JmqConfig config;
    private String topic;
    protected MessageCreator creator;

    public JmqSink(JmqConfig config, String topic, MessageCreator creator) {
        this.config = config;
        this.topic = topic;
        this.creator = creator;
    }

    public void invoke(JmqConfig config, String title, Apple apple) {
        try {
            System.out.println(JSON.toJSONString(config));
            List<Message> lists = creator.encaseMsg(topic, title, apple);
            System.out.println(JSON.toJSONString(lists));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
