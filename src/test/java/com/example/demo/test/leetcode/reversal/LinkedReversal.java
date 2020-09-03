package com.example.demo.test.leetcode.reversal;

import com.alibaba.fastjson.JSON;
import com.example.demo.test.structure.linked.Node;
import com.example.demo.test.structure.linked.single.SingleLinkedList;

/**
 * 反转链表
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
