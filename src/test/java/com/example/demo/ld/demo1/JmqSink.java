package com.example.demo.ld.demo1;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JmqSink<IN> {
    public static final int DEFAULT_MESSAGE_BATCH_SIZE = 10;
    public static final int MAX_MESSAGE_BATCH_SIZE = 100;
    private static final int WAIT_RESOURCE_RELEASE_TIME = 1000;
    private static final Logger LOG = LoggerFactory.getLogger(JmqSink.class);
    private JmqConfig config;
    private String topic;
    protected MessageCreator<IN> creator;
    protected int messageBatchSize = 10;

    public JmqSink(JmqConfig config, String topic, MessageCreator<IN> creator) {
        this.config = config;
        this.topic = topic;
        this.creator = creator;
    }

    public void invoke(IN in) {
        try {
            System.out.println(JSON.toJSONString(in));
            List<Message> lists = creator.encaseMsg(topic, in, 1);
            System.out.println(JSON.toJSONString(lists));

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void setMessageBatchSize(int messageBatchSize) {
        this.messageBatchSize = messageBatchSize > 0 ? (messageBatchSize < 100 ? messageBatchSize : 100) : 10;
    }
}
