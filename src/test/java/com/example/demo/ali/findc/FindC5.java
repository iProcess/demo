package com.example.demo.ali.findc;

import java.util.Scanner;

/**
 * https://wenwen.sogou.com/z/q741342661.htm?tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1
 */
public class FindC5 {

    public static void main(String[] args) {
        System.out.println("输入字符串");

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] cs = str.toCharArray();

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
