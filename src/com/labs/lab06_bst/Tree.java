package com.labs.lab06_bst;

// Note - We're using a type variable with inheritance here. Allows the tree to store anything that
//        extends the class 'comparable'. Makes sense since we need to be able to call compare methods.
class TreeNode <T extends Comparable<T>>{
    TreeNode<T> leftNode;   // left - all things 'smaller' than data
    T data;                 //  'middle' or 'current' node
    TreeNode<T> rightNode;  // right - all things 'larger' than data

    public TreeNode(T nodeData){
        leftNode = null;
        rightNode = null;
        data = nodeData;
    }

    public void insert(T insertValue) {
        if(insertValue.compareTo(data) < 0){
            // Insert into the LEFT subtree.
            if(leftNode == null){
                leftNode = new TreeNode<>(insertValue);
            } else {
                leftNode.insert(insertValue);
            }

        } else if(insertValue.compareTo(data) > 0){
            // Insert into the RIGHT subtree.
            if(rightNode == null){
                rightNode = new TreeNode<>(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }
}

// The 'outer' class that a client will actually interact with.
// Note - The same kind of signature, ensuring we use type T that is comparable.
public class Tree<T extends  Comparable<T>> {

    private TreeNode<T> root;

    public Tree(){
        // TODO
        root = null;
    }

    public void insertNode(T insertValue){
        if(root != null){
            root.insert(insertValue);
        } else {
            root = new TreeNode<>(insertValue);
        }
    }

    // *** Traversal Code ***
    // *public* methods that a client will interact with - Should make use of
    // private methods that operate on actual TreeNodes
    public void preorderTraversal(){
        // TODO - (ME)LR
        preorderHelper(root);
    }

    public void inorderTraversal(){
        // TODO - L(ME)R
        inorderHelper(root);
    }

    public void postorderTraversal(){
        // TODO - LR(ME)
        postorderHelper(root);
    }

    // *private* methods you will use to build the traversals - operate on TreeNodes
    private void preorderHelper(TreeNode<T> node){
        if(node == null) return;
        // TODO - (ME)LR
        System.out.printf("%s ", node.data); //(ME)
        preorderHelper(node.leftNode);      // L
        preorderHelper(node.rightNode);     // R
    }

    private void inorderHelper(TreeNode<T> node){
        if(node == null) return;
        // TODO - L(ME)R
        inorderHelper(node.leftNode); // L
        System.out.printf("%s ", node.data); // (ME)
        inorderHelper(node.rightNode); // R

    }

    private void postorderHelper(TreeNode<T> node){
        if(node == null) return;
        // TODO - LR(ME)
        postorderHelper(node.leftNode);      // L
        postorderHelper(node.rightNode);     // R
        System.out.printf("%s ", node.data);// (ME)
    }

    // *** Depth Code ***
    private int depth(TreeNode<T> node){
        // TODO - Future Assignment.
        // YOUR CODE HERE? Hint - What if you do something during traversal more interesting than printing?
        return -1;
    }

    public int depth(){
        return depth(this.root);
    }
}
