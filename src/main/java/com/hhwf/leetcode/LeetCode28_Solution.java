package com.hhwf.leetcode;

/**
 * @description: KMP 算法
 * @author: hhwf
 * @time: 2020/2/26 18:29
 */
public class LeetCode28_Solution {

    /**
     * 字符串匹配
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (haystack.length() == 0 || needle.length() == 0)
            return 0;
        int[] next = getNextArray(needle);
        int hayLen = haystack.length();
        int needLen = needle.length();
        int i = 0, j = 0;
        while (i < hayLen && j < needLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }

        return j == needLen ? i - j : -1;
    }


    private static int[] getNextArray(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        if (len == 1) {
            return next;
        }
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < len) {
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
            } else {
                if (cn > 0) {
                    cn = next[cn];
                } else {
                    next[i++] = 0;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aabaaabaaac", "aabaaac"));
    }

}
