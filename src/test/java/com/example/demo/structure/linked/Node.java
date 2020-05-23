package com.example.demo.structure.linked;

import lombok.Data;

@Data
public class Node {

    private Object data;
    private Node next;

    public Node(Object data){
        this.data = data;
    }

}
