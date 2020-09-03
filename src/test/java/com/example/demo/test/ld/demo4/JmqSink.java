package com.example.demo.test.ld.demo4;

import com.alibaba.fastjson.JSON;
import com.example.demo.test.ld.Orange;
import lombok.Data;

import java.util.List;

@Data
public class JmqSink<R, T> {
    private JmqConfig config;
    private String topic;
    protected MessageCreator<R, T> creator;

    public JmqSink(JmqConfig config, String topic, MessageCreator creator) {
        this.config = config;
        this.topic = topic;
        this.creator = creator;
    }

    public void invoke(R content, T title, Orange orange) {
        try {
            System.out.println(JSON.toJSONString(config));
            List<Message> lists = creator.encaseMsg(content, title, orange);
            System.out.println(JSON.toJSONString(lists));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
