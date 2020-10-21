package com.example.demo.test.wh;

/**
 * 判断两个字符串的内容是否相等，不使用string的api
 */
public class WhileTest2 {

    public static void main(String[] args) {
        String str1 = "abcdef1";
        String str2 = "abcdef1";
        System.out.println(equal(str1, str2));
    }

    public static boolean equal(String mainString, String substring){
        if(mainString == null || substring == null){
            return false;
        }
        int n = mainString.length();
        if(n != substring.length()){
            return false;
        }
        char[] v1 = mainString.toCharArray();
        char[] v2 = substring.toCharArray();
        int i = 0;
        while (n-- != 0){
            if(v1[i] != v2[i]){
                return false;
            }
            i++;
        }
        return true;
    }

}
