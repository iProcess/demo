package com.example.demo.ali.findc;

import java.util.Scanner;


public class FindC6 {

    public static void main(String[] args) {

        char[] cs = {"abcdefgabcdefgaaaaabcdaaaddddgdddgddddddddd"}

        int[] c = new int[256];
        int i = 0;
        while (i < 256) {
            c[i] = 0;
            i++;
        }

        int max = 0;
        for (int j = 0; j < cs.length; j++) {
            c[cs[j]]++;

            if (max < c[cs[j]]++) {
                max = cs[j];
            }
        }

        System.out.println("出现最多的字符是" + (char) max);
    }

}