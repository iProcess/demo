package com.example.demo.jdk8.stream;

import lombok.Data;

@Data
public class Apple {
    private String id;
    private String weight;
    private int weightInt;

    public Apple(String id, String weight){
        this.id = id;
        this.weight = weight;
    }

}
