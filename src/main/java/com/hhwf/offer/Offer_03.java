package com.hhwf.offer;

/**
 *
 *@description: 数组中重复的数字
 *@author: hhwf
 *@time: 2020/6/9 10:17
 *
 */
public class Offer_03 {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

}
