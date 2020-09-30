package com.quizzes.quiz1;

public class ZooKeeper {
    void go(){
        Zebra z = new Zebra();
        Mammal m = (Mammal) z;
        System.out.println(z.name+z.makeNoise());
        System.out.println(m.name+m.makeNoise());
    }

    public static void main(String[] args) {
        new ZooKeeper().go();
    }
}
