package com.quizzes.quiz1;

public class Tenor {

    public static String sing(){
        return "fa";
    }

    public static void main(String[] args) {
        Tenor t = new Tenor();
        Singer s = new Singer();
        System.out.println(t.sing()+" "+s.sing());
    }
}
