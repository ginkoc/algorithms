package com.ginko.algorithms.algorithms4.basis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQuque<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        count++;
    }

    public T dequeue() {
        if (count <= 0) {
            throw new NoSuchElementException();
        }

        T res = first.item;
        first = first.next;
        count--;
        if (isEmpty()) {
            last = null;
        }
        return res;
    }

    public String toString() {
        ArrayList<T> list = new ArrayList<T>();
        for (T t : this) {
            list.add(t);
        }
        return list.toString();
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node node = first;

        public boolean hasNext() {
            return node != null;
        }

        public T next() {
            if (node == null) {
                throw new NoSuchElementException();
            }
            T res = node.item;
            node = node.next;
            return res;
        }

        public void remove() {

        }
    }
}
