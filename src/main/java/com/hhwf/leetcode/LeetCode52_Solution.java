package com.hhwf.leetcode;

/**
 *
 *@description:  N 皇后2
 *@author: hhwf
 *@time: 2020/7/23 17:15
 *
 */
public class LeetCode52_Solution {

    boolean[] column;
    boolean[] dia1;
    boolean[] dia2;
    int sum = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return sum;
        }
        column = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        dfs(n, 0);
        return sum;
    }

    public void dfs(int n, int index) {
        if (index == n) {
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!column[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                column[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                dfs(n, index + 1);
                column[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }

}
