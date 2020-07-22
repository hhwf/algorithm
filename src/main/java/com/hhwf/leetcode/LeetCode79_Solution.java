package com.hhwf.leetcode;

/**
 *
 *@description:
 *@author: hhwf
 *@time: 2020/7/21 10:50
 *
 */
public class LeetCode79_Solution {

    boolean res = false;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return res;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !visit[i][j]) {
                    dfs(board, word, i, j, 1, visit);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board, String word, int startx, int starty, int index, boolean[][] visits) {
        if (index == word.length()) {
            res = true;
            return;
        }

        visits[startx][starty] = true;
        if (!res && startx < board.length - 1 && board[startx + 1][starty] == word.charAt(index) && !visits[startx + 1][starty]) {
            dfs(board, word, startx + 1, starty, index + 1, visits);
        }
        if (!res && startx - 1 >= 0 && board[startx - 1][starty] == word.charAt(index) && !visits[startx - 1][starty]) {
            dfs(board, word, startx - 1, starty, index + 1, visits);
        }
        if (!res && starty < board[0].length - 1 && board[startx][starty + 1] == word.charAt(index) && !visits[startx][starty + 1]) {
            dfs(board, word, startx, starty + 1, index + 1, visits);
        }
        if (!res && starty - 1 >= 0 && board[startx][starty - 1] == word.charAt(index) && !visits[startx][starty - 1]) {
            dfs(board, word, startx, starty - 1, index + 1, visits);
        }
        visits[startx][starty] = false;
    }

    public static void main(String[] args) {
        LeetCode79_Solution solution = new LeetCode79_Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean abcced = solution.exist(board, "BA");
        System.out.println(abcced);
    }

}
