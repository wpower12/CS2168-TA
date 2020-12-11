package com.labs.lab10.p2;

import com.labs.lab10.In;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int count = 0;
        //write your code here
        boolean[] marked = new boolean[adj.length]; // all entries initialized to false
        for (int v = 0; v < adj.length; v++) {
            if (!marked[v]) {
                dfs(adj, v, marked);
                count++;
            }
        }
        return count;
    }

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) {
        marked[v] = true;
        for (int w : adj[v]) {
            if (!marked[w]) dfs(adj, w, marked);
        }
    }

    public static void main(String[] args) {
        In in = new In("inputs/G2-3.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}