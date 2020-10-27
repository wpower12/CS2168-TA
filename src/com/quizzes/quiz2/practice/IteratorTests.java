package com.quizzes.quiz2.practice;

import java.util.ArrayList; // Oh look its java.util.
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTests<E> {

    public static ArrayList makeTestAL(){
        ArrayList l1 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            l1.add(i);
        }
        return l1;
    }

    public static LinkedList makeTestLL(){
        LinkedList ll1 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            ll1.add(i);
        }
        return ll1;
    }

    public static void main(String[] args) {
        ArrayList l1 = makeTestAL();


        Iterator i1 = l1.iterator();
        // This will throw 'NoSuchElement'
//        for (int i = 0; i < 11; i++) {
//            System.out.println(i1.next());
//        }

        i1.remove(); // Throws illegal state
        // Check the manpage for remove

        LinkedList ll1 = makeTestLL();
        Iterator i2 = ll1.listIterator();

    }
}
