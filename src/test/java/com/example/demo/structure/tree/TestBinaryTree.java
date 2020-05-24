package com.example.demo.structure.tree;

public class TestBinaryTree {

    /**
     * 构建的二叉树
     *            50
     *       20        80
     *    10   30   60   90
     *       25        85  100
     *
     */
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.infixOrder(bt.getRoot());
        System.out.println();
        bt.preOrder(bt.getRoot());
        System.out.println();
        bt.postOrder(bt.getRoot());
        System.out.println();
        bt.delete(10);//删除没有子节点的节点
        bt.infixOrder(bt.getRoot());
        System.out.println();
        bt.delete(30);//删除有一个子节点的节点
        bt.infixOrder(bt.getRoot());
        System.out.println();
        bt.delete(80);//删除有两个子节点的节点
        bt.infixOrder(bt.getRoot());
        System.out.println();
        System.out.println(bt.findMax().getData());
        System.out.println(bt.findMin().getData());
        Node node100 = bt.find(100);
        System.out.println(node100 != null ? node100.getData() : "null");
        Node node200 = bt.find(200);
        System.out.println(node200 != null ? node200.getData() : "null");

        bt.infixOrder(bt.getRoot());
        System.out.println();
        bt.deleteFlag(25);
        bt.infixOrderFlag(bt.getRoot());
        System.out.println();
        bt.infixOrder(bt.getRoot());
        System.out.println();

        bt.infixOrder(bt.getRoot());
        System.out.println();
        bt.deleteFlag(100);
        bt.infixOrderFlag(bt.getRoot());
        System.out.println();
        bt.infixOrder(bt.getRoot());
        System.out.println();
    }
}
