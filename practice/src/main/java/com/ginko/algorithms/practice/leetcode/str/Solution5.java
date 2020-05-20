package com.ginko.algorithms.practice.leetcode.str;

public class Solution5 {

    int longest = 0;
    int resLeft = 0;
    int resRight = 0;

    public String longestPalindrome(String s) {
        int left;
        int right;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;

                updateLongestPosition(s, left, right);
            }

            if (i + 1 < s.length() && i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i + 1)) {
                left = i - 1;
                right = i + 1;

                updateLongestPosition(s, left, right);
            }
        }

        return s.substring(resLeft, resRight + 1);
    }

    private void updateLongestPosition(String s, int left, int right) {
        while (true) {
            if (left - 1 < 0 || right + 1 >= s.length() || s.charAt(left - 1) != s.charAt(right + 1)) {
                if (right - left + 1 > longest) {
                    resLeft = left;
                    resRight = right;
                    longest = right - left + 1;
                }
                break;
            }

            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String input = "aaaa";
        System.out.println("args = [" + new Solution5().longestPalindrome(input) + "]");
    }
}
