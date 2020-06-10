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
