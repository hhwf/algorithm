package com.hhwf.leetcode;

/**
 * @description:
 * @author: hhwf
 * @time: 2020/3/1 17:16
 */
public class LeetCode215_Solution {

    /**
     * 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

    }


    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (start < end) {
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }


        return
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
