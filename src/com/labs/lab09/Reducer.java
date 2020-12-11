package com.labs.lab09;

import java.util.HashMap;

public class Reducer {

    public HashMap<String, Integer> reduce(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        System.out.println();
        HashMap<String, Integer> map = map1;
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                map.put(s, map1.get(s) + map2.get(s));
            }
        }

        // Fill in the remainder from map2
        for (String s : map2.keySet()) {
            if (!map.containsKey(s)) map.put(s, map2.get(s));
        }

        return map;
    }

    public static void main(String[] args) {

        Mapper mapper1 = new Mapper("inputs/tiny1.txt");
        HashMap<String, Integer> map1 = mapper1.getWordcount();
        System.out.println(map1);

        Mapper mapper2 = new Mapper("inputs/tiny2.txt");
        HashMap<String, Integer> map2 = mapper2.getWordcount();
        System.out.println(map2);

        HashMap<String, Integer> map = new Reducer().reduce(map1, map2);
        System.out.println(map);
        // System.out.println(new Mapper("inputs/tinyTale.txt").getWordcount());
    }
}