package com.lectures.lect06;

public class StackComposition<E> {
   private SLList<E> stackList;

   // no-argument constructor
   public StackComposition() {
      // YOUR CODE HERE
      stackList = new SLList<E>();
   }

   // add an element to this stack
   public void push(E element) {
      // YOUR CODE HERE
      stackList.addFirst(element);
   }

   // remove an element from this stack
   public E pop() {
      // YOUR CODE HERE
      return stackList.removeFirst(); // <- change this line
   }

   // determine if the stack is empty
   public boolean isEmpty() {
      return stackList.isEmpty();
   }

   // A String representation of this stack
   @Override
   public String toString() {
      return stackList.toString();
   }

   // return the size of this stack
   public int size() {
      return stackList.size();
   }

   // test StackComposition
   public static void main(String[] args) {
      StackComposition<Integer> stack = new StackComposition<>();
      // YOUR TEST-CASES BELOW

      // Another test: Make a stack of Strings and read items from a file.
      // (uncomment all commented lines lines below this one.)
      StackComposition<String> stack1 = new StackComposition<>();
      In in = new In("tobe.txt");
      while (!in.isEmpty()) {
         String item = in.readString();
         if (!item.equals("-")) stack1.push(item);
         else if (!stack1.isEmpty()) System.out.print(stack1.pop() + " ");
      }
      System.out.println("(" + stack1.size() + " left on stack)");
      System.out.println(stack1);
   }
}
