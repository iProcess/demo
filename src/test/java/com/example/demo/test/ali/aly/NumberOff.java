package com.example.demo.test.ali.aly;

/**
 * 2、标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
 * https://www.cnblogs.com/gaopengpy/p/12990165.html
 */
public class NumberOff {


    public static int numberOff(int n) {

        if (n < 1) {
            throw new IllegalArgumentException("人数不能小于1");
        }

        int num = 0; // 模拟报数 1~3
        int outCount = 0; // 退出人数
        int[] persons = new int[n + 1];// 初始化人数列表

        // 给每个人进行标号，以便获取最后留下那个人的编号
        for (int i = 1; i <= n; i++) {
            persons[i] = i;
        }

        int j = 1;
        while (true) {
            if (j > n) { // 如果j>n; 重新开始 j=1;
                j = 1;
            }

            if (persons[j] != 0) { // 如果这个人没有退出，则报数
                num++;
            }

            if (num == 3 && outCount != n - 1) { // 如果退出人数不等于或者说小于n-1, 则表示游戏未结束
                num = 0; // num重置
                persons[j] = 0; // 表示此人退出
                outCount++; // 退出人数+1
            } else if (outCount == n - 1) { // 只剩下最后一人，表示此人是幸存者
                return j;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        //System.out.println(numberOff(13));
        System.out.println(numberOff(4));
    }


}
