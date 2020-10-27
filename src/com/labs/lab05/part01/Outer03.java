package com.labs.lab05.part01;

public class Outer03 {
    private int he = 25;
    public int getHim(){
        String guy = "he is ";
        class Inner {
            // Need the 'this' because otherwise
            // java will attempt to find the static field.
            // 'this' ensures it looks at the instance field.
            private int x = Outer03.this.he;
            public void printHim(){
                System.out.println(guy+x);
            }
        }
        Inner in = new Inner();
        in.printHim();
        return he;
    }

    public static void main(String[] args) {
        new Outer03().getHim();
    }
}
