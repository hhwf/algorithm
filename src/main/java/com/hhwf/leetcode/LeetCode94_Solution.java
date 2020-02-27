package com.hhwf.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode94_Solution {

    /**
     * 二叉树 中序遍历 -->左中右（非递归方式）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }

    /**
     * 二叉树 中序遍历 -->左中右（递归方式）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_recursion(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
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
