package com.ginko.algorithms.algorithms4.basis;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] arr;
    private int index;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        arr = (T[]) new Object[1];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void push(T item) {
        if (index == arr.length) {
            resize(2 * arr.length);
        }
        arr[index++] = item;
    }

    public T pop() {
        T item = arr[--index];
        arr[index] = null;
        if (index > 0 && index == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        T[] tmpArr = (T[]) new Object[max];
        System.arraycopy(arr, 0, tmpArr, 0, index);
        arr = tmpArr;
    }

    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    private final class ArrayStackIterator implements Iterator<T> {

        private int n = index;

        public boolean hasNext() {
            return n > 0;
        }

        public T next() {
            if (n <= 0) {
                throw new NoSuchElementException();
            }
            return arr[--n];
        }

        public void remove() {

        }

    }
}
