package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/24 21:57
 *
 */
public class LeetCode64_Solution {


    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    memo[i][j] = memo[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + grid[i][j];
                    continue;
                }
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }

        return memo[m - 1][n - 1];
    }


}
