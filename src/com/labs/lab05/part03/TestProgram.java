package com.labs.lab05.part03;

import java.util.ArrayList;
import java.util.List;

public class TestProgram {
    public static void main(String[] args) {

        // test 1
        LinkedListTester test1 = new LinkedListTester(0);
        test1.addItems(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected1 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        KthFromEndRemover.removeKthNodeFromEnd(test1, 4);
        if (compare(test1.getNodesInArray(), expected1))
            System.out.println("Test 1 is good to go!");
        else System.out.println("TEST 1 FAILED");

        // test 2
        LinkedListTester test2 = new LinkedListTester(0);
        test2.addItems(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected2 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        KthFromEndRemover.removeKthNodeFromEnd(test2, 5);
        if (compare(test1.getNodesInArray(), expected1))
            System.out.println("Test 2 is good to go!");
        else System.out.println("TEST 2 FAILED");
    }


    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static class LinkedListTester extends KthFromEndRemover.LinkedList {

        public LinkedListTester(int value) {
            super(value);
        }

        public void addItems(int[] values) {
            KthFromEndRemover.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new KthFromEndRemover.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            KthFromEndRemover.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
