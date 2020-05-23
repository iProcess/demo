package com.example.demo.structure.linked.doublelinked;

public class TestDoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.addHead("D");
        linkedList.addHead("E");
        linkedList.display();

        linkedList.deleteHead();
        linkedList.display();

        linkedList.deleteTail();
        linkedList.display();

        linkedList.addTail("F");
        linkedList.display();
    }
}
