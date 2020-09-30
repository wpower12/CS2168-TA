package com.labs.lab03.part02;

import com.labs.lab03.part01.President;

import java.util.ArrayList;
import java.util.List;
public class Exercise4 {

    public static ArrayList removeDups(ArrayList al){
        ArrayList result = new ArrayList();
        result.add(al.get(0));
        for (int i = 1; i < al.size(); i++) {
            if(!result.contains(al.get(i))){
                result.add(al.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        ArrayList<Integer>   al_int;
        ArrayList<String>    al_str;
        ArrayList<President> al_prs;

        System.out.println("Test 1 - goal: [1, 2, 5, 6, 7]");
        al_int = new ArrayList<Integer>(List.of(1, 1, 2, 5, 6, 7, 1, 1));
        System.out.println(removeDups(al_int));

        System.out.println("Test 2 - goal: [apple, boat, car]");
        al_str = new ArrayList<String>(List.of("apple", "apple", "boat", "car", "car"));
        System.out.println(removeDups(al_str));

        // The following will only partially work, unless you
        // @Override the equals(Object o) method in the President.java class
        // with an appropriate comparison method.
        System.out.println("Test 3 - goal: [George, Bill, John A]");
        President georgeh   = new President("George", 1988);
        President clinton   = new President("Bill", 1992);
        President john      = new President("John A", 1797);
        al_prs = new ArrayList<President>(List.of(georgeh,
                georgeh,
                georgeh,
                new President("George", 1988), // This will be considered 'unique' unless fixed
                clinton,
                john));
        System.out.println(removeDups(al_prs));
    }
}
