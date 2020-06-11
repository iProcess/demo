package com.example.demo.ld.demo4;

import lombok.Data;

import java.io.Serializable;

@Data
public class JmqConfig implements Serializable {

    private String app;

    public JmqConfig(String app) {
        this.app = app;
    }
}
