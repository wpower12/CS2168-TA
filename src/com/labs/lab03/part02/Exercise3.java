package com.labs.lab03.part02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {

    public static ArrayList<Integer> intersect(ArrayList<Integer> al1, ArrayList<Integer> al2){
        // 'Slow' way, that doesn't abuse the fact that the lists are sorted.
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < al1.size(); i++) {
            if (al2.contains(al1.get(i)) && !result.contains(al1.get(i))){
                result.add(al1.get(i));
            }
        }
        return result;
    }

    public static ArrayList<String> reverse(ArrayList<String> al){
        ArrayList<String> res = new ArrayList<String>();
        for (int i = al.size()-1; i >= 0; i--) {
            res.add(al.get(i));
        }
        // Collections.reverse(al); <- could also just do this, and then return al
        return res;
    }

    public static void main(String[] args) {
        // Test Cases
        // Intersect Method
        System.out.println("Testing intersect -------");
        ArrayList<Integer> l1;
        ArrayList<Integer> l2;
        ArrayList<Integer> res;

        // 1 ----
        l1 = new ArrayList<>(List.of(1, 2, 3, 4));
        l2 = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println("test 1 - Goal: [1, 2, 3, 4]");
        System.out.println(intersect(l1, l2)+"\n");

        // 2 ----
        l1 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
        l2 = new ArrayList<>(List.of(1, 2, 3));
        System.out.println("test 2 - Goal: [3]");
        System.out.println(intersect(l1, l2)+"\n");

        // 3 ----
        l1 = new ArrayList<>(List.of());
        l2 = new ArrayList<>(List.of(1, 2, 3));
        System.out.println("test 3 - Goal: []");
        System.out.println(intersect(l1, l2)+"\n");

        // 3 ----
        l1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10));
        l2 = new ArrayList<>(List.of(1, 2, 2, 3, 9, 11));
        System.out.println("test 3 - Goal: [1, 2, 3, 9]");
        System.out.println(intersect(l1, l2)+"\n");

        // reverse Method
        System.out.println("Testing reverse -------");
        ArrayList<String> teststrs;

        // 1 ----
        teststrs = new ArrayList<String>(List.of("Hello", "world", "from", "CIS2168!"));
        System.out.println("test 1 - Goal: [\"CIS2168!\", \"from\", \"world\", \"Hello\"]");
        System.out.println(reverse(teststrs));

    }
}
