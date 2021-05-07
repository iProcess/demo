package com.example.demo.test.self.link.doubles;

public class DoubleLinkedList {
    class Node{
        Node next;
        Node prev;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private int size;
    Node head;
    Node tail;

    public void addHead(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            size++;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    public void addTail(int val){
        Node newNode = new Node(val);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Node deleteHead(){
        Node node = head;
        if(size != 0){
            head = head.next;
            head.prev = null;
            size--;
        }
        return node;
    }

    public Node deleteTail(){
        Node node = tail;
        if(size != 0){
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return node;
    }

}
