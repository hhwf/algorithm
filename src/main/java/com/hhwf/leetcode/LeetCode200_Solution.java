package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/21 21:13
 *
 */
public class LeetCode200_Solution {

    int num = 0;
    boolean[][] visited;
    int m, n;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;

        //向右
        if (i < m - 1 && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        //向下
        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        //向左
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        //向上
        if (j < n - 1 && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode200_Solution solution = new LeetCode200_Solution();
        char[][] board = {{'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}};
        int i = solution.numIslands(board);
        System.out.println(i);
    }

}
