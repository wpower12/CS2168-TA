package com.labs.lab11.a;
///package com.labs.Lab11aSolution;
/******************************************************************************
 *  Compilation:  javac Transaction.java
 *  Execution:    java Transaction
 *
 *  Data type for commercial transactions.
 *
 ******************************************************************************/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 *  Transaction data type encapsulates a commercial
 *  transaction with a customer name, date, and amount.
 */
public class Transaction implements Comparable<Transaction> {
    private final String  who;      // customer
    private final LocalDate when;   // date
    private final double  amount;   // amount


    // Initializes a new transaction from the given arguments.
    public Transaction(String who, LocalDate when, double amount) {
        this.who    = who;
        this.when   = when;
        this.amount = amount;
    }

    // Initializes a new transaction by parsing a string of the form NAME DATE AMOUNT.
    public Transaction(String transaction) {
        String[] a = transaction.split("\\s+");
        who    = a[0];
        String[] dateInfo = a[1].split("/");
        when = LocalDate.of(Integer.parseInt(dateInfo[2]), Integer.parseInt(dateInfo[0]), Integer.parseInt(dateInfo[1]));
        amount = Double.parseDouble(a[2]);
    }

    // Returns the name of the customer involved in this transaction.
    public String who() {
        return who;
    }

    // Returns the date of this transaction.
    public LocalDate when() {
        return when;
    }

    // Returns the amount of this transaction.
    public double amount() {
        return amount;
    }

    // Returns a string representation of this transaction.
    @Override
    public String toString() {
        return String.format("%-11s %11s %13.2f", who, when, amount);
    }

    // Compares two transactions by amount.
    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    // Compares this transaction to the specified object.
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Transaction that = (Transaction) other;
        return (this.amount == that.amount) && (this.who.equals(that.who))
                && (this.when.equals(that.when));
    }


    // Returns a hash code for this transaction.
    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
    }

    // Compares two transactions by customer name.
    public static class WhoOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }

    // Compares two transactions by date.
    public static class WhenOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return v.when.compareTo(w.when);
        }
    }

    //Compares two transactions by amount.
    public static class HowMuchOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return Double.compare(v.amount, w.amount);
        }
    }

    // Tests/prints the transaction data. Sorts the data in various ways.
    public static void main(String[] args) {
        final int numOfLines = 100;  // number of lines in the input file (either 10, 100, or 100000)
        In in = new In("inputs/1000000records.txt");  // input files: 10records.txt, 100records.txt, or 1000000records.txt
        Transaction[] a = new Transaction[numOfLines];  // allocate an array of Transaction objects

        // populate the array of transaction objects
        for (int line = 0; line < numOfLines; line++) {
            a[line] = new Transaction(in.readLine());
        }

        // print the input transaction data (unsorted array)
        System.out.println("Unsorted");
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println();

        // sort transactions by date
        System.out.println("Sort by date");
        Arrays.sort(a, new Transaction.WhenOrder());
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println();

        // sort transactions by customer name
        System.out.println("Sort by customer");
        Arrays.sort(a, new Transaction.WhoOrder());
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println();

        // sort transactions by dollar amount
        System.out.println("Sort by amount");
        Arrays.sort(a, new Transaction.HowMuchOrder());

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println();

        /////// Last exercise (if I assign it): Priority Queue //////////
        // If the last exercise asks to find a faster way to find the //
        // largest 10 transactions by amount, use a priority queue.   //
        ////////////////////////////////////////////////////////////////
        PriorityQueue<Transaction> pq = new PriorityQueue<>(11);  // need 10 largest: pq capacity = 11.
        In in2 = new In("inputs/1000000records.txt");
//      final int numOfLines = 1000000;   // uncomment the 'numOfLines line' above (under main()) to make this line compile

        final long startTime = System.currentTimeMillis();  // start timing

        for (int line = 0; line < numOfLines; line++) {
            pq.add(new Transaction(in2.readLine()));

            if (pq.size() > 10)  // as soon as the 11-th item is added to the queue,
                pq.remove();      // remove the smallest of the 11 items (10 are kept on the queue always)
        }
        final long endTime = System.currentTimeMillis();   // end timing - priority queue is built.

        // print what's on the priority queue
        while (!pq.isEmpty())
            System.out.println(pq.remove());

        // print how long it took to find the largest 10 (by amount) transactions
        System.out.println("\nTime it took to find 10 largest using a priority queue: " + (endTime - startTime)/1000F + "seconds.");
    }

}