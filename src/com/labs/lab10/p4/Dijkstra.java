package com.labs.lab10.p4;

import com.labs.lab10.In;

import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        return -1;
    }

    public static void main(String[] args) {
        In in = new In("inputs/G4-1.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}
