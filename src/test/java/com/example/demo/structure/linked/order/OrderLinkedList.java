package com.example.demo.structure.linked.order;

import com.example.demo.structure.domain.Node;

public class OrderLinkedList {

    private int size;
    private Node head;

    public OrderLinkedList(){
        size = 0;
        head = null;
    }

    /**
     * 从小到大排序
     * 思路：
     * 1、插入、删除结点都需要两个节点（previous、current）来查找位置；
     * 2、先找到位置（位置是头结点，还是中间结点，还是尾结点），再决定如何操作。
     * @param object
     */
    public void addHead(Object object){
        Node node = new Node(object);

        if(head == null){
            head = node;
            size++;
            return;
        }

        Node previous = null;
        Node current = head;
        while (current != null && Integer.parseInt(object.toString()) > Integer.parseInt(current.getData().toString())){
            previous = current;
            current = current.getNext();
        }

        //头结点
        if(previous == null){
            head = node;
            node.setNext(current);
            //head.setNext(current);//两种用法都可以，都一样
        }else {
        //中间结点或尾结点
            previous.setNext(node);
            node.setNext(current);
        }
        size++;

    }

    /**
     * 从小到大排序
     * 此方法不可取，因在 while (tempSize >= 0) 中会多循环一次，
     * 在 current != null && Integer.parseInt(object.toString()) > Integer.parseInt(current.getData().toString()) 下循环就可以了
     * @param object
     */
    public void addHead1(Object object){
        Node node = new Node(object);

        if(head == null){
            head = node;
            size++;
            return;
        }

        Node previous = null;
        Node current = head;
        int tempSize = size;
        while (tempSize >= 0){
            if(current != null && Integer.parseInt(object.toString()) > Integer.parseInt(current.getData().toString())){
                previous = current;
                current = current.getNext();
            }else {

                if(previous == null){
                    head = node;
                    node.setNext(current);
                }else {
                    previous.setNext(node);
                    node.setNext(current);
                }
            }
            tempSize--;
        }
        size++;
    }

    public Object deleteHead(){
        if(size == 0){
            return null;
        }
        Object object = head.getData();
        head = head.getNext();
        size--;
        return object;
    }

    public void disply(){
        if(size == 0){
            System.out.println("[]");
        }
        Node current = head;
        int tempSize = size;
        if(tempSize == 1){
            System.out.println("[" + head.getData() + "]");
        }
        while (tempSize > 0){
            if(current.equals(head)){
                System.out.print("[" + current.getData() + "->");
            }else if(current.getNext() == null){
                System.out.println(current.getData() + "]");
            }else{
                System.out.print(current.getData() + "->");
            }
            current = current.getNext();
            tempSize--;
        }
    }

}
