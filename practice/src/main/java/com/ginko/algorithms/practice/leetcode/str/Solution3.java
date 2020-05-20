package com.ginko.algorithms.practice.leetcode.str;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if (s.length() < 2) {
            return len;
        }

        int begin = 0;
        int end = 0;
        int maxSubLen = 1;

        for (int i = 1; i < len; i++) {
            for (int j = begin; j <= end; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    maxSubLen = Math.max(maxSubLen, end - begin + 1);
                    begin = j + 1;
                    break;
                }
            }
            end++;
        }

        maxSubLen = Math.max(maxSubLen, end - begin + 1);
        return maxSubLen;
    }

    public static void main(String[] args) {
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        String input4 = "s2";

        System.out.println("args = [" + new Solution3().lengthOfLongestSubstring(input4) + "]");
    }
}
