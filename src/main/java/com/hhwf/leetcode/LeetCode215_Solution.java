package com.hhwf.leetcode;

import java.util.Arrays;

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
    public static int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return 0;
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            sort(arr, start, index - 1);
            sort(arr, index + 1, end);
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            while (left < right && arr[right] >= pivot) {
                right--;
            }
                swap(arr, left, right);

        }
        swap(arr, left, start);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 9, 3, 4, 2, 1, 2};
        findKthLargest(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

}
