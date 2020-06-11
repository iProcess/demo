package com.example.demo.ld.demo3;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    protected String topic;
    protected String app;
    protected String businessId;

    public Message(String topic, String businessId){
        this.topic = topic;
        this.businessId = businessId;
    }

}
