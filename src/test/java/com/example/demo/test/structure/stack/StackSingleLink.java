package com.example.demo.test.structure.stack;

import com.example.demo.test.structure.linked.single.SingleLinkedList;

/**
 * 用单向链表实现栈
 */
public class StackSingleLink {

    private SingleLinkedList linkedList;

    public StackSingleLink(){
        linkedList = new SingleLinkedList();
    }

    public void push(Object object){
        linkedList.addHead(object);
    }

    public Object pop(){
        Object object = linkedList.deleteHead();
        return object;
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void display(){
        linkedList.display();
    }

}
