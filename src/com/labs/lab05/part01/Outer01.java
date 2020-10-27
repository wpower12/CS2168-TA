package com.labs.lab05.part01;

public class Outer01 {
    private String greeting = "Yo";

    public class Inner {
        public int repeat = 2;

        private void sayIt() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public void callInner() {
        new Inner().sayIt();
    }

    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        Inner inner = outer01.new Inner();
        inner.sayIt();
    }
}
