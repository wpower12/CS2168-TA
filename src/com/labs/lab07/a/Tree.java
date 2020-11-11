package com.labs.lab07.a;

import java.util.concurrent.TimeUnit;

// class TreeNode definition
class TreeNode  <T extends Comparable<T>> {
    // package access members
    TreeNode<T> leftNode;
    T data; // node value
    TreeNode<T> rightNode;

    // constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(T insertValue) {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else // continue traversing left subtree recursively
                leftNode.insert(insertValue);
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else // continue traversing right subtree recursively
                rightNode.insert(insertValue);
        }
    }
} // end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // constructor initializes an empty Tree
    public Tree() { root = null; }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue) {
        if (root == null)
            root = new TreeNode<T>(insertValue); // create root node
        else
            root.insert(insertValue); // call the insert method
    }

    // begin preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<T> node) {
        if (node == null) return;

        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }

    // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<T> node) {
        if (node == null)  return;

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }

    // begin postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    // recursive method to perform postorder traversal
    private void postorderHelper(TreeNode<T> node) {
        if (node == null) return;

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    ///////////////////////////////////////////////////////////////////
    //////////////////// ADD YOUR OWN METHODS BELOW ///////////////////
    ///////////////////////////////////////////////////////////////////

    // return a reference to the root of this tree
    // public TreeNode<T> getRoot() { return this.root;}

    // get the depth of this node
    private int depth(TreeNode<T> node) {
        if (node == null) return 0;
        else {
            int leftDepth  = depth(node.leftNode);
            int rightDepth = depth(node.rightNode);
            if (leftDepth > rightDepth) return (leftDepth + 1);
            else                        return (rightDepth + 1);
        }
    }

    // get depth of this tree
    public int depth() {
        return depth(this.root);
    }


    // prints this tree from the root down, level-by-level
    public void levelOrder() {
        Queue < TreeNode<T> > queue = new Queue<>();  // create a queue of TreeNodes

        int currentLevel = depth(); // tree level to print (initially tree height)
        TreeNode<T> current;        // a reference to a tree node (initially null)

        // if there are no nodes in this tree, output an error message and return.
        if (this.root == null) {
            System.out.println("There's no tree here to print.");
            System.out.println("Try printing a tree that has nodes.");
            return;
        }

        // otherwise, follow the pseudocode in the instructions to print this tree
        queue.enqueue(this.root);    // put the root node in the queue
        while (!queue.isEmpty()) {   // while the queue is not empty
            current = queue.dequeue();   // remove the first item from the queue

            // output a newline after all nodes at the current level are printed
            if (depth(current) < currentLevel) {
                System.out.println();
                currentLevel--;
            }

            System.out.print(current.data + " ");       // print the node's data

            // put the children of this node in the queue
            if ( current.leftNode != null )
                queue.enqueue(current.leftNode);
            if ( current.rightNode != null )
                queue.enqueue(current.rightNode);
        }
    }
} // end class Tree

