package com.hhwf.leetcode;

import java.util.Arrays;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/27 21:22
 *
 */
public class LeetCode198_Solution {


    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int dp[] = new int[n];
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i == n - 2) {
                dp[i] = Math.max(nums[n - 2], nums[n - 1]);
            } else {
                dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1,2};
        LeetCode198_Solution solution = new LeetCode198_Solution();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

}
