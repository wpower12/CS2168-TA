package com.labs.lab01;

import java.net.*;
import java.io.*;

import java.util.Scanner;

/**  This class provides a main function to read five lines of a company
 *   Web page and prints them in reverse order, given the name of a company.
 *
 *   Note - Line numbers will be different from the lab document due to added code and comments.
 */

class OpenWebPage {

    //   Prompts the user for the name X of a company (a single string), opens
    //   the Web site corresponding to www.X.com, and prints the first five lines
    //   of the Web page in reverse order.
    public static void main(String[] arg) throws Exception {

        BufferedReader keyoabrd;
        String inputLine;

        keyoabrd = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        // Make sure the line is printed immediately.
        inputLine = keyoabrd.readLine();

        // YOUR CODE HERE





        // DOWN HERE 😹
        URL url = new URL(String.format("http://www.%s.com", inputLine));
        Scanner scan = new Scanner(url.openStream());

        int num_lines = 5;
        String[] strings = new String[num_lines];
        for (int i = 0; i < num_lines; i++) {
            strings[i] = scan.nextLine();
        }

        for (int i = num_lines-1; i >= 0; i--) {
            System.out.println(strings[i]);
        }
    }
}