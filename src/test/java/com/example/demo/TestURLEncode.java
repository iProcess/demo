package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/3/9 12:27
 * Description: TODO
 */
public class TestURLEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "271583714318271EZD5rNthr7SPstJCybm7bAGqBi7LFAyfjj4VdXP/0p8u3HXNnnQeET9ANDKs+wGD";
        String utf8Str = URLEncoder.encode(str, "utf-8");
        System.out.println(utf8Str);
        //271583714318271EZD5rNthr7SPstJCybm7bAGqBi7LFAyfjj4VdXP%2F0p8u3HXNnnQeET9ANDKs%2BwGD

        String gbkStr = URLEncoder.encode(str, "gbk");
        System.out.println(gbkStr);
        //271583714318271EZD5rNthr7SPstJCybm7bAGqBi7LFAyfjj4VdXP%2F0p8u3HXNnnQeET9ANDKs%2BwGD

        System.out.println(utf8Str.equals(gbkStr));
        //true
    }

}
