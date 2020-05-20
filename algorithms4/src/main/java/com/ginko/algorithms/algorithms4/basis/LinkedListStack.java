package com.ginko.algorithms.algorithms4.basis;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Iterable<T> {

    private Node first;
    private int count;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T res = first.item;
        first = first.next;
        count--;
        return res;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (node == null) {
                throw new NoSuchElementException();
            }
            T res = node.item;
            node = node.next;
            return res;
        }

        @Override
        public void remove() {

        }
    }
}
