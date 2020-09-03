package com.example.demo.test.zjtd.interview.cycle;

import com.example.demo.test.structure.linked.Node;
import com.example.demo.test.structure.linked.single.SingleLinkedList;

public class TestCycle {

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息 [D->C->B->A]
        singleList.display();

        //hasCycle1:false
        System.out.println("hasCycle1:" + CycleUtil.hasCycle1(singleList.getHead()));
        //hasCycle2:false
        System.out.println("hasCycle2:" + CycleUtil.hasCycle2(singleList.getHead()));

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeA);

        //hasCycle1-1:true
        System.out.println("hasCycle1-1:" + CycleUtil.hasCycle1(nodeA));
        //hasCycle2-1:true
        System.out.println("hasCycle2-1:" + CycleUtil.hasCycle2(nodeA));
        //hasCycle3:3
        System.out.println("hasCycle3:" + CycleUtil.getCircleLength(nodeA));
        //hasCycle4:A
        System.out.println("hasCycle4:" + CycleUtil.getCircleEntry(nodeA).getData());

    }
}
