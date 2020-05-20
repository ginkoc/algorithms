package com.ginko.algorithms.algorithms4.exercise.ex1_3;


import com.ginko.algorithms.algorithms4.basis.LinkedListQuque;

public class Josephus {

    public static void selectSurvivor(int people, int number, LinkedListQuque<Integer> queue) {
        if (queue.size() <= 1) {
            return;
        }

        int n = 1;
        while (queue.size() > 1) {
            int sequence = queue.dequeue();
            if (n == number) {
                System.out.print(sequence + " ");
            } else {
                queue.enqueue(sequence);
            }

            n++;
            if (n > people) {
                n = 1;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListQuque<Integer> queue = new LinkedListQuque<Integer>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        selectSurvivor(7, 2, queue);
    }
}
