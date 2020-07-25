package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@description:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *@author: hhwf
 *@time: 2020/7/24 10:25
 *
 */
public class LeetCode120_Solution {

    int[] memo ;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0){
            return 0;
        }
        memo = new int[triangle.size()];
        return triangledfs(triangle, 0, 0);
    }

    public int triangledfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()){
            return 0;
        }
        if (memo[i]!=0){
            return memo[i];
        }
        memo[i] = Math.min(triangle.get(i).get(j) + triangledfs(triangle,i+1,j),triangle.get(i).get(j) + triangledfs(triangle,i+1,j+1));
        return memo[i];
    }

    public static void main(String[] args) {
        LeetCode120_Solution solution = new LeetCode120_Solution();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(2);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        System.out.println(solution.minimumTotal(triangle));
    }

}
