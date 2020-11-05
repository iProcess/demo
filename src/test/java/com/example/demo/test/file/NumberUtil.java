package com.example.demo.test.file;

import java.util.regex.Pattern;

public class NumberUtil {
    /**
     * 判断一个字符串是否是数字。
     *
     * @param string
     * @return
     */
    public static boolean isNumber(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }

    private static void isNumberTest() {
        System.out.println(isNumber("123"));
        System.out.println(isNumber("-123.456"));
        System.out.println(isNumber("123成宇佳456"));
    }

    public static void main(String[] args) {
        isNumberTest();
    }
}
