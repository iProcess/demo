package com.example.demo.java8;

import lombok.Data;

@Data
public class Cat {

    private String catName;
    private Integer catAge;

    public Cat(){

    }

    public Cat(String catName, Integer catAge){
        this.catName = catName;
        this.catAge = catAge;
    }

    public Cat encaseCat(String catName, Integer catAge){
        this.setCatName(catName);
        this.setCatAge(catAge);
        return null;
    }

}
