package com.hhwf.leetcode;

/**
 * @description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 字母异位词 : 由相同的字母按照不同的顺序组成的单词
 * @author: hhwf
 * @time: 2020/4/22 16:14
 */
public class LeetCode242_Solution {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a']++;
            array[chart[i] - 'a']--;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0){
                return false;
            }
        }
        return true;
    }

}
