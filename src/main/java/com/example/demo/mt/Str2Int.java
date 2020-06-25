package com.example.demo.mt;

/**
 * ASCII表：http://c.biancheng.net/c/ascii/
 */
public class Str2Int {

    /**
     * 原版本 https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
     *
     * @param str
     * @return
     */
    public static int atoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

    /**
     * 变种版本
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;

        if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            /**
             * 按ASCII码表中的十进制进行相减
             * 字符'0'-'9'在ASCII码中对应的十进制为48-57
             * 即：
             * '0'：48
             * '1'：49
             * '2'：50
             */
            int digit = chars[idx] - '0';
            /**
             * 因为int是十进制，所以乘以10
             */
            ans = ans * 10 + digit;
            idx++;
        }
        return ans;
    }

    /**
     * 简单版本
     * @param str
     * @return
     */
    public static int myAtoi1(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        int ans = 0;
        while (idx < n){
            /**
             * 字符'0'-'9'在ASCII码中对应的十进制为48-57
             * 含有非数字的字符，不能转换为数字
             */
            if(chars[idx] < 48 || chars[idx] > 57){
                return 0;
            }
            /**
             * 按ASCII码表中的十进制进行相减
             * 即：
             * '0'：48
             * '1'：49
             * '2'：50
             */
            int digit = chars[idx] - '0';
            /**
             * 因为int是十进制，所以乘以10
             */
            ans = ans * 10 + digit;
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "123";

//        int i = Integer.parseInt(str);
//        System.out.println(i);
//
//        int i1 = myAtoi(str);
//        System.out.println(i1);

        int i2 = myAtoi1(str);
        System.out.println(i2);
    }
}

