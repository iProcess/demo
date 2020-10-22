package com.example.demo.test.demo;

public class DemoTest {
    public static void main(String[] args) {
        int length = 16;
        int hashcode = 10;
        System.out.println(hashcode % length);
        System.out.println(hashcode & (length - 1));
    }
}
