package com.ginko.algorithms.practice.leetcode.mathematics;


import java.util.Arrays;

public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;

        if (nums.length <= 3) {
            for (int n : nums) {
                sum += n;
            }
            return sum;
        }

        Arrays.sort(nums);
        int index = 0;
        int tmp;
        int minOffSet;
        int offSet = Integer.MAX_VALUE;

        for (; index < nums.length; index++) {
            int twoSum = target - nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            minOffSet = Integer.MAX_VALUE;

            while (left < right) {
                tmp = nums[left] + nums[right];

                if (tmp < twoSum) {
                    left++;
                } else if (tmp > twoSum) {
                    right--;
                } else {
                    minOffSet = 0;
                    break;
                }

                offSet = tmp - twoSum;
                if (Math.abs(offSet) >= minOffSet) {
                    sum = target + offSet;
                    break;
                } else {
                    minOffSet = Math.abs(offSet);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] input = {-1, 2, 1, -4, 6, 7, 2};
        System.out.println("args = [" + new Solution16().threeSumClosest(input, 1) + "]");
    }
}
