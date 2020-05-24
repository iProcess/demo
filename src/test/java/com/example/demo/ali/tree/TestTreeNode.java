package com.example.demo.ali.tree;

import com.alibaba.fastjson.JSON;
import com.example.demo.ali.tree.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 原始的节点数据如下(三个字段用逗号分隔，假设各字段均不包含逗号：节点key，父节点key，当前节点data)
 * files,root,files_data
 * m1,musics,She'll be loved
 * root,,root_data
 * musics,root,musics_data
 * m2,musics,Hey Soul Sister
 */
public class TestTreeNode {

    public static void main(String[] args) {

        TreeNode files = new TreeNode("files", "root", "files_data");
        TreeNode m1 = new TreeNode("m1", "musics", "She'll be loved");
        TreeNode root = new TreeNode("root", "", "root_data");
        TreeNode musics = new TreeNode("musics", "root", "musics_data");
        TreeNode m2 = new TreeNode("m2", "musics", "Hey Soul Sister");

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(files);
        nodeList.add(m1);
        nodeList.add(root);
        nodeList.add(musics);
        nodeList.add(m2);

        List<TreeNode> treeNodes = TreeNode.getChildrenNode("", nodeList);
        System.out.println(JSON.toJSONString(treeNodes));

    }
}
