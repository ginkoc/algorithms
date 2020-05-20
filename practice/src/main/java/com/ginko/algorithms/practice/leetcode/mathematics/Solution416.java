package com.ginko.algorithms.practice.leetcode.mathematics;


public class Solution416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        sum >>= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int v = sum; v >= num; v--) {
                dp[v] = dp[v] || dp[v - num];
            }
        }

        return dp[sum];
    }
}
