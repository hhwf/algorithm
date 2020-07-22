package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/19 20:47
 *
 */
public class LeetCode77_Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (k > 0 && n > 0 && n > k) {
            List<Integer> temp = new ArrayList<Integer>();
            dfs(n, k, 1, temp);
        }
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = index; i <= n ; i++) {
            temp.add(i);
            dfs(n, k, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode77_Solution solution = new LeetCode77_Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }

}
