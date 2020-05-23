package com.example.demo.structure.linked;

public class TestDoubleNode {

    public static void main(String[] args) {
        DoubleNode nodeA = new DoubleNode("A");
        DoubleNode nodeB = new DoubleNode("B");

        nodeB.setNext(nodeA);
        nodeA.setPrev(nodeB);

        System.out.println();

    }

}
