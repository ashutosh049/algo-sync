package com.leetcode.binary_tree.easy.maximum_depth;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

  public static void main(String[] args) {

    Integer[] nodes = new Integer[]{1, 2, 8, 6, 3, null, 9, 7, null, null, 4, 10, 11, null, null, 5,
        null, null, null, 12, null, null, null, null, 13};

    TreeNode root = buildFromNodes(nodes);

    System.out.println("Recursive(Bottom-Up): " + maxDepthRecursiveBottomUp(root));
    System.out.println("Iterative BFS: " + maxDepthIterativeBFS(root));
    System.out.println("Iterative BFS (Enhanced): " + maxDepthIterativeBFSEnhanced(root));
    System.out.println("Iterative DFS(Post-Order): " + maxDepthIterativeDFSPostOrder(root));


  }

  /**
   * Recursive bottom-up
   *
   * @param root
   * @return
   */
  private static int maxDepthRecursiveBottomUp(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepthRecursiveBottomUp(root.left), maxDepthRecursiveBottomUp(root.right))
        + 1;
  }


  /**
   * We can use BFS to get the highest level(deepest node) Implement BFS, return the size of the
   * List of level nodes
   *
   * @param root
   * @return
   */
  private static int maxDepthIterativeBFS(TreeNode root) {

    List<List<Integer>> resultList = new ArrayList<>();

    if (root == null) {
      return 0;
    }

    TreeNode curr = root;

    Queue<TreeNode> q = new LinkedList<>();

    q.offer(curr);

    while (!q.isEmpty()) {
      int qSize = q.size();
      List<Integer> subList = new ArrayList<>();

      for (int i = 0; i < qSize; i++) {
        curr = q.poll();

        subList.add(curr.val);

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }
      }
      //add to main list
      resultList.add(subList);

    }

    return resultList.size();

  }

  /**
   * Iterative BFS
   *
   * @param root
   * @return
   */
  private static int maxDepthIterativeBFSEnhanced(TreeNode root) {

    if (root == null) {
      return 0;
    }

    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);
    int maxDepth = 0;

    while (!q.isEmpty()) {

      maxDepth++;
      int i = q.size();
      while (i-- > 0) {

        TreeNode curr = q.poll();

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }
      }

    }

    return maxDepth;

  }

  /**
   * Max depth using iterative DFS(post-order)
   */
  private static int maxDepthIterativeDFSPostOrder(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int maxDepth = Integer.MIN_VALUE;
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
          maxDepth = Math.max(maxDepth, currDepth);
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
    return maxDepth == Integer.MIN_VALUE ? 0 : maxDepth;
  }

}
