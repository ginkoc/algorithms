package com.ginko.algorithms.algorithms4.exercise.ex1_3;


import com.ginko.algorithms.algorithms4.basis.LinkedListQuque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings implements Iterable<String> {

    private String[] arr;
    private int firsIndex;
    private int lastIndex;
    private int count;

    public ResizingArrayQueueOfStrings() {
        arr = new String[1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(String str) {
        if (count == arr.length) {
            resize(arr.length * 2);
        } else if (lastIndex == arr.length) {
            lastIndex = 0;
        }

        arr[lastIndex++] = str;
        count++;
    }

    public String dequeue() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        String res = arr[firsIndex];
        arr[firsIndex] = null;
        firsIndex++;
        count--;

        if (count > 0 && count == arr.length / 4) {
            resize(arr.length / 2);
        } else if (count == 0) {
            lastIndex = 0;
            firsIndex = lastIndex;
        } else {
            if (firsIndex == arr.length) {
                firsIndex = 0;
            }
        }
        return res;
    }

    public String peek() {
        return arr[firsIndex];
    }

    private void resize(int max) {
        assert max >= count;
        String[] tmpArr = new String[max];
        for (int i = 0; i < count; i++) {
            tmpArr[i] = arr[(firsIndex + i) % arr.length];
        }

        arr = tmpArr;
        firsIndex = 0;
        lastIndex = count;
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public Iterator<String> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<String> {

        private int index;

        public boolean hasNext() {
            return index < count;
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String s = arr[(firsIndex + index) % arr.length];
            index++;
            return s;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        LinkedListQuque<String> linkedListQuque = new LinkedListQuque<String>();

        for (String s : strings) {
            if (s.equals("-")) {
                queue.dequeue();
                linkedListQuque.dequeue();
            } else {
                queue.enqueue(s);
                linkedListQuque.enqueue(s);
            }
            System.out.println(queue.toString());
            System.out.println(linkedListQuque.toString());
            Arrays.sort(args);
        }
    }
}
