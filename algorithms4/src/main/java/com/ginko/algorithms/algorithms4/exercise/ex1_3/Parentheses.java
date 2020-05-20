package com.ginko.algorithms.algorithms4.exercise.ex1_3;


import com.ginko.algorithms.algorithms4.basis.LinkedListStack;

public class Parentheses {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT_PAREN || c == LEFT_BRACE || c == LEFT_BRACKET) {
                stack.push(c);
            }

            if (c == RIGHT_PAREN) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != LEFT_PAREN) {
                    return false;
                }
            } else if (c == RIGHT_BRACE) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != LEFT_BRACE) {
                    return false;
                }
            } else if (c == RIGHT_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != LEFT_BRACKET) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
