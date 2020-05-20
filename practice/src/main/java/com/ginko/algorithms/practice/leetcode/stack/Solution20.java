package com.ginko.algorithms.practice.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {

    private HashMap<Character, Character> mapping = new HashMap<>(4);

    {
        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put(')', '(');
    }

    public boolean isValid(String s) {
        // 判断字符串长度是否为偶数，不为偶数肯定不能一一匹配
        if ((s.length() & 1) != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            Character mappingc = mapping.get(c);
            if (mappingc == null) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(mappingc)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "){";
        String input2 = "{[([})]}";

        Solution20 s = new Solution20();
        System.out.println("1 = " + s.isValid(input1));
        System.out.println("2 = " + s.isValid(input2));
    }
}