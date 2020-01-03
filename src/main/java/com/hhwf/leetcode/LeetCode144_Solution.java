package com.hhwf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 *
 * @Date: 2019/12/30 16:39
 * @Description:
 */
public class LeetCode144_Solution {


    /**
     * 二叉树 前序遍历 -->中左右（递归方式）
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal_recursion(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        list.add(root.val);
        list.addAll(preOrderTraversal_recursion(root.left));
        list.addAll(preOrderTraversal_recursion(root.right));
        return list;
    }

    /**
     * 前序遍历，非递归
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            res.add(pop.val);
        }

        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
