package com.example.demo.test.structure.queue;

public class TestQueueLinkedList {

    public static void main(String[] args) {
        QueueLinkedList linkedList = new QueueLinkedList();
        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.display();

        System.out.println(linkedList.poll());
        linkedList.display();

        System.out.println(linkedList.peek());
        linkedList.display();

    }
}
