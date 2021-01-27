package com.example.demo.test.number;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class TestMain {
    public static void main(String[] args) {
        String str1 = "122323443242";
        String str2 = "1232432424242424.0";
        String str3 = "12.1";
        String str4 = "12.01";
        String str5 = "0.1";
        String str6 = "0.0001";
        String str7 = "1.0";
        String str8 = "1.10";
        String str9 = "";
        String str10 = " ";
        String str11 = null;
        System.out.println(string2Number(str1));
        System.out.println(string2Number(str2));
        System.out.println(string2Number(str3));
        System.out.println(string2Number(str4));
        System.out.println(string2Number(str5));
        System.out.println(string2Number(str6));
        System.out.println(string2Number(str7));
        System.out.println(string2Number(str8));
        System.out.println(string2Number(str9));
        System.out.println(string2Number(str10));
        System.out.println(string2Number(str11));
    }

    public static Number string2Number(Object value){
        if(value == null){
            return 0;
        }
        String strValue = value.toString();
        if(StringUtils.isBlank(strValue)){
            return 0;
        }
        if(strValue.indexOf(".") > 0){
            int newScale = strValue.split("\\.")[1].length();
            new BigDecimal(strValue).setScale(newScale, BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal(strValue);
    }


}
