package com.hhwf.leetcode;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode145_Solution {


    /**
     * 二叉树后序遍历（左右中）  非递归
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null){
            stack.push(root);
        }
        TreeNode curr = root.left;
        while (curr != null || !stack.empty()) {
            if (curr != null){
                if (curr.right!=null){
                    stack.push(curr.right);
                }
                res.add(curr.val);
                curr = curr.left;
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                curr = pop.left;
            }
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
