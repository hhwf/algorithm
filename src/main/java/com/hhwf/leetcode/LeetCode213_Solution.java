package com.hhwf.leetcode;

/**
 *
 *@description: 打家劫舍Ⅱ（环形）
 *@author: hhwf
 *@time: 2020/7/29 16:32
 *
 */
public class LeetCode213_Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //第i个房子偷、不偷的最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1){
                i = 0;
                dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1]);
            }


            dp[i][1] = Math.max(Math.max(dp[i + 1][0], dp[i + 1][1]), nums[i] + Math.max(dp[i + 2][0], dp[i + 2][1]));
        }
        return Math.max(dp[0][0], dp[0][1]);
    }



}
