package com.example.demo.wl;

import org.apache.commons.lang3.StringUtils;

public class Demo1 {

    /**
     * 第一题
     * @param str
     * @return
     */
    public static int atoi(String str){
        if(StringUtils.isBlank(str)){
            return 0;
        }
        char[] charArray = str.toCharArray();
        for(char ch : charArray){
            //字符0至9的ASCII码在48 至 57 之间
            if(ch < 48 || ch > 57){
                return 0;
            }
        }
        return Integer.parseInt(str);
    }

    /**
     * 第二题
     *  斐波那契数列的运用
     * @param n n大于0
     * @return
     */
    public static int calcStairs(int n){
//        if(n == 0){
//            return 0;
//        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return calcStairs(n - 1) + calcStairs( n - 2);
    }

    /**
     * 第三题
     * 思路：将一个字符串拆分为子串，对所有的子串进行排序，然后比较得出
     */

    public static void main(String[] args) {
        System.out.println(calcStairs(4));
    }

}
