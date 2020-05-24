package com.example.demo.structure.linked.order;

public class TestOrderLinkedList {

    public static void main(String[] args) {
        OrderLinkedList linkedList1 = new OrderLinkedList();
        linkedList1.addHead(3);
        linkedList1.addHead(5);
        linkedList1.addHead(4);
        linkedList1.addHead(10);
        linkedList1.addHead(2);
        linkedList1.disply();

        linkedList1.deleteHead();
        linkedList1.disply();

//        OrderLinkedList linkedList2 = new OrderLinkedList();
//        linkedList2.addHead1(3);
//        linkedList2.addHead1(5);
//        linkedList2.addHead1(4);
//        linkedList2.addHead1(10);
//        linkedList2.addHead1(2);
//        linkedList2.disply();

    }
}
