package com.example.demo.ali.stack;

import java.util.Stack;

/**
 * 栈的特性: 先进后出
 * <p>
 * 1. 单链表，求倒数第K个数
 */
public class MyNode {

    public Integer value;
    public MyNode next;

    public MyNode(Integer value) {
        this.value = value;
    }


    public static void main(String[] args) {

        MyNode node = new MyNode(1);
        MyNode temp = node;
        for (int i = 2; i < 11; i++) {
            MyNode nodeNext = new MyNode(i);
            temp.next = nodeNext;
            temp = nodeNext;
        }
        int val = getSingleListLastKNum(node, 4);
        System.out.println(val);


    }

    public static int getSingleListLastKNum(MyNode node, int k) {
        Stack<MyNode> stacks = new Stack<>();
        while (node != null) {
            stacks.push(node);
            node = node.next;
        }
        MyNode target = null;
        int size = stacks.size();
        while (stacks.size() > 0) {
            target = stacks.pop();
            int subSize = stacks.size();
            if (size - subSize == k) {
                break;
            }
        }
        return target.value;
    }


    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

}
