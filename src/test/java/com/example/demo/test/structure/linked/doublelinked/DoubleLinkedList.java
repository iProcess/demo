package com.example.demo.test.structure.linked.doublelinked;

import com.example.demo.test.structure.linked.DoubleNode;

public class DoubleLinkedList {

    private int size;
    private DoubleNode head;
    private DoubleNode tail;

    public DoubleLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addHead(Object object){
        DoubleNode newNode = new DoubleNode(object);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            size++;
        }
    }

    public void addTail(Object object){
        DoubleNode newNode = new DoubleNode(object);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        }else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    public DoubleNode deleteHead(){
        DoubleNode node = head;
        if(size != 0){
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
        return node;
    }

    public DoubleNode deleteTail(){
        DoubleNode node = tail;
        if(size != 0){
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
        return node;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        DoubleNode current = head;
        int tempSize = size;
        if(tempSize == 1){
            System.out.println("[" + current.getData() + "]");
            return;
        }
        while (tempSize > 0){
            if(current.equals(head)){
                System.out.print("[" + current.getData() + "->");
            }else if(current.getNext() == null){
                System.out.println(current.getData() + "]");
            }else {
                System.out.print(current.getData() + "->");
            }
            current = current.getNext();
            tempSize--;
        }
    }

}
