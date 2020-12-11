package com.labs.lab09;

import java.util.LinkedList;
import java.util.List;

public class Problem1TreeAnswer {
    private static List<Integer> nodeList = new LinkedList<>();


    public static List<Integer> createList(TreeNode<Integer> node) {
        if (node == null) return null;
        nodeList.add(node.data);
        createList(node.left);
        createList(node.right);
        return nodeList;
    }

    public static void main(String[] args) {
        TreeNode               root,
                node1,                node2,
                node3,         node4,     node5,
                node6, node7,  node8,  node9,    node10;

        root = new TreeNode(49);
        node1 = new TreeNode(21);
        node2 = new TreeNode(68);
        node3 = new TreeNode(20);
        node4 = new TreeNode(40);
        node5 = new TreeNode(55);
        node6 = new TreeNode(11);
        node7 = new TreeNode(19);
        node8 = new TreeNode(33);
        node9 = new TreeNode(44);
        node10 = new TreeNode(66);

        root.left = node1; root.right = node2;
        node1.left = node3; node1.right = node4;
        node2.left = node5;
        node3.left = node6; node3.right = node7;
        node4.left = node8; node4.right = node9;
        node5.right = node10;

        System.out.println(createList(root));
    }
}