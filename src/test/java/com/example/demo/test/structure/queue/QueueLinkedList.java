package com.example.demo.test.structure.queue;

import com.example.demo.test.structure.linked.doublepoint.DoublePointLinkedList;

/**
 * 基于双端链表构建队列
 */
public class QueueLinkedList {
    private int size;
    private DoublePointLinkedList linkedList;

    public QueueLinkedList(){
        size = 0;
        linkedList = new DoublePointLinkedList();
    }

    /**
     * 向队列尾添加元素
     * 入队操作
     * @param object
     */
    public void offer(Object object){
        linkedList.addTail(object);
        size++;
    }

    /**
     * 从队列头获取元素
     * 出队操作
     * 获取后该元素就出队列删除了
     * @return
     */
    public Object poll(){
        Object object = linkedList.deleteHead();
        size--;
        return object;
    }

    /**
     * 从队列头获取元素
     * 不会删除元素
     * @return
     */
    public Object peek(){
        return linkedList.findHead();
    }

    public void display(){
        linkedList.display();
    }

}
