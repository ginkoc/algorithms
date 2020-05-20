package com.ginko.algorithms.practice.leetcode.stack;

import java.util.Stack;

public class Solution71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // 原来使用的是正则匹配"(/)+"来分割，但是性能很差
        for (String str : path.split("/")) {
            switch (str) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "/a//b////c/d//././/..";

        Solution71 s = new Solution71();
        System.out.println(s.simplifyPath(input1));
    }
}
