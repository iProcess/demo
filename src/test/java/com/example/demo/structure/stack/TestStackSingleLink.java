package com.example.demo.structure.stack;

public class TestStackSingleLink {

    public static void main(String[] args) {
        StackSingleLink singleLink = new StackSingleLink();
        singleLink.push("A");
        singleLink.push("B");
        singleLink.push("C");
        singleLink.push("D");

        singleLink.display();

        singleLink.pop();

        singleLink.display();
    }
}
