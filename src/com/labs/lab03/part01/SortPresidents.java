package com.labs.lab03.part01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPresidents {
    List<President> list = new ArrayList<>();
    public static void main(String[] args) { new SortPresidents().go(); }

    private void go() {
        populateList();
        for (President president : list) {
            System.out.println(president + " ");
        }

        System.out.println();

        // YOUR 1 LINE OF CODE THAT CREATES A NameSort COMPARATOR OBJECT:
        NameSort ns = new NameSort();
        // YOUR 1 LINE OF CODE THAT SORTS PRESIDENTS BY NAME:
        Collections.sort(list, ns);
        // YOUR 1 LINE OF CODE THAT PRINTS THE PRESIDENTS SORTED BY NAME:
        System.out.println("Sorted by Name: "+list);
        // YOUR 1 LINE OF CODE THAT CREATES A YearSort COMPARATOR OBJECT:
        YearSort ys = new YearSort();
        // YOUR 1 LINE OF CODE THAT SORTS PRESIDENTS BY YEAR BELOW:
        Collections.sort(list, ys);
        // YOUR 1 LINE OF CODE THAT PRINTS THE PRESIDENTS SORTED BY YEAR:
        System.out.println("Sorted by Year: "+list);
    }

    // populates the list with the instances of the President class (don't edit it)
    public void populateList() {
        President jimmy = new President("Jimmy", 1976);
        President ronny = new President("Ronald", 1980);
        President georgeH = new President("George-H", 1988);
        President bill = new President("Bill", 1992);
        President georgeW = new President("George-W", 2000);
        President barack  = new President("Barack", 2008);
        President don  = new President("Donald", 2016);

        list.add(bill);
        list.add(georgeW);
        list.add(georgeH);
        list.add(ronny);
        list.add(barack);
    }
}
