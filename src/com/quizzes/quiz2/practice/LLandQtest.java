package com.quizzes.quiz2.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LLandQtest {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        l.add(10);
        l.add(12);
        l.remove(1);
        for(Integer i: l){
            System.out.println(i);
        }

        q.add(10);
        q.add(12);
        q.add(1);
        q.remove(1);
        for(Integer i: q){
            System.out.println(i);
        }

    }
}
