package com.example.demo.zjtd.interview;

import com.example.demo.structure.linked.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个单链表，判断链表中是否有环的几种方法
 * https://blog.csdn.net/weixin_43695091/article/details/88372778
 *
 * 图解：链表的快慢指针，解决 80% 的链表面试题！
 * https://mp.weixin.qq.com/s?__biz=MzIxNjc0ODExMA%3D%3D&idx=1&mid=2247486063&scene=21&sn=8ae5fc5f52b33a4465cfaec0e7d9df59##
 *
 * 图解算法：确定单链表有环，如何找到环的入口和长度？
 * https://blog.csdn.net/plokmju88/article/details/103675872
 *
 */
public class CycleUtil {

    /**
     * 方法一：循环遍历节点，遍历一个便标记一个，遍历过程判断是否被标记，若已被标记则表示有环
     * 方法说明：头指针移动，若到达之前到达过的位置则表示有环，若无环则会走到链表末端。
     * @param head
     * @return
     */
    public static boolean hasCycle1(Node head){
        //声明一个set存放已遍历的节点，即为标记节点（Set中不允许重复元素）
        Set<Node> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.getNext();
            }
        }
        return false;
    }

    /**
     * 方法二：声明两个指针，一个指针走一次经过两个节点(快指针quick)，另一个走一次经过一个节点(慢指针slow)
     * 方法说明：快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端。
     * @param head
     * @return
     */
    public static boolean hasCycle2(Node head){
        //声明两个节点从头开始遍历节点
        Node fast = head;
        Node slow = head;
        //当快指针能够走到头表示无环
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    //判断链表是否带环，若不带环，返回null
    public static Node hasCircle(Node first) {
        if (first == null) {
            return null;
        }
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }


    //若链表带环，求环的入口点
    public static Node getCircleEntry(Node first) {
        if (hasCircle(first) == null) {
            return null;
        }
        Node meetNode = hasCircle(first);
        Node tail = first;
        while (tail != meetNode) {
            tail = tail.getNext();
            meetNode = meetNode.getNext();
        }
        return tail;
    }

    //若链表带环，求环的长度
    public static int getCircleLength(Node first) {
        if (getCircleEntry(first) == null) {
            return 0;
        }
        int len = 1;//带环的链表，环的长度至少是1
        Node entryNode = getCircleEntry(first);
        Node node = entryNode;
        while (node.getNext() != entryNode) {
            node = node.getNext();
            len++;
        }
        return len;
    }


    /**
     * 题目：已知一个单链表的头结点，找到该链表中，倒数第 K 个结点。
     * @param head
     * @param k
     * @return
     */
    public static Node theKthNode(Node head, int k) {
        if (k < 0) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        int i = k;

        // fast 指针，先走 K 步
        for (; i > 0 && fast != null; i--) {
            fast = fast.getNext();
        }

        if (i > 0) {
            // 链表长度，小于 K
            return null;
        }

        // fast、slow 同步走
        while (fast != null){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    /**
     * 题目：求单链表的中间结点，如果链表长度为偶数，返回两个结点的任意一个，若为奇数，则返回中间结点。
     * @param head
     * @return
     */
    public static Node theMiddleNode(Node head){

        if(head == null){
            return null;
        }

        Node fast = head;
        Node slow = head;

        // 如果链表长度为偶数，会返回两个中间节点的第一个
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    /**
     * 检测单链表环的入口
     * @param head
     * @return
     */
    public static Node detectCycle(Node head) {
        Set<Node> visited = new HashSet<>();
        Node node = head;
        while (node != null) {
            if (visited.contains(node))
                return node;
            visited.add(node);
            node = node.getNext();
        }
        return null;
    }

    /**
     * 检测单链表环的入口(双指针)
     * @param head
     * @return
     */
    public static Node detectCycle1(Node head) {
        Node slow = head;
        Node fast = head;
        while (true) {
            if (fast == null || fast.getNext() == null) {
                return null;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast == slow)
                break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return fast;
    }





    }
