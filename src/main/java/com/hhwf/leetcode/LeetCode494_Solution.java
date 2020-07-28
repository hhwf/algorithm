package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/28 15:35
 *
 */
public class LeetCode494_Solution {

    int res = 0;
    int[][] memo;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length][2];
        dsf(nums, 0, S, 0);
        return res;
    }

    private void dsf(int[] nums, int index, int S, int sum) {
        if (S == sum && index == nums.length) {
            res++;
            return;
        }
        if (index >= nums.length){
            return;
        }
        sum -= nums[index];
        dsf(nums, index + 1, S, sum);
        sum += nums[index];
        sum += nums[index];
        dsf(nums, index + 1, S, sum);
        sum -= nums[index];

    }

    private void dsf2(int[] nums,int s){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                memo[i][0] = s + memo[j][0];
                memo[i][1] = s - memo[j][1];
            }
        }
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 1, 1, 1, 1};
        LeetCode494_Solution solution = new LeetCode494_Solution();
        int targetSumWays = solution.findTargetSumWays(S, 3);
        System.out.println(targetSumWays);
    }

}
