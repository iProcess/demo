package com.example.demo.leetcode.reversal;

import com.alibaba.fastjson.JSON;
import com.example.demo.structure.linked.Node;
import com.example.demo.structure.linked.single.SingleLinkedList;

/**
 * 反转链表
 * https://www.toutiao.com/i6843607815508984331/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1593477623&app=news_article&utm_source=weixin&utm_medium=toutiao_ios&use_new_style=1&req_id=202006300840230101300371303C2F2071&group_id=6843607815508984331
 */
public class LinkedReversal {

    public Node reverseList(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addHead(5);
        linkedList.addHead(4);
        linkedList.addHead(3);
        linkedList.addHead(2);
        linkedList.addHead(1);
        linkedList.display();

        LinkedReversal linkedReversal = new LinkedReversal();
        Node newNode = linkedReversal.reverseList(linkedList.getHead());
        System.out.println(JSON.toJSONString(newNode));


    }

}
