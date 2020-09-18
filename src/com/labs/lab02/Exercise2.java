package com.labs.lab02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    /* This is a more efficient solution than the naive, but it's not
      the most efficient. It involves sorting the array (which is
      done by calling a library method and is assumed to take O(nlog(n))
      time) and then examining the array entries in one pass. People are
      not expected to come up with this solution yet, but some may.
          [ Complexity: O(nlog(n)) time | O(1) space ]
      */
    static int[] twoSumBetter(int[] a, int target) {
        int[] result = new int[2];
        Arrays.sort(a);
        int lo = 0;             // leftmost  index of the array
        int hi = a.length - 1;  // rightmost index of the array
        int sum;
        while (lo < hi) {
            sum = a[lo] + a[hi];
            if (sum == target) {
                result[0] = a[lo];
                result[1] = a[hi];
                return result;
            }
            else if (sum < target) lo += 1;
            else if (sum > target) hi -= 1;
        }
        return new int[0];
    }

    /* This is a solution with the best time complexity, but it uses the
       hash table data structure with which people are not yet familiar.
            [ Complexity: O(n) time | O(n) space ]
       */
    static int[] twoSumBest(int[] a, int target) {
        int[] result = new int[2];
        Set<Integer> memo = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            if ( memo.contains(target - a[i]) ) {
                result[0] = target - a[i];
                result[1] = a[i];
                return result;
            }
            else memo.add(a[i]);
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
