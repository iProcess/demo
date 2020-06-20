package com.example.demo.ali.elm;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Linked {

    private int size;
    private Node head;

    public Linked(){
        this.size = 0;
        head = null;
    }

    public void addHead(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public Node swap(Node head){

        if(head == null || head.getNext() == null){
            return head;
        }

        Node firstNode = head;
        Node secondNode = head.getNext();

        firstNode.setNext(swap(secondNode.getNext()));
        secondNode.setNext(firstNode);

        return secondNode;

    }

    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.addHead(1);
        linked.addHead(2);
        linked.addHead(3);
        linked.addHead(4);
        linked.addHead(5);
        System.out.println("原链表结构：" + JSON.toJSONString(linked));
        System.out.println("原链表Node节点结构：" + JSON.toJSONString(linked.getHead()));
        //交换Node节点
        Node newNode = linked.swap(linked.getHead());
        System.out.println("新Node节点结构：" + JSON.toJSONString(newNode));
        //原来链表的顺序已被打乱，不可取
        System.out.println("交换后的原链表结构：" + JSON.toJSONString(linked));

        //用新Node重新组成链表
        Linked newLinked = new Linked();
        newLinked.setHead(newNode);
        newLinked.setSize(linked.getSize());
        System.out.println("新链表结构：" + JSON.toJSONString(newLinked));

    }

}
