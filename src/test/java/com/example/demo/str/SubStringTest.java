package com.example.demo.str;

public class SubStringTest {

    public static void main(String[] args) {
        String str = ",abc,123";
        System.out.println(str.indexOf(","));
        System.out.println(str.substring(str.indexOf(",")));
        String str1 = str.indexOf(",") == 0 ? str.substring(1) : str;
        System.out.println(str1);

        StringBuffer bf = new StringBuffer();
        bf.append("abc,").append("123,").append("3df,").append("cdf2t,");
        System.out.println(bf.toString());
        System.out.println(bf.toString().substring(0,bf.length() - 1));

        String date = "2020-08-01";
        System.out.println(date.substring(0, 7));
    }
}
