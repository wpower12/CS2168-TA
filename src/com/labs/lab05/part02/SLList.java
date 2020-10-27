package com.labs.lab05.part02;

import java.util.List;

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

    // Exercise 2.3
    private Node getNode(int index){
        if(index < 0 || index >= n) throw new IndexOutOfBoundsException();
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // Exercise 2.4
    public void addAfter(int k, Item item){
        Node newNode = new Node();
        newNode.item = item;
        Node kthNode = getNode(k);
        newNode.next = kthNode.next;
        kthNode.next = newNode;
        n++;

        // update last (first can't/shouldn't change in this method)
        if(newNode.next == null){
            last = newNode;
        }
    }

    // Exercise 2.5
    // Note - similar to getNode, this operates on nodes, so it should be private?
    private void removeAfter(Node node){
        if(node.next != null) {
            node.next = node.next.next;
        }
        // update last (first can't/shouldn't change in this method.
        if(node.next == null){
            last = node;
        }
    }

    // Exercise 2.6
    // We'll use our private methods to do this.
    public void deleteKth(int k){
        if(n == 0) throw new IndexOutOfBoundsException();
        if(k == 0){
            first = first.next;
        } else {
            removeAfter(getNode(k-1));
        }
        n--;
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

    public static void main(String[] args) {
        System.out.println("Initial test list:");
        List nums = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        SLList nums_sll = new SLList();
        for (int i = 0; i < nums.size(); i++) {
            nums_sll.addLast(nums.get(i));
        }
        System.out.println(nums_sll);

        System.out.println("adding 2 elements - testing updates to last");
        nums_sll.addAfter(0, 9999);
        nums_sll.addAfter(10, 9999);
        System.out.println(nums_sll);

        System.out.println("removing them - testing updates to last");
        nums_sll.deleteKth(1);
        nums_sll.deleteKth(10);
        System.out.println(nums_sll);

        System.out.println("Removing 0th element - testing updates to first");
        nums_sll.deleteKth(0);
        System.out.println(nums_sll);

        System.out.println("Empty List: ");
        nums_sll = new SLList();
        System.out.println(nums_sll);

        System.out.println("removing from it.");
        nums_sll.deleteKth(0);
    }
}
