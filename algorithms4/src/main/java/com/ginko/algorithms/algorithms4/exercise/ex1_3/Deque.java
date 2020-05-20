package com.ginko.algorithms.algorithms4.exercise.ex1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private int total;
    private Node first;
    private Node last;

    public boolean isEmpty() {
        return total == 0;
    }

    public int size() {
        return total;
    }

    public void pushLeft(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        total++;
    }

    public void pushRight(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        total++;
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T res = first.item;
        first = first.next;
        total--;
        if (isEmpty()) {
            last = first;
        } else {
            first.previous = null;
        }

        return res;
    }

    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T res = last.item;
        last = last.previous;
        total--;
        if (isEmpty()) {
            first = last;
        } else {
            last.next = null;
        }

        return res;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Node {
        T item;
        Node previous;
        Node next;
    }

    private class Itr implements Iterator<T> {

        Node node = first;

        public boolean hasNext() {
            return node != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T res = node.item;
            node = node.next;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
