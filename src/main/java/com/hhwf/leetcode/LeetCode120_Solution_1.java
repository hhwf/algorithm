package com.hhwf.leetcode;

import java.util.List;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/26 11:17
 *12
 */
public class LeetCode120_Solution_1 {

    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        memo = new int[triangle.size()][triangle.size()];
        int n = triangle.size();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                memo[i][j] = triangle.get(i).get(j) + Math.min(memo[i][j],memo[i][j+1]);
            }
        }
        return memo[0][0];
    }


}
