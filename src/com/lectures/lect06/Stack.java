package com.lectures.lect06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
   private Node<Item> first;     // top of stack
   private int n;                // size of the stack

   // helper node class
   private static class Node<Item> {
      private Item item;
      private Node<Item> next;
   }

   // Initializes an empty stack.
   public Stack() {
      first = null;
      n = 0;
   }

    // Return true if this stack is empty; false otherwise
   public boolean isEmpty() {
      return first == null;
   }

   // Return the number of items in this stack
   public int size() { return n; }

   /**
    * Adds the item to this stack.
    */
   public void push(Item item) {
      // YOUR CODE HERE
      Node newNode = new Node();
      newNode.item = item;
      newNode.next = first;
      first = newNode;
      n++;
   }

   /**
    * Removes and returns the item most recently added to this stack.
    */
   public Item pop() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      // YOUR CODE HERE
      Item ret = first.item;
      first = first.next;
      n--;
      return ret;                   // <- change this line and return the saved item
   }


   /**
    * Returns (but does not remove) the item most recently added to this stack.
    */
   public Item peek() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      return first.item;
   }

   /**
    * Returns a string representation of this stack.
    */
   public String toString() {
      StringBuilder s = new StringBuilder();
      for (Item item : this) {
         s.append(item);
         s.append(' ');
      }
      return s.toString();
   }


   /**
    * Returns an iterator to this stack that iterates through the items in LIFO order.
    */
   public Iterator<Item> iterator() {
      return new LinkedIterator(first);
   }

   // an iterator, must have methods next() and hasNext();
   // doesn't implement remove()
   private class LinkedIterator implements Iterator<Item> {
      private Node<Item> current;

      // constructor
      public LinkedIterator(Node<Item> first) {
         current = first;
      }

      // IMLEMENT THIS METHOD. (Your code will not compile if you don't)
      public boolean hasNext() {
         // YOUR CODE HERE
         return current != null;
      }

      // IMLEMENT THIS METHOD. (Your code will not compile if you don't)
      public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         Node old = current;
         if(current.next == null){
            current = null;
         } else {
            current = current.next;
         }
         return (Item) old.item;                   // <- change this line and return the saved item
      }
   }


   // Unit tests the Stack data type.
   public static void main(String[] args) {
      // YOUR CODE BELOW.

      Stack<String> stack = new Stack<String>();

      // When you're done, code below this line will work.
      // (If it doesn't, there's something wrong with your stack.
      // Please fix it before uploading to Canvas.)
      In in = new In("tobe.txt");
      while (!in.isEmpty()) {
         String item = in.readString();
         if (!item.equals("-")) stack.push(item);
         else if (!stack.isEmpty()) System.out.print(stack.pop() + " ");
      }
      System.out.println("(" + stack.size() + " left on stack)");

      // Have the client print the stack.
      // Once you make your class Iterable, you can use the for-each construct.
      for (String s : stack) {
         System.out.println(s);
      }
   }
}
