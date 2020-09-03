package com.example.demo.test.fastjson;

public class Item {
    private String name;
    private String value;
    // 此处省略getter和setter方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "name=" + name + ", value=" + value;
    }
}
