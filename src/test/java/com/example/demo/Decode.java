package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/7 17:46
 * Description: TODO
 */
public class Decode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String pin = URLDecoder.decode("x%E6%BD%87%E6%B9%98%E9%9B%A8j","UTF-8");
        System.out.println(pin);


        String pin1 = URLDecoder.decode("test_pop_7191","UTF-8");
        System.out.println(pin1);

    }
}
