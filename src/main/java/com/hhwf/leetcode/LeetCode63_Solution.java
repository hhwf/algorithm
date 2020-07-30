package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/28 18:39
 *
 */
public class LeetCode63_Solution {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                    if (i == 0 && j >= 1) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    if (i >= 1 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        return dp[m - 1][n - 1];
    }


}
