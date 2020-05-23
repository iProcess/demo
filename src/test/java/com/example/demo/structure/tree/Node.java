package com.example.demo.structure.tree;

public class Node {

    private int data;
    private Node leftChild;
    private Node rightChild;
    private boolean isDelete = false;

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
