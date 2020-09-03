package com.example.demo.test.leetcode.linkedtree;

import com.example.demo.test.structure.linked.Node;
import com.example.demo.test.structure.linked.single.SingleLinkedList;
import com.example.demo.test.structure.tree.BinaryTree;

public class TestMain {

    public static void main(String[] args) {
        int[] data = {-10, -3, 0, 5, 9};
        SingleLinkedList linkedList = new SingleLinkedList();
        for(int i : data){
            linkedList.addHead(i);
        }
        linkedList.display();

        Node head = linkedList.getHead();
        int size = linkedList.getSize();
        Node currentNode = head;
        BinaryTree tree = new BinaryTree();
        while (size > 0){
            tree.insert(Integer.parseInt(currentNode.getData().toString()));
            currentNode = currentNode.getNext();
            size--;
        }
        tree.infixOrder(tree.getRoot());
        System.out.println(" ");
    }

}
