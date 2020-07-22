package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/19 21:40
 *
 */
public class LeetCode39_Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] nums, int sum) {
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, sum,0, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, int sum,int start,int p,List<Integer> temp) {
        if (sum == p) {
            List<Integer> newtemp = new ArrayList<Integer>(temp);
            if (res.contains(newtemp)) {
                return;
            }
            res.add(newtemp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (p + nums[i] > sum){
                break;
            }
            temp.add(nums[i]);
            p += nums[i];
            dfs(nums, sum,i, p, temp);
            temp.remove(temp.size() - 1);
            p -= nums[i];
        }
    }

    public static void main(String[] args) {
        LeetCode39_Solution solution = new LeetCode39_Solution();
        int[] nums = new int[]{8, 7, 4, 3};
        System.out.println(solution.combinationSum(nums, 11));
    }

}

