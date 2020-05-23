package com.example.demo.structure.linked.doubles;

public class TestDoublesPointLinkedList {

    public static void main(String[] args) {
        DoublesPointLinkedList linkedList = new DoublesPointLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.addHead("D");
        linkedList.display();

        linkedList.addTail("E");
        linkedList.display();

        linkedList.deleteHead();
        linkedList.display();
    }

}
