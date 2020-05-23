package com.example.demo.structure.tree;

public interface Tree {

    boolean insert(int data);

    Node find(int key);

    void infixOrder(Node current);

    void preOrder(Node current);

    void postOrder(Node current);

    Node findMax();

    Node findMin();

    boolean delete(int key);

    boolean deleteFlag(int key);

    void infixOrderFlag(Node current);

    Node getRoot();
}
