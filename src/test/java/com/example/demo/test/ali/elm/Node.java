package com.example.demo.test.ali.elm;

import lombok.Data;

@Data
public class Node{

    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
    }

}
