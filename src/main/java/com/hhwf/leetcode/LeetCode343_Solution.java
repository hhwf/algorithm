package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/23 21:40
 *
 */
public class LeetCode343_Solution {

    int[] array;

    public int integerBreak(int n) {
        return breakN(n);
    }

    public int breakN(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i <= n -1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakN(n - i)));
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode343_Solution solution = new LeetCode343_Solution();
        int i = solution.integerBreak(5);
        System.out.println(i);
    }
}
