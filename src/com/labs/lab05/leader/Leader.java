package com.labs.lab05.leader;

import java.util.Arrays;

/******************************************************************************
 *  Compilation:  javac Leader.java
 *  Execution:    java Leader m n
 *  Dependencies: Queue.java (based on SinglyLinkedList.java developed in class)
 *
 *  Solves the Leader problem.
 *
 *  % java Leader 7 2
 *  2 4 6 1 5 3
 *  leader: 7
 *
 *  % java Leader 7 3
 *  3 6 2 7 5 1
 *  leader: 4
 *
 *  % java Leader 9 5
 *  5 1 7 4 3 6 9 2
 *  leader: 8
 ******************************************************************************/

public class Leader {

    public static void findLeader(int n, int m){
        // place the candidates in a queue
        Queue<Integer> circle = new Queue<>();
        for (int i = 1; i <= n; i++)
            circle.enqueue(i);

        while (circle.size() != 1) {
            for (int i = 1; i < m; i++)
                circle.enqueue(circle.dequeue());
            System.out.print(circle.dequeue() + " ");
        }
        System.out.println("\nleader: " + circle.dequeue());
    }

    public static void main(String[] args) {
        int N = 9;
        int M = 5;
        findLeader(N, M);
    }
}
