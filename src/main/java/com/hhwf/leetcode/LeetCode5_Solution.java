package com.hhwf.leetcode;

/**
 * @Author: fei.wei
 * @Date: 2020/2/24 17:51
 * @Description: 最长回文子串-》给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LeetCode5_Solution {


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
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

        for (int i = 0; i < str.length(); i++) {
            //是否需要中心扩散
            boolean calc = true;

            //判断i是否大于rightSide
            if (rightSide > i) {

                //计算i和对应的左边值
                int leftCenter = 2 * rightSideCenter - i;

                halfLenArr[i] = halfLenArr[leftCenter];

                if (i + halfLenArr[i] > rightSide) {
                    halfLenArr[i] = rightSide - i;
                }
                if (i + halfLenArr[leftCenter] < rightSide) {
                    calc = false;
                }
            }

            //是否需要中心扩散
            if (calc) {
                while (i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if (str.charAt(i - 1 - halfLenArr[i]) == str.charAt(i + 1 + halfLenArr[i])) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                if (halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }

        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 处理原字符串
     *
     * @return
     */
    private static String preHandleString(String s) {
        StringBuffer buffer = new StringBuffer("#");
        for (int i = 0; i < s.length(); i++) {
            buffer.append(s.charAt(i));
            buffer.append("#");
        }
        return buffer.toString();

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

}
