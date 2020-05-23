package com.example.demo.structure.stack;

/**
 * https://www.cnblogs.com/ysocean/p/7928988.html#_label0?tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1
 */
public class TestStackSingleLink {

    public static void main(String[] args) {
        StackSingleLink singleLink = new StackSingleLink();
        singleLink.push("A");
        singleLink.push("B");
        singleLink.push("C");
        singleLink.push("D");

        singleLink.display();

        singleLink.pop();

        singleLink.display();
    }

}
