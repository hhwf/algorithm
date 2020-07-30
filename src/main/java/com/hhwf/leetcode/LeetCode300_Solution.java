package com.hhwf.leetcode;

import java.util.Arrays;

/**
 *
 *@description: 最长上升子序列
 *@author: hhwf
 *@time: 2020/7/30 20:49
 *
 */
public class LeetCode300_Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(memo[i], res);
        }
        return res;
    }




}
