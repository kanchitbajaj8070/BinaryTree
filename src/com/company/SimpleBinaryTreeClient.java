package com.company;

public class SimpleBinaryTreeClient {
    public static void main(String[] args) {
        SimpleBinaryTree tree= new SimpleBinaryTree();
        tree.insert();
        tree.preorder();
        tree.findLCA(2,4);
    }
}
