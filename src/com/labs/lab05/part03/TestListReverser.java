package com.labs.lab05.part03;

import java.util.ArrayList;
import java.util.List;

public class TestListReverser {
    public static void main(String[] args) {

        // TEST 1
        ListReverser.LinkedList  test1 = sampleLinkedList(new int[] {0, 1, 2, 3, 4, 5});
        List<Integer> result1 = toArrayList(ListReverser.reverse(test1));
        int[] expected1 = new int[] {5, 4, 3, 2, 1, 0};
        if (arraysEqual(result1, expected1))
            System.out.println("Test 1 is good to go!");
        else System.out.println("TEST 1 FAILED");

        // TEST 2
        ListReverser.LinkedList  test2 = sampleLinkedList(new int[] {0, 1});
        List<Integer> result2 = toArrayList(ListReverser.reverse(test2));
        int[] expected2 = new int[] {1, 0};
        if (arraysEqual(result2, expected2))
            System.out.println("Test 2 is good to go!");
        else System.out.println("TEST 2 FAILED");

        // TEST 3
        ListReverser.LinkedList  test3 = sampleLinkedList(new int[] {0});
        List<Integer> result3 = toArrayList(ListReverser.reverse(test3));
        int[] expected3 = new int[] {0};
        if (arraysEqual(result3, expected3))
            System.out.println("Test 3 is good to go!");
        else System.out.println("TEST 3 FAILED");
    }

    public static ListReverser.LinkedList sampleLinkedList(int[] values) {
        ListReverser.LinkedList list = new ListReverser.LinkedList(values[0]);
        ListReverser.LinkedList current = list;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListReverser.LinkedList(values[i]);
            current = current.next;
        }
        return list;
    }

    public static List<Integer> toArrayList(ListReverser.LinkedList ll) {
        List<Integer> arr = new ArrayList<Integer>();
        ListReverser.LinkedList current = ll;
        while (current != null) {
            arr.add(current.value);
            current = current.next;
        }
        return arr;
    }

    public static boolean arraysEqual(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) return false;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) return false;
        }
        return true;
    }
}
