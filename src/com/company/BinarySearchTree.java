package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
        }
    }
  public Node root;
    public void insert(int key)
    {
        if(root== null)
        {
            root= new Node( key);
        }
        else
            insert(root, key);

    }
    public void preorder()
    {
        preorder(root);
        System.out.println("\n_________");
    }

    private void preorder(Node node) {
    if(node== null)
    return;
        System.out.print(node.data+"  ->  ");
    preorder(node.left);
    preorder(node.right);

    }


    public void inorder()
    {
        inorder(root);
        System.out.println("\n_________");
    }

    private void inorder(Node node) {
        if(node== null)
            return;

        inorder(node.left);
        System.out.print(node.data+"  ->  ");
        inorder(node.right);

    }

    private void insert(Node trav , int key)
    {
        if(trav== null)
            return;
        if( key < trav.data)
        {
            if(trav.left== null)
            {
                trav.left=new Node( key);
                return;
            }
            else
                insert(trav.left,key);
        }
        else
        {
            if(trav.right==null)
            {
                trav.right= new Node( key);

            return;}
            else
                insert(trav.right,key);
        }

    }
    public void populate(int []a)
    {
     root= populate( a, 0, a.length-1);

    }

    private Node populate(int[] a, int s, int e) {
     if(s>e)
      return null;
     int m=(s+e)/2;
        Node root= new Node(a[m]);
        root.left=populate(a,s,m-1);
        root.right=populate(a,m+1,e);
    return root;
    }
    public int height( Node node)
    {
        if(node ==null)
            return -1;
        int leftheight= height(node.left);
        int rightheight=height(node.right);
        return 1+Math.max(leftheight,rightheight);

    }
    public void delete(int key)
    {

       delete(root,null,key);
    }

    private void delete(Node root, Node parent,int key) {

        if(key<root.data)
            delete(root.left,root,key);
        else if(key> root.data)
            delete(root.right,root,key);
        else {
             if (root.left == null && root.right == null)
             {
                    if (parent.left == root)
                        parent.left = null;
                    else
                        parent.right = null;
                } else if (root.left == null) {
                    if (parent.left == root)
                        parent.left = root.right;
                    else
                        parent.right = root.right;
                }
                else if (root.right == null) {
                    if (parent.left == null)
                        parent.left = root.left;
                    else
                        parent.right = root.left;
                }
                else {
                    int in = inorderSuccesor(root.right);
                    root.data = in;
                    delete(root.right, root, in);

                }

            }

    }
    public int inorderSuccesor(Node node)
    {

        if(node.left==null)
            return node.data;
        return inorderSuccesor(node.left);
    }
    public void BFS()
    {
        Queue<Node> queue= new LinkedList<>();
        Node node= this.root;
        queue.add(node);
        queue.add( null);
        while(queue.size()>1)
        {
            Node t=queue.remove();
            if(t!=null) {
                System.out.print(t.data + "   ");
                if(t.left!=null)
                queue.add(t.left);
                if(t.right!=null)
                queue.add(t.right);
            }else
            {
                System.out.println("\n--------------");
            queue.add(null);
            }
        }
    }
    public void levelOrder() {
        Node node = root;
        int height = height(node);
        for (int i = 0; i <= height; i++) {
            levelOrder(node, i, 0);

            System.out.println("\n----------");
        }
    }

    private void levelOrder(Node node, int toreachLevel, int level) {
    if(node==null)
        return;
    if(level==toreachLevel) {
        System.out.print(node.data+"    ");
    }

    levelOrder(node.left,toreachLevel,level+1);
    levelOrder(node.right,toreachLevel,level+1);
    }
    public int noOfNodes( Node node)
    {
        if(node==null)
            return 0;
        return 1+noOfNodes(node.left)+noOfNodes(node.right);
    }
    public int sumOfAllNodes(Node node)
    {if(node==null)
        return 0;
    return node.data+sumOfAllNodes(node.left)+sumOfAllNodes(node.right);

    }
    public int diameter(Node node)
    {
        if(node==null)
            return 0;
        int lh=height(node.left);
        int rh=height(node.right);
        int op1=lh+rh+2;
        int op2=diameter(node.left);
        int op3=diameter(node.right);
        return Math.max(Math.max(op1,op2),op3);
    }
    class Pair
    {
        int height;
        int diameter;
        Pair(int h, int d)
        {height=h;
        diameter=d;
        }
    }
    public int diameterOfTree()
    {
        Pair ans=optimisedDiameter(root);
        return ans.diameter;
    }
    public Pair optimisedDiameter(Node node )
    {
        if(node==null)
        {
            Pair bs = new Pair(-1,0);
            return bs;
        }
 Pair lh=optimisedDiameter(node.left);
        Pair  rh =optimisedDiameter(node.right);
       int height=Math.max(lh.height,rh.height)+1;
       return new Pair(height,Math.max( lh.height+rh.height+2,Math.max(lh.diameter,rh.diameter)));
       }
       public Boolean isHeightBalanced( Node node)
       {
           if(node==null)
               return true;
           int lh= height(node.left);
           int rh =height(node.right);
           if(Math.abs(lh-rh)>1)
               return false;
           return isHeightBalanced(node.left)&&isHeightBalanced(node.right);
       }
       class PairOfHeighStatus
       {
           public Boolean status;
           public int height;
           PairOfHeighStatus(boolean s, int h)
           {
               status=s;
               height=h;
           }
       }
       public boolean isHeightBalancedOptimised( ) {
           PairOfHeighStatus ans = isHeightBalancedOptimised(root);
            return ans.status;
       }

    private PairOfHeighStatus isHeightBalancedOptimised(Node trav) {

   if(trav==null)
   {
       return new PairOfHeighStatus(true, -1);
   }
   PairOfHeighStatus l= isHeightBalancedOptimised(trav.left);
   if(l.status==false)
       return l;// if this conditionn is not written then only root balnced will be checked
   PairOfHeighStatus r= isHeightBalancedOptimised(trav.right);
   if(r.status==false)
       return r;
   int height=Math.max(l.height,r.height)+1;
   boolean ans=(Math.abs(l.height-r.height))>1?false:true;
   return new PairOfHeighStatus(ans,height);
    }
    public int findLCA( int k1 , int k2)
    {
        return findLCA(root,k1,k2);
    }

    private int findLCA(Node root, int k1, int k2)
    {       if(root==null)
                return -1;
        if( root.data> k1 && root.data>k2)
            return findLCA(root.left,k1,k2);
        else if(root.data<k1&&root.data<k2)
            return findLCA(root.right,k1,k2);
    else if( root.data>k1&& root.data<k2)
        return root.data;
        else
            return -1;
    }
}
