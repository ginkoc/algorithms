package com.ginko.algorithms.practice.bytedance;

import java.util.NoSuchElementException;

public class MinStack {

    private Node head;
    private int count;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = null;
        count = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        Node node = new Node();
        node.val = x;
        node.next = head;
        head = node;

        count++;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (count == 0) {
            throw new NoSuchElementException();
        }

        int res = head.val;
        head = head.next;
        count--;

        if (res == min) {
            calculateMinValue();
        }
    }

    public int top() {
        if (count == 0) {
            throw new NoSuchElementException();
        }

        return head.val;
    }

    public int getMin() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        return min;
    }

    private void calculateMinValue() {
        if (count == 0) {
            min = Integer.MAX_VALUE;
        } else {
            min = head.val;
            Node tmpNode = head;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
                if (tmpNode.val < min) {
                    min = tmpNode.val;
                }
            }
        }
    }

    private class Node {
        int val;
        Node next;
    }
}
