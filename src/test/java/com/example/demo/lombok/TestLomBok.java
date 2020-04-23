package com.example.demo.lombok;

import lombok.Setter;

public class TestLomBok {

    @Setter
    public String name;

    public static void main(String[] args) {
        TestLomBok bok = new TestLomBok();
        bok.setName("123");
        System.out.println(bok.name);
    }

}
