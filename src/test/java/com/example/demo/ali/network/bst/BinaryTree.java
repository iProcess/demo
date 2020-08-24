package com.example.demo.ali.network.bst;


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

}


public class BinaryTree {

    private int size;
    private TreeNode root;

    public BinaryTree() {
        this.size = 0;
        root = null;
    }

    public boolean insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            size++;
            return true;
        }
        TreeNode current = root;
        TreeNode parentNode = null;
        while (current != null) {
            parentNode = current;
            if (current.val > data) {
                current = current.left;
                if (current == null) {
                    parentNode.left = newNode;
                    size++;
                    return true;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parentNode.right = newNode;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    public TreeNode find(int key) {
        TreeNode current = root;
        while (current != null) {
            if (current.val > key) {
                current = current.left;
            } else if (current.val < key) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * 中序遍历
     * 左节点、根节点、右节点
     *
     * @param current
     */
    public void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.left);
            System.out.print(current.val + " ");
            infixOrder(current.right);
        }
    }

    /**
     * 前序遍历
     * 根节点、左节点、右节点
     *
     * @param current
     */
    public void preOrder(TreeNode current) {
        if (current != null) {
            System.out.print(current.val + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    /**
     * 后序遍历
     * 左节点、右节点、根节点
     *
     * @param current
     */
    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.val + " ");
        }

    }

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }

    private ResultType kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return new ResultType(false, 0);
        }

        ResultType left = kthSmallestHelper(root.left, k);

        // 左子树找到，直接返回
        if (left.found) {
            return new ResultType(true, left.val);
        }

        // 左子树的节点数目 = K-1，结果为 root 的值
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }

        // 右子树寻找
        ResultType right = kthSmallestHelper(root.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }

        // 没找到，返回节点总数
        return new ResultType(false, left.val + 1 + right.val);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);

        tree.infixOrder(tree.root);

        System.out.println();

        int min = tree.kthSmallest(tree.root, 3);
        System.out.println(min);

    }


}


class ResultType {

    boolean found;  // 是否找到
    int val;  // 节点数目

    ResultType(boolean found, int val) {
        this.found = found;
        this.val = val;
    }

}
