package com.leetcode.binary_tree.easy.path_sum;

import com.util.TreeNode;
import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * @see <a href="https://leetcode.com/problems/path-sum/">112 Path Sum</a>
 */
public class PathSum {

  public static void main(String[] args) {

    // Test cases
    /*[]
    0
    []
    1
    [1]
    1
    [1,2,3]
    3
    [1,2,3]
    4
    [1,2,3]
    5
    [1,null, 1]
    2
    [1,null, 1]
    1
    [1,null, 1]
    2
    [1,2,3,1,3,2,null,1]
    5
    [1,2,3,1,3,2,null,1]
    6
    [3,9,20,null,null,15,7]
    12
    [3,9,20,null,null,15,7]
    38
    [1,-2,-3,1,3,-2,null,-1]
    -1
    [1,-2,-3,1,3,-2,null,-1]
    2
    [-1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, -1,null, 16]
    0
    [1,-2,-3,1,3,-2,null,-1]
    -4
    [1,-2,-3,1,3,-2,null,-1]
    -1
    [1,-2,-3,1,3,-2,null,-1]
    2*/
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {

    if (root == null) {
      return false;
    }

    //return hasPathSum_iterative(root, targetSum);
    return hasPathSum_iterative(root, targetSum);
  }

  /**
   * Recursive
   * <p>
   * <h3>Complexity Analysis</h3>
   *
   *
   * <h4>Time complexity</h4>
   * we visit each node exactly once, thus the time complexity is <em>O(N)</em>, where N is the
   * number of nodes.
   * <div></div>
   * <h4>Space complexity</h4>
   * <p>
   * In the worst case, the tree is completely unbalanced, e.g. each node has only one child node,
   * the recursion call would occur N times (the height of the tree), therefore the storage to keep
   * the call stack would be <em>O(N)</em>. But in the best case (the tree is completely balanced),
   * the height of the tree would be <em>log(N)</em>. Therefore, the space complexity in this case
   * would be <em>O(log(N))</em>.
   */
  private boolean hasPathSum_recursive(TreeNode root, int cs, int ts) {
    if (root == null) {
      return cs == ts;
    }

    return hasPathSum_recursive(root.left, cs + root.val, ts) ||
        hasPathSum_recursive(root.right, cs + root.val, ts);
  }

  /**
   * Iterative path sum. Intuition: Proceed in a classic post-order iterative fashion, with 2 things
   * in mind:
   * <p>
   * 1. Keep a currSum variable which will have the total sum up to curr node
   * <p>
   * 2. On each pop-operation/climb-up (processing of a node), and since we know that we have
   * already checked if this node  was a leaf node and if the sum till this node is equal to target,
   * we reduce it's value from `currSum` which we added while traversing downwards.
   * <p>
   * Time: O(n)
   * <p>
   * Space: O(n)
   */
  private boolean hasPathSum_iterative(TreeNode root, int targetSum) {

    boolean hasPath = false;

    if (root == null) {
      return hasPath;
    }

    TreeNode curr = root;
    TreeNode pre = null;
    int currSum = 0;
    Stack<TreeNode> s = new Stack();

    while (curr != null || !s.isEmpty()) {

      while (curr != null) {
        currSum += curr.val;
        s.push(curr);
        curr = curr.left;
      }

      curr = s.peek();

      if (curr.left == null && curr.right == null && currSum == targetSum) {
        hasPath = true;
        break;
      }

      // If right ST is null or already processed(equal to pre)
      // then process curr
      if (curr.right == null || curr.right == pre) {
        curr = s.pop();
        currSum -= curr.val;
        pre = curr;
        curr = null;
      } else {
        curr = curr.right;
      }


    }

    return hasPath;
  }

}
