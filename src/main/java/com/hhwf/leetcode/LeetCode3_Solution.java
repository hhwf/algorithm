package com.hhwf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode3_Solution {


    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        /**
         * res 返回值
         * 利用set类型存放连续不重复数据 ，k表示不重复数据开始地方 ，特别注意当set中包含时 i不变
         */
        if (s.length() == 0) return 0;
        int res = 0;
        Set<Character> set = new HashSet<Character>();
        int k = 0;
        for (int i = 0; i < s.length(); ) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(k++));
            } else {
                set.add(s.charAt(i++));
                res = Math.max(res,set.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("qrsvbspk"));
    }

}

