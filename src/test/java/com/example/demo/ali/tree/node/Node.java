package com.example.demo.ali.tree.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private String name;
    private String parentId;
    //private int order;
    private List<Node> children = new ArrayList<Node>();

    public Node() {

    }

    public Node(String id, String parentId, String name) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /*public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }*/

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
