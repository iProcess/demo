package com.example.demo.test.java8;

import lombok.Data;

@Data
public class Ant {

    private String antName;
    private Integer antAge;

    public Ant(String antName, Integer antAge){
        this.antName = antName;
        this.antAge = antAge;
    }
}
