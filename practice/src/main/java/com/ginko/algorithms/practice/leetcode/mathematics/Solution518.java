package com.ginko.algorithms.practice.leetcode.mathematics;

public class Solution518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 5};
        int[] input1 = {2};
        int[] input2 = {10};

        System.out.println("args = [" + new Solution518().change(10, input2) + "]");
    }
}
