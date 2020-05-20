package com.ginko.algorithms.practice.leetcode.stack;

import java.util.Stack;

public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int i = 0;
        int max = 0;

        while (i < heights.length) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
            i++;
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input1 = {2, 1, 5, 6, 2, 3};
        Solution84 s = new Solution84();
        System.out.println(s.largestRectangleArea(input1));
    }
}
