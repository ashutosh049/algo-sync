package com.leetcode.binary_tree.problem_145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">145. Binary Tree
 * Postorder Traversal</a>
 *
 * <p>Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * <pre>
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * </pre>
 */
public class PostOrderTravelsal_Iterative {

  public static void main(String[] args) {
    /*TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode root = new TreeNode(1, left, right);
    left.left = new TreeNode(4);
    left.right = new TreeNode(5);
    right.left = new TreeNode(6);
    right.right = new TreeNode(7);*/

    int[] values = new int[] {1,2,3,4,5,6,7,8,9};

    TreeNode root = TreeNode.constructTree(values, values.length);

    root.printInorder(root);

    // List<Integer> result = new ArrayList<Integer>();
    // System.out.println("Postorder Traversal : " + postorderTraversal(root));
  }

  public static List<Integer> postorderTraversal(TreeNode root) {

    List<Integer> result = new ArrayList<>();

    TreeNode cn = root;
    TreeNode pn = null;

    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();

    while (true) {

      while (cn != null) {
        stack.push(cn);
        cn = cn.left;
      }

      if (stack.isEmpty()) {
        break;
      }

      while (cn == null && !stack.isEmpty()) {

        cn = stack.peek();

        if (cn.right == null || cn.right == pn) {
          result.add(cn.val);
          stack.pop();
          pn = cn;
          cn = null;
        } else {
          cn = cn.right;
        }
      }
    }

    return result;
  }
}
