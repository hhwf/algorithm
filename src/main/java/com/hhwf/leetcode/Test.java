package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/10 19:19
 *
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 1; i < 99; i++) {
            System.out.println(f(i) == f1(i));
        }
    }

    public static int f1(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (n == 4) {
            return 7;
        }
        return 2*f1(n-1) - f1(n-4);
    }

    public static int f(int n){
        return aCell(n) + bCell(n) + cCell(n);
    }


    /**
     * 第 n 小时 a 状态的细胞数
     */
    public static int aCell(int n) {
        if(n==1){
            return 1;
        }else{
            return aCell(n-1)+bCell(n-1)+cCell(n-1);
        }
    }

    /**
     * 第 n 小时 b 状态的细胞数
     */
    public static int bCell(int n) {
        if(n==1){
            return 0;
        }else{
            return aCell(n-1);
        }
    }

    /**
     * 第 n 小时 c 状态的细胞数
     */
    public static int cCell(int n) {
        if(n==1 || n==2){
            return 0;
        }else{
            return bCell(n-1);
        }
    }

}
