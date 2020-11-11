package com.labs.lab07.b;


import java.util.ArrayList;
import java.util.Arrays;

public class TreeHeightCalculator {
    int n;
    int parent[];
    private ArrayList<Integer>[] nodes; // n adjacency lists (one for each node)
    int root;

    void readTree(String fileName) {
        TreeReader in = new TreeReader(fileName);
        n = in.nextInt(); // the number of nodes in the tree (first line)
        //System.out.println(n);
        parent = in.readNInts(n);
        //System.out.println(Arrays.toString(parent));
        nodes = new ArrayList[n];
        for (int node = 0; node < n; node++) {
            nodes[node] = new ArrayList<>(); // children of node node
        }
        for (int i = 0; i < this.parent.length; i++) {
            int parent = this.parent[i];
            if (parent == -1) root = i;
            else nodes[parent].add(i);
        }
        //System.out.println(Arrays.toString(nodes));
    }

    int computeHeight() {
        // Replace this code with a faster implementation
//      int maxHeight = 0;
//      for (int vertex = 0; vertex < n; vertex++) {
//         int height = 0;
//         for (int i = vertex; i != -1; i = parent[i])
//            height++;
//         maxHeight = Math.max(maxHeight, height);
//      }
//      return maxHeight;
        return compute(root);
    }

    int compute(int root) {
        int height = 0;
        for (int i = 0; i < nodes[root].size(); i++) {
            height = Math.max(height,compute(nodes[root].get(i)));
        }
        return height + 1;
    }

    public static void main(String[] args) {
        TreeHeightCalculator t = new TreeHeightCalculator();
        int height;

        // test case 0 (example on page 1 of instructions)
        t.readTree("TestCases/tree.txt");
        height = t.computeHeight();
        System.out.println(height);

        // test case 1 (the tree from sample run 1 of the instructions)
        t.readTree("TestCases/tree1.txt");
        height = t.computeHeight();
        System.out.println(height);

        // test case 2 (the tree from sample run 2 of the instructions)
        t.readTree("TestCases/tree2.txt");
        height = t.computeHeight();
        System.out.println(height);

        // test case 3
        t.readTree("TestCases/tree3.txt");
        height = t.computeHeight();
        System.out.println(height);
    }
}

