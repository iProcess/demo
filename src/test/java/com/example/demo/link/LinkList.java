package com.example.demo.link;

import lombok.Data;

@Data
public class LinkList {

    private int size;
    private Node head;

    public LinkList(){
        this.size = 0;
        head = null;
    }

    /**
     * 在链表头添加元素
     * @param object
     * @return
     */
    public Object addHead(Object object){
        Node newNode = new Node(object);
        if(head == null){
            head = newNode;
        }else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return object;
    }

    /**
     * 删除头结点
     * @return
     */
    public Object delHead(){
        Object object = head.getData();
        head = head.getNext();
        size--;
        return object;
    }

    /**
     * 删除指定节点
     * @param object
     * @return
     */
    public boolean delete(Object object){
        if(size == 0){
            return false;
        }
        Node current = head;
        Node previous = head;

        while (!current.getData().equals(object)){
            if(current.getNext() == null){
                return false;
            }
            previous = current;
            current = current.getNext();
        }

        if(current == head){
            head = current.getNext();
            size--;
        }else {
            previous.setNext(current.getNext());
            size--;
        }
        return true;

    }

    public boolean isEmpty(){
        return size == 0;
    }

}
