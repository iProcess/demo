package com.example.demo.structure.linked.doublepoint;

public class TestDoublePointLinkedList {

    public static void main(String[] args) {
        DoublePointLinkedList linkedList = new DoublePointLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.addHead("D");
        linkedList.display();

        linkedList.addTail("E");
        linkedList.display();

        linkedList.deleteHead();
        linkedList.display();

        Object head = linkedList.deleteHead();
        System.out.println(head);
        linkedList.display();
    }

}
