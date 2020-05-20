package com.ginko.algorithms.practice.leetcode.mathematics;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        int val;
        int step = 0;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode tmp;

        while (true) {
            sum = 0;
            if (l1 != null || l2 != null) {
                if (l1 != null) {
                    sum += l1.val;
                }

                if (l2 != null) {
                    sum += l2.val;
                }

                sum += step;
                val = sum >= 10 ? sum - 10 : sum;
                step = sum >= 10 ? 1 : 0;

                tmp = new ListNode(val);
                curr.next = tmp;
                curr = tmp;
            } else {
                if (step == 1) {
                    tmp = new ListNode(step);
                    curr.next = tmp;
                }
                return dummyHead.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
