package com.example.demo.structure.linked;

/**
 * https://www.cnblogs.com/ysocean/p/7928988.html#_label0?tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1
 */
public class TestSingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息 [D->C->B->A]
        singleList.display();
        //删除C
        singleList.delete("C");
        //[D->B->A]
        singleList.display();
        //查找B Node(data=B, next=Node(data=A, next=null))
        System.out.println(singleList.find("B"));
    }
}
