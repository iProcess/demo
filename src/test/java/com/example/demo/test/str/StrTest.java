package com.example.demo.test.str;

import org.apache.commons.lang3.StringUtils;

public class StrTest {

    public static void main(String[] args) {
        String s = "abcdefg";
        //判断searchStrs中的任意一个，是否在CharSequence中，如存在，则返回该存在的字符串的首字母在CharSequence中的位置
        System.out.println(StringUtils.indexOfAny(s, "1", "1ab", "efg2"));//-1

    }
}
