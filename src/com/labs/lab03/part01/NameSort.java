package com.labs.lab03.part01;
import java.util.Comparator;

public class NameSort implements Comparator<President> {
    @Override
    public int compare(President this_one, President that_one) {
        return this_one.name.compareTo(that_one.name);
    }
}
