package com.ginko.algorithms.practice.leetcode.mathematics;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i - 1];
                if (j >= coin && dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 5};
        int[] input2 = {2};

        System.out.println("args = [" + new Solution322().coinChange(input, 11) + "]");
    }
}
