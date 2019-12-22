package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBinaryTree {
    public class Node {
        public int data;
        public Node left, right;

        Node(int d) {
            this.data = d;
        }
    }

    public Node root;

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        if (root == null)
            root = new Node(scanner.nextInt());
        insert(root, scanner);

    }// 314 y 6 n y 2 n y 3 n n y 6 y 3 y 2 n n n n

    private void insert(Node root, Scanner scanner) {

        System.out.println("Do u  wanna enter left childs of (y/n) ?" + root.data);
        char c = scanner.next().charAt(0);
        if (c == 'y') {
            System.out.println("enter the left child of the " + root.data);
            int left = scanner.nextInt();
            Node nn = new Node(left);
            root.left = nn;
            insert(nn, scanner);
        }
        System.out.println("Do u  wanna enter right childs of (y/n) ?" + root.data);
        char d = scanner.next().charAt(0);
        if (d == 'y') {
            System.out.println("enter right child of " + root.data);
            int right = scanner.nextInt();
            Node nn = new Node(right);
            root.right = nn;
            insert(nn, scanner);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println("\n_________");
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + "  ->  ");
        preorder(node.left);
        preorder(node.right);

    }


    public void inorder() {
        inorder(root);
        System.out.println("\n_________");
    }

    private void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + "  ->  ");
        inorder(node.right);

    }

    public boolean isSymetric() {
        Node rootOfMirror = new Node(root.data);
        getMirror(root, rootOfMirror);
        System.out.println("inorder of mirror");
        preorder(rootOfMirror);
        return checkMirrorForSymettry(rootOfMirror, root);

    }

    private boolean checkMirrorForSymettry(Node rootOfMirror, Node root) {
        if (root == null && rootOfMirror != null)
            return false;
        if (rootOfMirror == null && root != null)
            return false;
        if (root == null && rootOfMirror == null)
            return true;
        if (root.data != rootOfMirror.data)
            return false;
        return checkMirrorForSymettry(rootOfMirror.left, root.left) && checkMirrorForSymettry(rootOfMirror.right, root.right);

    }

    private void getMirror(Node root, Node rootOfMirror) {

        if (root == null)
            return;
        if (root.left != null)
            rootOfMirror.right = new Node(root.left.data);
        else
            rootOfMirror.right = null;
        if (root.right != null)
            rootOfMirror.left = new Node(root.right.data);
        else
            rootOfMirror.left = null;
        getMirror(root.left, rootOfMirror.right);
        getMirror(root.right, rootOfMirror.left);
    }

    public void findLCA(int k1, int k2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        path1.clear();
        path2.clear();
boolean a1=findpath(path1,k1,root);
boolean a2=findpath(path2,k2,root);
        System.out.println(path1);
        System.out.println(path2);
int ans=-1;
if(a1&&a2)
{
    for (int i = 0; i < Math.min(path1.size(),path2.size()); i++) {
        if(path1.get(i)!=path2.get(i))
        {

            if(i==0)
                ans=-1;
            else
                ans=path1.get(i-1);


        break;}
    }
}
    if(ans==-1)
        System.out.println("No lca possible");
    else
        System.out.println("LCA OF "+ k1 +" and "+ k2 + " is "+ ans);
    }

    public boolean findpath(ArrayList<Integer> path, int k1, Node trav) {
        if (trav == null)
            return false;
        if (trav.data == k1) {
            path.add(k1);
            return true;
        }path.add(trav.data);
        boolean pathToLeftPossible = findpath(path, k1, trav.left);
        boolean pathToRightpossible = findpath(path, k1, trav.right);
        if (pathToLeftPossible == true)
            return true;
        else if (pathToRightpossible == true)
            return true;
        else
            path.remove(path.size() - 1);
        return false;
    }





}
