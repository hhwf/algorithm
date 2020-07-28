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

        for (int i = n - 1; i >= 0; i--) {

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        LeetCode198_Solution solution = new LeetCode198_Solution();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }

}
