package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/28 17:59
 *
 */
public class LeetCode91_Solution {

    public int numDecodings(String s) {
        if (s == null || s.equals("")||s.equals("0")) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2'){  // case 2:
                    return 0;
                }else{ // case 1:
                    if(i > 1){
                        dp[i] = dp[i - 2];
                    }else{
                        dp[i] = 1;
                    }
                }
            }else if((s.charAt(i) <= '6' && s.charAt(i) >= '1' && s.charAt(i - 1) == '2') || s.charAt(i - 1) == '1'){ // case 3:
                if(i > 1){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else{
                    dp[i] = dp[i - 1] + 1;
                }
            }else{
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        LeetCode91_Solution solution = new LeetCode91_Solution();
        System.out.println(solution.numDecodings("12340"));
    }


}
