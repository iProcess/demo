package com.example.demo.test.ali.tree.node;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class TestNode {

    /**
     * 原始的节点数据如下(三个字段用逗号分隔，假设各字段均不包含逗号：节点key，父节点key，当前节点data)
     * files,root,files_data
     * m1,musics,She'll be loved
     * root,,root_data
     * musics,root,musics_data
     * m2,musics,Hey Soul Sister
     */
    public static void main(String[] args) {

        Node files = new Node("files", "root", "files_data");
        Node m1 = new Node("m1", "musics", "She'll be loved");
        Node root = new Node("root", "-1", "root_data");
        Node musics = new Node("musics", "root", "musics_data");
        Node m2 = new Node("m2", "musics", "Hey Soul Sister");

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(files);
        nodeList.add(m1);
        nodeList.add(root);
        nodeList.add(musics);
        nodeList.add(m2);

        List<Node> nodeTree = NodeUtil.getTree(nodeList);
        System.out.println(JSON.toJSONString(nodeTree));

        List<Node> nodeTree1 = NodeUtil.getChildrenNode("-1", nodeList);
        System.out.println(JSON.toJSONString(nodeTree1));

    }

}
