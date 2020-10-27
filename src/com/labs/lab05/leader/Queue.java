package com.labs.lab05.leader;

public class Queue<Item> {
    private SinglyLinkedList<Item> listQ = new SinglyLinkedList<>();

    public void enqueue (Item item) { listQ.addLast(item); }

    public Item dequeue() { return listQ.removeFirst(); }

    public int size() { return listQ.size(); }

    public boolean isEmpty() { return listQ.isEmpty(); }
}
