package com.example.demo.link.single;

public class TestSingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息 [D->C->B->A]
        singleList.display();
        //删除C
        singleList.delete("C");
        //[D->B->A]
        singleList.display();
        //查找B Node(data=B, next=Node(data=A, next=null))
        System.out.println(singleList.find("B"));
    }
}
