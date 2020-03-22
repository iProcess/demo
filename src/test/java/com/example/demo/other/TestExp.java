package com.example.demo.other;

import java.util.regex.Pattern;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/3/11 18:27
 * Description: TODO
 */
public class TestExp {

    public static void main(String[] args) {


        String content = "dangban@2x.4cf7a952.png";
        /**
         * 不以js、png、css、ioc结尾的字符串
         */
        String pattern = ".*[^((js)|(png)|(css)|(ico))]$";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);

    }
}
