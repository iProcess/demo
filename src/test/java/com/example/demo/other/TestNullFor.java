package com.example.demo.other;

public class TestNullFor {

    public static void main(String[] args) {

        String[] arrays = null;
        //java.lang.NullPointerException
        for(String array : arrays){
            System.out.println("in for");
            System.out.println(array);
        }
        System.out.println("end");

    }
}
