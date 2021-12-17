package com.leetcode.binary_tree.easy.minimum_depth;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.Stack;

/**
 * Problem Statement:
 * <pre>
 *  Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 * </pre>
 * <p>
 * Example
 *
 * <pre>
 *  Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * </pre>
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/"> 111. Minimum Depth of
 * Binary Tree</a>
 */
public class MinimumDepthOfBinaryTree {

  public static void main(String[] args) {
    TreeNode testCase_1 = buildFromNodes(
        new Integer[]{1, 2, 8, 6, 3, null, 9, 7, null, null, 4, 10, 11, null, null, 5,
            null, null, null, 12, null, null, null, null, 13});

    System.out.println("Iterative DFS(Post-Order): " + minDepthIterativeDFSPostOrder(testCase_1));

    TreeNode testCase_2 = buildFromNodes(
        new Integer[]{3, 9, 20, null, null, 15, 7});

    System.out.println("Iterative DFS(Post-Order): " + minDepthIterativeDFSPostOrder(testCase_2));

    TreeNode testCase_3 = buildFromNodes(
        new Integer[]{2, null, 3, null, 4, null, 5, null, 6});

    System.out.println("Iterative DFS(Post-Order): " + minDepthIterativeDFSPostOrder(testCase_3));


  }

  /**
   * Min depth using iterative DFS(post-order)
   */
  private static int minDepthIterativeDFSPostOrder(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int minDepth = Integer.MAX_VALUE;
    TreeNode curr = root;
    TreeNode pre = null;
    Stack<TreeNode> s = new Stack();
    int currDepth = 0;

    while (curr != null || !s.isEmpty()) {
      if (curr != null) {
        currDepth += 1; // add node depth
        s.push(curr);
        curr = curr.left;
      } else {

        curr = s.peek();

        if (curr.left == null && curr.right == null) {
          minDepth = Math.min(minDepth, currDepth);
        }

        if (curr.right == null || curr.right == pre) {
          curr = s.pop();
          currDepth -= 1; // revert node depth addition
          pre = curr;
          curr = null;
        } else {
          curr = curr.right;
        }

      }
    }
    return minDepth == Integer.MIN_VALUE ? 0 : minDepth;
  }

}
