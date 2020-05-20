package com.ginko.algorithms.practice.leetcode.str;

public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String longestPrefix = strs[0];
        int longestPrefixLength = strs[0].length();
        int len;
        for (int i = 1; i < strs.length; i++) {
            len = Math.min(longestPrefixLength, strs[i].length());
            int j = 0;

            for (; j < len; j++) {
                if (longestPrefix.charAt(j) != strs[i].charAt(j)) {
                    longestPrefix = longestPrefix.substring(0, j);
                    break;
                }
            }

            if (j == len) {
                longestPrefix = longestPrefix.substring(0, len);
            }

            longestPrefixLength = longestPrefix.length();
            if (longestPrefixLength == 0) {
                return "";
            }
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] inputs = {"b", "a"};
        System.out.println(new Solution14().longestCommonPrefix(inputs));
    }
}
