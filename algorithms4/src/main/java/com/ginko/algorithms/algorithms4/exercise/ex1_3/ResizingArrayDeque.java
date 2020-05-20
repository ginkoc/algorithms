package com.ginko.algorithms.algorithms4.exercise.ex1_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<T> implements Iterable<T> {

    private T[] arr;
    private int first;
    private int last;
    private int total;

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque() {
        arr = (T[]) new Object[1];
        first = 0;
        last = 0;
        total = 0;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public int size() {
        return total;
    }

    public void pushLeft(T item) {
        if (total == arr.length) {
            resize(2 * arr.length);
        }

        first = first - 1;
        if (first < 0) {
            first = arr.length - 1;
        }
        arr[first] = item;
        total++;
    }

    public void pushRight(T item) {
        if (total == arr.length) {
            resize(2 * arr.length);
        }

        if (last == arr.length) {
            last = 0;
        }

        arr[last++] = item;
        total++;
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T res = arr[first];
        arr[first] = null;
        first++;
        total--;

        if (total > 0 && total == arr.length / 4) {
            resize(arr.length / 2);
        } else {
            if (first == arr.length) {
                first = 0;
            }
        }
        return res;
    }

    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T res = arr[--last];
        arr[last] = null;
        total--;
        if (total > 0 && total == arr.length / 4) {
            resize(arr.length / 2);
        } else {
            if (last == 0) {
                last = arr.length;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        assert max >= total;
        T[] tmpArr = (T[]) new Object[max];

        for (int i = 0; i < total; i++) {
            tmpArr[i] = arr[(first + i) % arr.length];
        }
        arr = tmpArr;
        first = 0;
        last = total;
    }

    private class Itr implements Iterator<T> {

        int n = 0;

        public boolean hasNext() {
            return n < total;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T res = arr[(first + n) % arr.length];
            n++;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
