package com.example.demo.ali;

import java.util.List;

public class TreeNode<T> {
    private String myCode;
    private String parentCode;
    private TreeNode<T> parentNode;
    private List<TreeNode<T>> children;
    private T data;

    public TreeNode(String myCode, String parentCode, T data, TreeNode<T> parentNode, List<TreeNode<T>> children) {
        this.myCode = myCode;
        this.parentCode = parentCode;
        this.data = data;
    }

    /**
     * files,root,files_data
     * m1,musics,She'll be loved
     * root,,root_data
     * musics,root,musics_data
     * m2,musics,Hey Soul Sister
     * @param args
     */
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("root", "", "root_data", null, null);

        TreeNode<String> files = new TreeNode<>("files", "root", "files_data", root, null);
        TreeNode<String> musics = new TreeNode<>("musics", "root", "musics_data", root, null);

        TreeNode<String> m1 = new TreeNode<>("m1", "musics", "She'll be loved", musics, null);
        TreeNode<String> m2 = new TreeNode<>("m2", "musics", "Hey Soul Sister", musics, null);

    }
}
