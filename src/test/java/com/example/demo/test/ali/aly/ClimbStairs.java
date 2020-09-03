package com.example.demo.test.ali.aly;

/**
 * 1、走阶梯，有n级阶梯，一次可以走一级、两级或者三级，请编写一个函数计算走完该阶梯一共有多少种种方法。
 * https://www.cnblogs.com/gaopengpy/p/12897175.html
 */
public class ClimbStairs {

    public int climbStairs(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //当阶梯数为3是4种走法，要特别注意，各位可以拿笔在纸上画画
        if(n == 3){
            return 4;
        }
        return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
    }
}
