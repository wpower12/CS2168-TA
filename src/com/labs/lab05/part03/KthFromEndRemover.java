package com.labs.lab05.part03;

public class KthFromEndRemover {
    public static void removeKthNodeFromEnd(LinkedList head, int k){
        // Straight forward method; walk to end to find N, calculate N-k, walk, delete
        int n = 1;
        LinkedList cur = head;
        while(cur.next != null){
            n++;
            cur = cur.next;
        }

        int target = n-k;
        n = 1;
        cur = head;
        while(n < target){
            cur = cur.next;
            n++;
        }
        // cur now holds the k-1'th node.
        // so we can actually remove the element.
        cur.next = cur.next.next;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value){
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

    // Test Cases:
    public static void main(String[] args) {
        int[] test_vals = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        LinkedList head = new LinkedList(test_vals[0]);
        LinkedList cur  = head;
        for (int i = 1; i < test_vals.length; i++) {
            LinkedList newItem = new LinkedList(test_vals[i]);
            cur.next = newItem;
            cur = newItem;
        }

        System.out.println("test list:");
        System.out.println(head);
        System.out.println("removing; k=4");

        removeKthNodeFromEnd(head, 4);

        System.out.println(head);
    }
}
