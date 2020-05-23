package com.example.demo.structure.linked.doubles;

import com.example.demo.structure.domain.Node;

public class DoublesPointLinkedList {
    private int size;
    private Node head;
    private Node tail;

    public DoublesPointLinkedList(){
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

    public boolean deleteHead(){
        if(size == 0){
            return false;
        }
        if (head.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
        return true;
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
