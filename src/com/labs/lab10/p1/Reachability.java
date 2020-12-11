package com.labs.lab10.p1;

import com.labs.lab10.In;

import java.util.ArrayList;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        boolean[] marked = new boolean[adj.length]; // all entries initialized to false
        dfs(adj, x, marked);
        if(marked[y]) return 1;
        else return 0;
        // return (marked[y] == true ? 1 : 0); //shorthand for the previous two lines
    }

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) {
        marked[v] = true;
        for (int w : adj[v]) {
            if (!marked[w]) dfs(adj, w, marked); // We only recurse if not marked. note in dfs we just immediately recurse
        }
    }


    public static void main(String[] args) {
        In in = new In("inputs/G1-3.txt");
        int n = in.readInt();  // number of vertices
        int m = in.readInt();  // number of edges

        // for each vertex, allocate space for its adjacency list
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // read the next m lines of input and build an
        // adjacency list representation of the graph
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        //System.out.println(Arrays.toString(adj) + "\n");

        // read the last line of the input file.
        // x = the start vertex; y = the end vertex
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        // is y reachable from x
        System.out.println(reach(adj, x, y));
    }
}
