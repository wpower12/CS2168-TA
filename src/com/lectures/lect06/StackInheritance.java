package com.lectures.lect06;

public class StackInheritance<E> extends SLList<E> {

   // add an element to this stack
   public void push(E element) {
      // YOUR CODE HERE
      addFirst(element);
   }

   // remove and return an element from this stack
   public E pop() {
      // YOUR CODE HERE
      return removeFirst(); // <- change this line
   }

   // TEST CASES BELOW
   public static void main(String[] args) {
      StackInheritance<Integer> stack = new StackInheritance<>();
      // YOUR TEST-CASES BELOW

      // Another test: Make a stack of Strings and read items from a file.
      // (uncomment all commented lines lines below this one.)
      StackInheritance<String> stack1 = new StackInheritance<>();
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

