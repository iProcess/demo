package com.example.demo.structure.linked;

import com.example.demo.structure.domain.Node;

public class SingleLinkedList {
    private int size;
    private Node head;

    public SingleLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public Object addHead(Object object){
        Node newNode = new Node(object);
        if(head == null){
            head = newNode;
        }else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return object;
    }

    public Object deleteHead(){
        Object object = head.getData();
        head = head.getNext();
        size--;
        return object;
    }

    public boolean delete(Object object){
        if(size == 0){
            return false;
        }
        /**
         * 删除指定的节点，需要查找指定的节点，且删除后要保持链表的结构，
         * 所以从当前节点current开始查询，如当前节点current需要往下移动时，
         * 用previous记录下current的位置。
         */
        Node current = head;
        Node previous = head;
        /**
         * 当前节点如不是要删除的节点，需继续查找
         */
        while (!current.getData().equals(object)){
            /**
             * 当前节点如不是要删除的节点，且当前节点后已无节点，则查找失败
             */
            if(current.getNext() == null){
                return false;
            }
            /**
             * 当前节点如不是要删除的节点，需用previous记录下当前节点后，当前节点移动到下一个节点
             */
            previous = current;
            current = current.getNext();

        }

        /**
         * 以上查找结束后，当前节点current便是要查找的节点，
         * 判断当前节点current是否是头结点，
         * 如是头结点，将head指向原头结点的下一个节点，便可以删除，
         * 如不是头结点，需将上一个节点previous的下一个节点指向当前节点current的下一个节点，、
         * 这样便可以实现删除当前节点current
         */
        if(current == head){
            head = head.getNext();
            size--;
        }else {
            previous.setNext(current.getNext());
            size--;
        }

        return true;

    }

    public Node find(Object object){
        Node current = head;
        int tempSize = size;
        while (tempSize > 0){
            if(current.getData().equals(object)){
                return current;
            }else {
                current = current.getNext();
            }
            tempSize--;
        }
        return null;
    }

    public Node find2(Object object){
        Node current = head;
        int tempSize = size;
        while (tempSize > 0){
            if (!current.getData().equals(object)){
                if(current.getNext() == null){
                    return null;
                }
                current = current.getNext();
            }
            tempSize--;
        }
        return current;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(size > 0){
            Node node = head;
            int tempSize = size;
            if(tempSize == 1){
                System.out.println("[" + node.getData() + "]");
                return;
            }

            while (tempSize > 0){
                if(node.equals(head)){
                    System.out.print("[" + node.getData() + "->");
                }else if(node.getNext() == null){
                    System.out.print(node.getData() + "]");
                }else {
                    System.out.print(node.getData() + "->");
                }
                node = node.getNext();
                tempSize--;
            }
        }else {
            System.out.println("[]");
        }
    }

    public void display2(){

        Node node = head;
        int tempSize = size;
        if (tempSize <= 0){
            System.out.println("[]");
            return;
        }

        while (tempSize > 0){
            System.out.println(node.getData());
            node = node.getNext();
            tempSize--;
        }
    }


}
