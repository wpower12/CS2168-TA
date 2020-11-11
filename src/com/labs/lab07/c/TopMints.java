package com.labs.lab07.c;

import java.io.*;
import java.util.Arrays;

public class TopMints {
    public static void main(String[] args) {
        System.out.print("\nTest 1\n------\n");
        In in = new In("https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");
        int m = 5; // keep only top m integers
        int n = in.readInt(); // the first input integer is the number of input lines that follow
        Integer[] a = new Integer[n];

        MinPQ<Integer> pq = new MinPQ<>(m);

        Stopwatch timer1 = new Stopwatch();
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
            pq.insert(a[i]);
            if (pq.size() > m)
                pq.delMin();
        }
        double time1 = timer1.elapsedTime();

        // print what's in the priority queue
        System.out.printf("\t\t\tTop %d integers are\n", m);
        for (Integer integer : pq) {
            System.out.println(integer);
        }

        // print the time it took to process the entire stream
        System.out.printf("\nIt took %.2f seconds to process %,d integers " +
                "using a priority queue.\n",  time1, n);

        in.close();

        //System.out.print("--------------------------------------------------------------------");
        System.out.print("\nTest 2\n------\n");

        // Test the time it takes to find m largest using sorting
        in = new In("https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");
        m = 5;
        n = in.readInt(); // the first input integer is the number of input lines that follow
        a = new Integer[n];


        Stopwatch timer2 = new Stopwatch();
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
        }
        Arrays.sort(a);

        double time2 = timer2.elapsedTime();


        // print the largest m integers of the sorted array
        System.out.printf("\t\t\tTop %d integers are\n", m);
        for (int i = n-m; i < n; i++) {
            System.out.println(a[i]);
        }

        // print the time it took to process the entire stream
        System.out.printf("\nIt took %.2f seconds to process %,d integers " +
                "by sorting them.\n",  time2, n);

        in.close();
        System.out.println("-------------------------------------------------------------------");

    }
}
