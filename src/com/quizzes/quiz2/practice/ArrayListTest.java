package com.quizzes.quiz2.practice;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            l1.add(i);
        }

        // Array type expected; found: 'java.util.ArrayList'
        // System.out.println(l1[0]);

        // we need to use the list methods for access.
        System.out.println(l1.get(0));

    }
}
