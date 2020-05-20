package com.ginko.algorithms.algorithms4.exercise.ex1_3;

import java.util.NoSuchElementException;

public class DoubleNodeExercise<T> {

    private DoubleNode first;
    private DoubleNode last;
    private int count = 0;

    public void addHeader(T item) {
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        first.previous = null;
        if (count == 0) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.previous = first;
        }
        count++;
    }

    public void addTail(T item) {
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        last.next = null;
        if (count == 0) {
            first = last;
        } else {
            last.previous = oldLast;
            oldLast.next = last;
        }
        count++;
    }

    public void deleteHeader() {
        if (count == 0) {
            throw new NoSuchElementException();
        }

        first = first.next;
        count--;
        if (count == 0) {
            last = first;
        } else {
            first.previous = null;
        }
    }

    public void deleteTail() {
        if (count == 0) {
            throw new NoSuchElementException();
        }

        last = last.previous;
        count--;
        if (count == 0) {
            first = last;
        } else {
            last.next = null;
        }
    }

    private class DoubleNode {
        T item;
        DoubleNode previous;
        DoubleNode next;
    }
}
