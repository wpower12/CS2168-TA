package com.quizzes.quiz2.practice;

import java.util.ArrayDeque;

public class ArrayDequeTests {
    public static void main(String[] args) {
        ArrayDeque<String> greetings = new ArrayDeque<String>();

        // Check the docs for push, note how it operates, adding item to the 'top' of the pile
        greetings.push("hello");
        greetings.push("hi");
        greetings.push("ola");

        greetings.pop();
        greetings.peek();

        while(greetings.peek() != null){
            System.out.print(greetings.pop());
        }
    }
}
