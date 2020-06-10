package com.hhwf.offer;

/**
 *
 *@description: 二维数组中的查找 target
 *@author: hhwf
 *@time: 2020/6/9 10:51
 *
 */
public class Offer_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0, j = columns - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;

    }

}
