package com.ginko.algorithms.algorithms4.basis;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfString {

    private String[] arr;
    private int index = 0;

    public FixedCapacityStackOfString(int capacity) {
        arr = new String[capacity];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
    }

    public void push(String str) {
        if (index >= arr.length) {
            throw new UnsupportedOperationException();
        }
        arr[index++] = str;
    }

    public String pop() {
        if (index == 0) {
            throw new IndexOutOfBoundsException();
        }
        String res = arr[--index];
        arr[index] = null;
        return res;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}
