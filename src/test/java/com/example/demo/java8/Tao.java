package com.example.demo.java8;

import lombok.Data;

@Data
public class Tao {

    private String taoName;
    private Integer taoAge;

    public Tao(){

    }

    public Tao(String taoName, Integer taoAge){
        this.taoName = taoName;
        this.taoAge = taoAge;
    }

    public Tao encaseTao(String taoName, Integer taoAge){
        this.setTaoName(taoName);
        this.setTaoAge(taoAge);
        return this;
    }

}
