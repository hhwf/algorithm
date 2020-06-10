package com.hhwf.offer;

/**
 *
 *@description:青蛙跳台阶问题
 *@author: hhwf
 *@time: 2020/6/9 15:12
 *
 */
public class Offer_10_2 {

    public int numWays(int n) {
        if (n == 0 || n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1 , sum = 0;
        for (int i = 2; i < n; i++){
            sum = a+b;
            a = b ;
            b = sum;
        }
        return sum;
    }

}
