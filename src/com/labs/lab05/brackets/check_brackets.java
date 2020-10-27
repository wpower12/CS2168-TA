package com.labs.lab05.brackets;

import java.io.*;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {

    public static String getText(String fn) throws IOException {
        FileInputStream fs = new FileInputStream(new File(fn));
        InputStreamReader input_stream = new InputStreamReader(fs);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        return text;
    }

    public static void main(String[] args) throws IOException {
        String text = getText("54");

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket b = new Bracket(next, position+1);
                opening_brackets_stack.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if ( opening_brackets_stack.isEmpty() )  { System.out.printf("%d%n", (position+1)); return; }
                Bracket top = opening_brackets_stack.pop();
                if ( !top.Match(next) )  { System.out.printf("%d%n", (position+1)); return; }

            }
        }

        // Printing answer, write your code here
        if ( opening_brackets_stack.isEmpty() ) System.out.println("Success");

        else {
            Bracket top = opening_brackets_stack.pop();
            System.out.printf("%d%n", top.position);
        }
    }
}
