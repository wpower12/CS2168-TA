package com.labs.lab06;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
                count ++;
        return count;
    }

    public static void main(String[] args) {
        In in = new In("inputs/8Kints.txt");
        int[] a = in.readAllInts();
        System.out.println("Count is: " + count(a));
    }
}
