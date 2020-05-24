package com.example.demo.ali.tree;

import org.apache.commons.lang3.StringUtils;

/**
 * 原始的节点数据如下(三个字段用逗号分隔，假设各字段均不包含逗号：节点key，父节点key，当前节点data)
 * files,root,files_data
 * m1,musics,She'll be loved
 * root,,root_data
 * musics,root,musics_data
 * m2,musics,Hey Soul Sister
 */
public class MyTree<T> {
    private int size;
    private TreeNode<T> root;

    public MyTree(){
        this.size = 0;
        this.root = null;
    }

    public boolean insert(String myCode, String parentCode, T data){
        TreeNode newNode = new TreeNode(myCode, parentCode, data);
        if(StringUtils.isEmpty(parentCode)){
            newNode.setParentNode(newNode);
        }

        if(root == null){
            root = newNode;
            size++;
            return true;
        }
        TreeNode currentNode = root;
        TreeNode parentNode = null;
        while (currentNode != null){
            parentNode = currentNode;
            if(!parentCode.equals(currentNode.getMyCode())){
            }
        }

        return false;
    }

}
