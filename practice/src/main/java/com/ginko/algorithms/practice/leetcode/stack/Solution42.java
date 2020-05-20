package com.ginko.algorithms.practice.leetcode.stack;

import java.util.Stack;

public class Solution42 {

    public int trap(int[] height) {
        int sum = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int topH = height[stack.pop()];

                if (stack.isEmpty()) {
                    break;
                }

                int width = current - stack.peek() - 1;
                sum += width * (Math.min(height[current], height[stack.peek()]) - topH);
            }

            stack.push(current);
            current++;
        }


        return sum;
    }

    public static void main(String[] args) {
        int[] input1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] input2 = {5, 2, 1, 2, 1, 5};

        Solution42 s = new Solution42();
        System.out.println("input = " + s.trap(input1));
    }
}
