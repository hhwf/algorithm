package com.hhwf.offer;

/**
 *
 *@description:  斐波那契数列
 *@author: hhwf
 *@time: 2020/6/9 13:41
 *
 */
public class Offer_10_1 {

    public int fib(int n) {
        int a = 0;
        int b = 1 , sum = a + b;
        for (int i = 1; i < n; i++){
            sum = a+b;
            a = b ;
            b = sum;
        }
        return sum;
    }

}
