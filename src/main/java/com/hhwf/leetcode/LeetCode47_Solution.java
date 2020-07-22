package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/19 20:39
 *
 */
public class LeetCode47_Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        dfs(nums, 0, used, temp);
        return res;
    }

    private void dfs(int[] nums, int index, boolean[] used, List<Integer> temp) {
        if (index == nums.length) {
            //temp 是值传递 ， 但是此处temp会又变化
            List<Integer> newtemp = new ArrayList<Integer>(temp);
            if (res.contains(newtemp)){
                return;
            }
            res.add(newtemp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, index + 1, used, temp);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode46_Solution  solution = new LeetCode46_Solution();
        int[] nums = new int[]{1,3,1};
        System.out.println(solution.permute(nums));
    }

}
