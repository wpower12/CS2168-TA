package com.labs.lab07.b;

import java.io.IOException;

public class TestTreeHeightCalculator {
    public static void main(String[] args) {
        TreeHeightCalculator t = new TreeHeightCalculator();
        int height;

        // test case 0 (example on page 1 of instructions)
        t.readTree("inputs/TestCases/tree.txt");
        height = t.computeHeight();
        System.out.println(height);

        // ------------------------------------ //
        // you can add your own test cases here //
        // ------------------------------------ //

        // test case: the big tree
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TestTreeHeightCalculator().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeightCalculator tree = new TreeHeightCalculator();
        tree.readTree("inputs/TestCases/treeBig.txt");
        System.out.println(tree.computeHeight());
    }
}
