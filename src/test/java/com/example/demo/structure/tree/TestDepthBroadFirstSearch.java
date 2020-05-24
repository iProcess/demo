package com.example.demo.structure.tree;

public class TestDepthBroadFirstSearch {

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
        //中序遍历 10 20 25 30 50 60 80 85 90 100
        bt.infixOrder(bt.getRoot());
        System.out.println();
        //深度优先搜寻 50 20 10 30 25 80 60 90 85 100
        bt.depthFirstSearch(bt.getRoot());
        System.out.println();
        //广度优先搜索 50 20 80 10 30 60 90 25 85 100
        bt.broadFirstSearch(bt.getRoot());
        System.out.println();
    }
}
