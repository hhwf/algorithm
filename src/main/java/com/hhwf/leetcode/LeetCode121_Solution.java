package com.hhwf.leetcode;

/**
 *
 *@description: 买卖股票的最佳时机
 *@author: hhwf
 *@time: 2020/6/9 17:21
 *
 */
public class LeetCode121_Solution {


    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > max) {
                max = prices[i] - buy;
            }
        }
        return max;

    }

}
