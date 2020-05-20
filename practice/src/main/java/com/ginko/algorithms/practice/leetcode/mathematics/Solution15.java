package com.ginko.algorithms.practice.leetcode.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        int pre = Integer.MAX_VALUE;

        if (nums[0] > 0) {
            return res;
        }

        List<Integer> list;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (nums[i] == pre) {
                continue;
            }

            int twoSum = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] > twoSum) {
                    k--;
                } else if (nums[j] + nums[k] < twoSum) {
                    j++;
                } else {
                    list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);

                    k--;
                    j++;

                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }

            pre = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        int[] input2 = {0, 0, 0};
        System.out.println("args = " + new Solution15().threeSum(input2));
    }
}
