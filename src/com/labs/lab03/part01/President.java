package com.labs.lab03.part01;

public class President  {
    String name;
    int year;

    public President(String firstName, int yearElected) {
        name = firstName;
        year = yearElected;
    }

    public String toString() {
        return name;
    }

    // If you want to use your President class as a test case for
    // your Part2.Exercise4, you might want this.
    @Override
    public boolean equals(Object o){
        President p = (President) o;
        return this.name.equals(p.name) && this.year == p.year;
    }
}