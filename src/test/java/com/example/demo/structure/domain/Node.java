package com.example.demo.structure.domain;

import lombok.Data;

@Data
public class Node {

    private Object data;
    private Node next;

    public Node(Object data){
        this.data = data;
    }

}
