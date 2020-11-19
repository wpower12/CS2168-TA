package com.labs.lab08.a;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IndexGenerator {

    // Tree that stores the index
    private final TreeSet<String> index;

    // Constructor
    public IndexGenerator() { index = new TreeSet<>(); }

    // Reads each word in the input file and store it
    // in an index along with its line number.
    public void buildTree(Scanner scanner) {
        int lineNum = 0;  // line number
        StringTokenizer st;
        String token;

        // keep reading lines util done.
        while (scanner.hasNextLine()) {
            lineNum++;
            st = new StringTokenizer(scanner.nextLine());

            while (st.hasMoreTokens()) {
                token = st.nextToken();
                index.add(String.format("%-11s %2d", token, lineNum));

                // use the following String.format(...) version [inside index.add()]
                // when processing an input file with thousands of lines.
                // This version pads the line numbers with zeros, allowing
                // for correct (alphabetical) placement of nodes in the tree
                // that accounts for the order of the line numbers as well.

                // index.add(String.format("%-20s %05d", token, lineNum));
            }
        }
    }

    // Perform an inorder traversal of the tree
    // and display its nodes to the standard output
    public void showIndex() {
        for (String next : index) {
            System.out.println(next);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream("inputs/tinyTale.txt"));
        // uncomment the following line when you are ready to read the larger file
        // Scanner scanner = new Scanner(new FileInputStream("tale.txt"));

        // The following while loop simply reads the input file and
        // displays each line of the file on your screen. Once you've
        // ensured that this program can read input correctly, you
        // can DELETE OR COMMENT OUT this while loop.
        // while (scanner.hasNextLine()) System.out.println(scanner.nextLine());


        // Once you've implemented and tested the methods in IndexGenerator,
        // UNCOMMENT THE FOLLOWING FOUR STATEMENTS:
        Scanner scan = new Scanner(new FileInputStream("inputs/tinyTale.txt"));

        IndexGenerator index = new IndexGenerator(); // an IndexGenerator instance
        index.buildTree(scan);                       // build a binary search tree
        index.showIndex();                           // display the tree nodes
    }
}
