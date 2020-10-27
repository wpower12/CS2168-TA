package com.labs.lab05.part01;

public class Outer02 {
    private int x = 21;
    class Inner {
        // "Inner classes cannot have static declarations"
        // public static int x = 68;
        public int x = 68;
        public void showX() {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Outer02 out = new Outer02();
        Outer02.Inner in = out.new Inner();
        in.showX();
    }
}
