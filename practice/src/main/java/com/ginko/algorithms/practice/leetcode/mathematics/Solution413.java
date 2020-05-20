package com.ginko.algorithms.practice.leetcode.mathematics;

public class Solution413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int tempSum = 0;
        int sum = 0;
        int begin = 0;
        boolean first = true;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                if (first) {
                    begin = i - 2;
                    first = false;
                    tempSum = 1;
                } else {
                    tempSum += (i - begin) - 1;
                }
            } else {
                sum += tempSum;
                tempSum = 0;
                first = true;
            }
        }

        sum += tempSum;
        return sum;
    }

    public static void main(String[] args) {
       /* int[] input = {1, 2, 3, 7, 4, 5, 6};
        System.out.println("args = [" + new Solution413().numberOfArithmeticSlices(input) + "]");*/
    }
}
