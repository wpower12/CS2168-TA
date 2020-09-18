package com.labs.lab02;

import java.util.Arrays;

public class Exercise2 {
    static int[] twoSum(int[] a, int target) {
        int[] result = new int[2];
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == target) {
                    result[0] = a[i]; result[1] = a[j];
                    return result;
                }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a, result;
        /*------------- START TEST 1 ---------------*/
        a = new int[]{2,11,7,50};
        result = twoSum(a, 9);
        System.out.println(Arrays.toString(result));  // should print [2, 7]

        System.out.println();
        /*------------- START TEST 2 ---------------*/
        a = new int[]{2, 1, 6, 8};
        result = twoSum(a, 10);
        System.out.println(Arrays.toString(result));  // should print [2, 3]

        System.out.println();
        /*------------- START TEST 3 ---------------*/
        a = new int[]{21, -301, -12, -4, -65, 47, -56, -210, -356, 9, 0, -3, 1024};
        result = twoSum(a, -163);
        System.out.println(Arrays.toString(result));  // should print [47, -210]

        System.out.println();
        /*------------- START TEST 4 ---------------*/
        a = new int[]{21, 68};
        result = twoSum(a, 68);
        System.out.println(Arrays.toString(result));  // should print [] (an empty array)

        System.out.println();
        /*------------- START TEST 5 ---------------*/
        a = new int[]{21};
        result = twoSum(a, 21);
        System.out.println(Arrays.toString(result));  // should print [] (an empty array)

        System.out.println();
        /*------------- START TEST 6 ---------------*/
        a = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        result = twoSum(a, 15);
        System.out.println(Arrays.toString(result));  // should print [] (an empty array)
    }
}
