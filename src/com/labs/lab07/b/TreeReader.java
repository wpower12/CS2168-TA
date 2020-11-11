package com.labs.lab07.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// This is a helper class for Lab 7b, the tree exercise. Its purpose is
// to read a tree stored in a text file. The tree is assumed to be stored
// in the format explained in the instructions.
public class TreeReader {
    private Scanner scanner;
    TreeReader(String fileName)  {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // nextInt() is used to read the first line of the input file,
    // which must contain one integer, the number of nodes in the tree
    int nextInt() { return scanner.nextInt(); }

    // readNInts() is used to read the second line of the input file,
    // which contains n integers, each in the range from -1 through n-1,
    // and returns them as an array of ints. READ THE LAB INSTRUCTIONS to
    // understand how to interpret the data in the array returned by this method.
    int[] readNInts(int n) {
        int[] ints = new int[n];
        int i = 0;
        while (scanner.hasNext())
            ints[i++] = scanner.nextInt();
        return ints;
    }
}
