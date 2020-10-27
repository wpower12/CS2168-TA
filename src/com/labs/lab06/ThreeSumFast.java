package com.labs.lab06;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) {
        // How many triples sum to zero?
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                // Could also do -(a[i]+a[j])
                if (BinarySearch.indexOf(a, -a[i]-a[j]) > j)
                    // We compare its location against j to avoid double counting
                    count++;
        return count;
    }

    public static void main(String[] args) {
        In in = new In("8Kints.txt"); //In in = new In("1Mints.txt");
        int[] a = in.readAllInts();

        //System.out.println("The original array of ints: " + Arrays.toString(a));

        long startTime = System.currentTimeMillis();
        System.out.println("Count is: " + ThreeSumFast.count(a));
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds  : " + timeElapsed);
    }
}
