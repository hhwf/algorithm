package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *@description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *@author: hhwf
 *@time: 2020/7/20 11:12
 *
 */
public class LeetCode40_Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new LinkedList<Integer>());
        return res;
    }


    public void dfs(int[] nums, int sum, int start, int p, LinkedList<Integer> temp) {
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
            dfs(nums, sum,i+1, p, temp);
            temp.removeLast();
            p -= nums[i];
        }
    }


    public static void main(String[] args) {
        LeetCode40_Solution solution = new LeetCode40_Solution();
        int[] nums = new int[]{2,5,2,1,2};
        System.out.println(solution.combinationSum2(nums, 5));
    }

}
