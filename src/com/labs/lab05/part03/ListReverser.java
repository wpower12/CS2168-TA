package com.labs.lab05.part03;

public class ListReverser {
    public static LinkedList reverse(LinkedList head) {
        // Make a new LinkedList as you walk the old one.
        LinkedList new_head = new LinkedList(head.value);
        LinkedList cur = head;
        while(cur.next != null){
            LinkedList new_ll = new LinkedList(cur.next.value);
            new_ll.next = new_head;
            new_head = new_ll;
            cur = cur.next;
        }
        return new_head;
    }
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        // Changing the class just to see what we have done.
        @Override
        public String toString() {
            if(next == null){
                return this.value+" -> null";
            } else {
                return this.value+" -> "+this.next.toString();
            }
        }
    }
}
