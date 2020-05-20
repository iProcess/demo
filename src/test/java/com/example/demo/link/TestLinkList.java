package com.example.demo.link;

import com.alibaba.fastjson.JSON;

/**
 * https://www.cnblogs.com/ysocean/p/7928988.html#_label0?tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1
 */
public class TestLinkList {

    public static void main(String[] args) {

        Student t1 = new Student();
        t1.setId(1L);
        t1.setName("test1");

        Student t2 = new Student();
        t2.setId(2L);
        t2.setName("test2");

        Student t3 = new Student();
        t3.setId(3L);
        t3.setName("test3");

        LinkList list = new LinkList();
        list.addHead(t1);
        list.addHead(t2);
        list.addHead(t3);

        System.out.println(JSON.toJSONString(list));
        System.out.println(list.getSize());

    }
}
