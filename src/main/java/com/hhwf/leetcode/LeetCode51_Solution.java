package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *@description: N 皇后
 *@author: hhwf
 *@time: 2020/7/22 21:20
 *
 */
public class LeetCode51_Solution {

    List<List<String>> res = new ArrayList<List<String>>();

    boolean[] colu;  //列
    boolean[] obli1; //斜1
    boolean[] obli2; //斜2


    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        colu = new boolean[n];
        obli1 = new boolean[2 * n - 1];
        obli2 = new boolean[2 * n - 1];
        List<String> row = new ArrayList<String>();
        dfs(n, 0, row);
        return res;
    }

    // index 代表当前访问的行数,最多到 n; row 用来存放满足题意的一种情况
    public void dfs(int n, int index, List<String> row) {
        if (n == index) {
            res.add(changeBoard(n,row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!colu[i] && !obli1[index + i] && !obli2[index - i + n - 1]) {
                colu[i] = true;
                obli1[index + i] = true;
                obli2[index - i + n - 1] = true;
                row.add(i + "");
                dfs(n, index + 1, row);
                colu[i] = false;
                obli1[index + i] = false;
                obli2[index - i + n - 1] = false;
                row.remove(row.size() -1);
            }
        }
    }

    // 将找到的一组解转化为棋盘格形式存储
    private List<String> changeBoard(int n, List<String> row) {
        List<String> tmp = new ArrayList();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            // 初始化 ch 中所有位置元素为 ‘.’
            Arrays.fill(ch, '.');
            // 将 row 中已经确定下来的 Queen 位置改为 ‘Q’
            ch[Integer.parseInt(row.get(i))] = 'Q';
            // 然后放入 tmp 中
            tmp.add(new String(ch));
        }
        return tmp;
    }

    public static void main(String[] args) {
        LeetCode51_Solution solution = new LeetCode51_Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

}
