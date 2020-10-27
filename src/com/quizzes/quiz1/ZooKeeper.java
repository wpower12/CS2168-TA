package com.quizzes.quiz1;

public class ZooKeeper {
    void go(){
        Zebra z = new Zebra();
        Mammal m = z;
        // Fields are accessed based on variable type.
        // Additionally, the field in the super type 'shadows' the similarly named field in the sub.
        System.out.println(z.name+z.makeNoise()); // Zebra  fields, Zebra methods
        System.out.println(m.name+m.makeNoise()); // Mammal fields, Zebra methods
        System.out.println();

    }

    public static void main(String[] args) {
        new ZooKeeper().go();
    }
}
