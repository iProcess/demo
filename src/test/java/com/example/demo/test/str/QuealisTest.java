package com.example.demo.test.str;

public class QuealisTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1 == s2);//true

        String s3 = new String("efg");
        String s4 = new String("efg");
        System.out.println(s3.equals(s4));//true
        System.out.println(s3 == s4);//false
    }
}
