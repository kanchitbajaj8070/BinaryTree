package com.company;

import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
/*	BinarySearchTree tree = new BinarySearchTree();
	HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Random r= new Random();
            int k= r.nextInt(20);
            if(!set.contains(k))
            {
                set.add(k);
                tree.insert(k);
            }
        }
        tree.inorder();*/
        BinarySearchTree t = new BinarySearchTree();
    int[]a={0,1,2,3,4,5,6,7};
    t.populate(a);
 t.levelOrder();
    /*    System.out.println(t.noOfNodes(t.root)+"    "+t.sumOfAllNodes(t.root));
        System.out.println(t.diameter(t.root));
        System.out.println(t.diameterOfTree());*/
       // System.out.println(t.isHeightBalancedOptimised());
        System.out.println(t.findLCA(0,2));
    }

}
