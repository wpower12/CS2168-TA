package com.lectures.lect06;

public class SLList<Item> {
   private Node<Item> first;
   private Node<Item> last;
   private int n; // size of the list

   // helper node class
   private class Node<Item> {
      Item item;
      Node<Item> next;
   }

   // constructor: initializes an empty list
   public SLList() {
      first = last = null;
      n = 0;
   }

   // is the list empty?
   public boolean isEmpty() {
      return first == null;
   }

   // return the size of the list
   public int size() {
      return n;
   }

   // insert an item at the front of the list
   public void addFirst(Item item) {
      if (isEmpty()) { // first & last refer to the same node
         first = last = new Node<Item>();
         first.item = last.item = item;
      } else {  //first refers to the new node
         Node<Item> oldFirst = first;
         first = new Node<Item>();
         first.item = item;
         first.next = oldFirst;
      }
      n++; // increment size after insertion
   }

   // insert item at the end of the list
   public void addLast(Item item) {
      if (isEmpty()) { // first & last refer to the same node
         first = last = new Node<Item>();
         first.item = last.item = item;
      } else { // last.next refers to the new node
         last = last.next = new Node<Item>();
         last.item = item;
      }
      n++; // increment size after insertion
   }

   // remove & return the first item in the list
   public Item removeFirst() {
      if (isEmpty()) throw new RuntimeException("empty list");
      Item removedItem = first.item;  // retrieve the data item being removed
      if (first == last)              // if there's only one node in the list,
         first = last = null;         // update both first & last references
      else       // otherwise, update first only
         first = first.next;
      n--; // decrement size after removal
      return removedItem;
   }


   // remove & return the last item in the list
   public Item removeLast() {
      if (isEmpty()) throw new RuntimeException("empty list");
      Item item = last.item;   // retrieve the data item being removed

      if (first == last)       // if there's only one node in the list,
         first = last = null;  // update both first & last references
      else {  // iterate through the list to locate the last node
         Node current = first;
         while (current.next != last)
            current = current.next;
         last = current;  // current is the new last node
         current.next = null;
      } // end else
      n--; // decrement size after removal
      return item;
   }

   @Override
   public String toString() {
      StringBuilder s = new StringBuilder();
      Node<Item> current = first;
      while (current != null) {
         s.append(current.item + " -> ");
         // s.append(current.item + " ");
         current = current.next;
      }
      s.append("null");
      //s.append("\n");
      return s.toString();
   }
}
