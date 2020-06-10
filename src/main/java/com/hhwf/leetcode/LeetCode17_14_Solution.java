package com.hhwf.leetcode;

import java.util.Arrays;

/**
 *
 *@description: 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。https://leetcode-cn.com/problems/smallest-k-lcci/
 *@author: hhwf
 *@time: 2020/5/12 16:48
 *
 */
public class LeetCode17_14_Solution {

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right){
                swap(arr, left, right);
            }
        }
        swap(arr, start, left);
        return left;
    }

    public static void QSort(int[] a, int left, int right) {
        if(left >= right) {
            return;
        }
        //选择最左边元素为基线值
        int base = a[left];
        int i = left;
        int j = right;
        //移动元素使得基线值
        while(i < j) {
            //左移放前面
            while(i < j && base <= a[j]) {
                j--;
            }
            //右移
            while(i < j && base >= a[i]) {
                i++;
            }
            if(i < j) {
                swap(a, i, j);
            }
        }
        //交换base和比base小的最后一个元素的值
        swap(a, left, i);
        QSort(a, left, i-1);//左边递归
        QSort(a, i+1, right);
    }


    private static void quickSort(int[] arr, int low, int high) {//???递归何时结束
        if(low < high){
            //分区操作，将一个数组分成两个分区，返回分区界限索引
            int index = partition(arr,low,high);
            //对左分区进行快排
            quickSort(arr,low,index-1);
            //对右分区进行快排
            quickSort(arr,index+1,high);
        }

    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //给出无序数组
        int arr[] = {72,6,57,88,60,42,83,73,48,85};

        //输出无序数组
        System.out.println(Arrays.toString(arr));
        //快速排序
        quickSort(arr);
        //partition(arr,0,arr.length-1);
        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }

}
