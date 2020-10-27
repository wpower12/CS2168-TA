package com.labs.lab05.leader;

import java.util.NoSuchElementException;

public class SinglyLinkedList<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;  // data item of a node
        Node next;  // points to a Node object
    }

    public boolean isEmpty() { return first == null; }

    public int size() { return N; }

    public void addFirst(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty())  first = last = node;
        else          {
            node.next = first;
            first = node;
        }
        N++;
    }

    public void addLast(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty())  first = last = node;
        else            last = last.next = node;
        N++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Can't remove this item - This list is empty!");
        Item oldfirst = first.item;      // save item to return
        if (first == last) first = last = null;
        else               first = first.next; // delete first node
        N--;                         // decrement size
        return oldfirst;                 // return the saved item
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Can't remove this item - This list is empty!");
        Item oldlast = last.item;      // save item to return
        if (first == last) first = last = null;
        else {
            Node current = first;
            while (current.next != last)
                current = current.next;
            last = current;
            current.next = null;
        }
        N--;
        return oldlast;
    }

    // print all the nodes starting from the first to the last node of the list
    void printNodes() {
        for (Node x = first; x != null; x = x.next) {
            System.out.print(x.item + " -> ");
        }
        System.out.println("null");
    }

    // Unit tests for the SinglyLinkedList
    public static void main(String[] args) {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        //System.out.println(l.removeFirst());  // should throw a NoSuchElementException exception
        //System.out.println(l.removeLast());   // should throw a NoSuchElementException exception

        // Testing addFirst()
        System.out.println("Testing addFirst():");
        l.addFirst(8); //
        l.printNodes();  // prints 8 -> null
        l.addFirst(6);
        l.printNodes();  // prints 6 -> 8 -> null
        System.out.println("List size: " + l.size());  // prints 2
        l.addFirst(1); l.addFirst(2);
        l.printNodes();  // 2 -> 1 -> 6 -> 8 -> null
        System.out.println("List size: " + l.size());  // prints 4

        // Testing addLast()
        System.out.println("\nTesting addLast():");
        l.addLast(2);
        l.printNodes();        // prints 2 -> 1 -> 6 -> 8 -> 2 -> null
        l.addLast(7);
        l.printNodes();        // prints 2 -> 1 -> 6 -> 8 -> 2 -> 7 -> null
        l.addFirst(-33);
        l.printNodes();        // prints -33 -> 2 -> 1 -> 6 -> 8 -> 2 -> 7 -> null

        // Testing removeLast()
        System.out.println("\nTesting removeLast():");
        l.removeLast();
        l.printNodes();  // prints -33 -> 2 -> 1 -> 6 -> 8 -> 2 -> null
        l.removeLast();
        l.printNodes();  // prints -33 -> 2 -> 1 -> 6 -> 8 -> null

        // Testing removeFirst()
        System.out.println("\nTesting removeFirst()");
        l.removeFirst();
        l.printNodes();
        System.out.println("List size: " + l.size());  // prints 4
        l.removeFirst();
        l.printNodes();
        System.out.println("List size: " + l.size());  // prints 3

        //
        System.out.println("\nRemoving first and last:");
        l.removeFirst();
        l.removeLast();
        l.printNodes();  // prints 6 -> null

        System.out.println("\nRemoving the last remaining element:");
        //l.removeLast();
        l.removeFirst();
        l.printNodes();
    }
}

