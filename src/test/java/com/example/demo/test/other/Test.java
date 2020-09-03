package com.example.demo.test.other;

public class Test {

    public static int inc(int j){
        return ++j;
    }

    public static void main(String[] args) {
//        for(int i = 0; i < 10; i++){
//            System.out.println(i);
//        }

        int j = 0;
        while ((j = inc(j)) != 10){
            System.out.println(j);
        }
    }

}
