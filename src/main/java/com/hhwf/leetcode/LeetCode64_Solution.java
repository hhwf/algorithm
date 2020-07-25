package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/24 21:57
 *
 */
public class LeetCode64_Solution {

    int[][] memo ;
    int m ;
    int n;
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        return dsf(grid,0,0);
    }

    public int dsf(int[][] grid,int i ,int j){
        if ( i == m || j == n){
            return Integer.MAX_VALUE;
        }
        return grid[i][j] + Math.min(dsf(grid,i+1,j),dsf(grid,i,j+1));
    }





}
