package com.hhwf.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/29 22:10
 *
 */
public class LeetCode416_Solution {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //奇数不符合要求
        if (sum % 2 != 0) {
            return false;
        }
        int capacity = sum >> 1;
        boolean[][] memo = new boolean[n][capacity + 1];
        for (int i = 1; i <= capacity; i++) {
            if (nums[0] == i) {
                memo[0][i] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (nums[i] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i-1][j] || memo[i-1][j-nums[i]];
                }
            }
        }
        return memo[n - 1][capacity];
    }

    private boolean tryPartition(int[] nums, int index, int capacity) {
        if (capacity == 0) {
            return true;
        }
        if (index < 0 || capacity < 0) {
            return false;
        }
        return tryPartition(nums, index - 1, capacity) || tryPartition(nums, index - 1, capacity - nums[index]);

    }

    public static void main(String[] args) {
        LeetCode416_Solution solution = new LeetCode416_Solution();
        boolean b = solution.canPartition(new int[]{1, 5, 5, 11});
        System.out.println(b);
    }

}
