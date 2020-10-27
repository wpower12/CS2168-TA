package com.quizzes.quiz2.practice;

public class ABC {
    class A {}
    class B extends A {}
    class C extends B {}

    class D<C> {
        A a1 = new A();
        A a2 = new B();
    }
}
