package com.labs.lab04;

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

    /* add a node after a given node */
    private void addAfter(Node<Item> node, Item item) {
        Node<Item> newNode = new Node<>();
        newNode.next = node.next;
        newNode.item = item;
        node.next = newNode;
        n++;
    }

    /* The public get, set, and add methods that follow
     *  are declared in Java's List interface.
     * */

    /* private helper method. Finds the node at a specified position */
    private Node<Item> getNode(int index) {
        Node<Item> current = first;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    // get the item of the node at index
    public Item get(int index) {
        if (index < 0 || index >= n)
            throw new IndexOutOfBoundsException(index);
        Node<Item> node = getNode(index);
        return node.item;
    }

    // set the item at index to newItem, and return the item previously stored at index
    public Item set(int index, Item newItem) {
        if (index < 0 || index >= n)
            throw new IndexOutOfBoundsException(index);
        Node<Item> node = getNode(index);
        Item oldItem = node.item;
        node.item = newItem;
        return oldItem;
    }

    // add the item at index to newItem, and return the item previously stored at index
    public void add(int index, Item newItem) {
        if (index < 0 || index >= n)
            throw new IndexOutOfBoundsException(index);
        if (index == 0)
            addFirst(newItem);
        else {
            Node<Item> node = getNode(index-1);
            addAfter(node, newItem);
        }
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
