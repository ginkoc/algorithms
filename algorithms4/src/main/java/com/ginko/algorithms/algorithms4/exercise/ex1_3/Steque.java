package com.ginko.algorithms.algorithms4.exercise.ex1_3;

import java.util.NoSuchElementException;

public class Steque<T> {

    private Node first;
    private Node last;
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldFirst;
        }
        n++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T res = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = first;
        }
        return res;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            last.next = oldLast;
        }
        n++;
    }

    private class Node {
        T item;
        Node next;
    }
}
