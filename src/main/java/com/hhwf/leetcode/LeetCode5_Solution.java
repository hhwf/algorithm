package com.hhwf.leetcode;

/**
 * @Author: fei.wei
 * @Date: 2020/2/24 17:51
 * @Description: 最长回文子串-》给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LeetCode5_Solution {


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        String result = "";
        String str = preHandleString(s);
        // 处理后的字串长度
        int len = str.length();
        // 右边界
        int rightSide = 0;
        // 右边界对应的回文串中心
        int rightSideCenter = 0;
        // 保存以每个字符为中心的回文长度一半（向下取整）
        int[] halfLenArr = new int[len];
        // 记录回文中心
        int center = 0;
        // 记录最长回文长度
        int longestHalf = 0;




        return result;
    }

    /**
     * 处理原字符串
     *
     * @return
     */
    private String preHandleString(String s) {
        StringBuffer buffer = new StringBuffer("#");
        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
            buffer.append("#");
        }
        return buffer.toString();

    }

}
