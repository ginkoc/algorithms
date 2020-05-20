package com.ginko.algorithms.algorithms4.basis;

import java.util.NoSuchElementException;

public class FixedCapacityStack<T> {

    private T[] arr;
    private int index;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int capacity) {
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    public void push(T item) {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        arr[index++] = item;
    }

    public T pop() {
        if (index == 0) {
            throw new NoSuchElementException();
        }
        T item = arr[--index];
        arr[index] = null;
        return item;
    }
}
