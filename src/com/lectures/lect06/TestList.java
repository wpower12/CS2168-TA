package com.lectures.lect06;

public class TestList {
   public static void main(String[] args) {
      // create SLlist and add a few items
      SLList<Integer> list1 = new SLList();
      list1.addFirst(8);
      list1.addFirst(6);
      list1.addFirst(1);
      list1.addFirst(2);
      System.out.println(list1);  // prints 2 -> 1 -> 6 -> 8 -> null
      System.out.printf("list1 size: %d.\n\n", list1.size());

      // check remove++++() methods on empty lists:
      SLList<String> list2 = new SLList<>();
      //list2.removeFirst(); // should throw exception
      //list2.removeLast(); // should throw exception

      // check addLast():
      list2.addLast("xavier");
      System.out.println("list 2: " + list2);
      list2.addLast("zeno");
      System.out.println("list 2: " + list2);
      System.out.printf("list2 size: %d.\n\n", list2.size());

      // removing items from the list
      int removedItem = list1.removeFirst();
      System.out.printf("\n%d removed from list1:\n", removedItem);
      System.out.println(list1);  // prints 1 -> 6 -> 8 -> null
      System.out.printf("list1 size: %d.\n", list1.size());

      removedItem = list1.removeLast();
      System.out.printf("\n%d removed from list1:\n", removedItem);
      System.out.println(list1); // prints 1 -> 6 -> null
      System.out.printf("list1 size: %d.\n", list1.size());

      list1.removeLast();
      list1.removeLast();
      System.out.printf("list1 size after removing 2 items: %d.\n", list1.size());

      // throwing exceptions when the list is empty
      //System.out.println("removing from an empty list1...");
      //list1.removeLast();
   }
}
