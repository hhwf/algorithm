package com.hhwf.leetcode;

/**
 * @description:
 * @author: hhwf
 * @time: 2020/4/22 17:10
 */
public class LeetCode25_Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        if (k == 0 || k == 1) {
            return head;
        }
        ListNode pre = head;
        ListNode end = null;
        ListNode temp = head;
        return null;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}

