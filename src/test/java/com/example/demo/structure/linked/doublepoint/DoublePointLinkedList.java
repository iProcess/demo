package com.example.demo.structure.linked.doublepoint;

import com.example.demo.structure.linked.Node;

public class DoublePointLinkedList {
    private int size;
    private Node head;
    private Node tail;

    public DoublePointLinkedList(){
        this.size = 0;
        head = null;
        tail = null;
    }

    public Object addHead(Object object){
        Node node = new Node(object);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            node.setNext(head);
            head = node;
            size++;
        }
        return object;
    }

    public Object addTail(Object object){
        Node node = new Node(object);
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else {
            tail.setNext(node);
            tail = node;
            size++;
        }
        return object;
    }

    public Object deleteHead(){
        if(size == 0){
            return null;
        }
        Object object = head.getData();
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
        return object;
    }

    public Object findHead(){
        if(size == 0){
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(size <= 0){
            System.out.println("[]");
            return;
        }

        Node current = head;
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
