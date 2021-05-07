package com.example.demo.test.self.link.single;

public class SingleLinkedList {
    class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }
    }

    private int size;
    private Node head;

    public int addHead(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return val;
    }

    public int deleteHead(){
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public boolean delete(int val){
        if(size == 0){
            return false;
        }
        Node curr = head;
        Node pre = head;
        while (curr.val != val){
            if(curr.next == null){
                return false;
            }
            pre = curr;
            curr = curr.next;
        }
        if(curr == head){
            head = head.next;
            size--;
        }else {
            pre.next = curr.next;
            size--;
        }
        return true;
    }

    public Node find(int val){
        Node curr = head;
        int tempSize = size;
        while (tempSize > 0){
            if(curr == null){
                return null;
            }
            if(curr.val == val){
                return curr;
            }else {
                curr = curr.next;
            }
            tempSize--;
        }
        return null;
    }

}
