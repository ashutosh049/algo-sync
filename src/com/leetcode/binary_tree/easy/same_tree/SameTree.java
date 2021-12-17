package com.leetcode.binary_tree.easy.same_tree;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement:
 * <pre>
 *  Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 * </pre>
 * <p>
 * Example
 *
 * <pre>
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * </pre>
 *
 * @see <a href="https://leetcode.com/problems/same-tree/"> 100. Same Tree</a>
 */
public class SameTree {


  public static void main(String[] args) {

    TreeNode p1 = buildFromNodes(new Integer[]{1, 2, 3});
    TreeNode q1 = buildFromNodes(new Integer[]{1, 2, 3});
    System.out.println("is same(p1, q1): " + isSameTree(p1, q1));

    TreeNode p2 = buildFromNodes(new Integer[]{1, 1});
    TreeNode q2 = buildFromNodes(new Integer[]{1, null, 1});
    System.out.println("is same(p2, q2): " + isSameTree(p2, q2));
  }

  // your logic/solution goes here

  public static boolean isSameTree(TreeNode t1, TreeNode t2) {

    boolean isSame = false;

    if (!ifSame(t1, t2)) {
      return isSame;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(t1);
    q.offer(t2);

    while (!q.isEmpty()) {

      TreeNode t1Child = q.poll();
      TreeNode t2Child = q.poll();

      if (!ifSame(t1Child, t2Child)) {
        return false;
      }

      // Remember, if both t1child and t2child are null, they are same.
      // To avoid NPe before fetching child
      if (t1Child != null && t2Child != null) {
        q.offer(t1Child.left);
        q.offer(t2Child.left);

        q.offer(t1Child.right);
        q.offer(t2Child.right);
      }

    }

    return true;

  }

  private static boolean ifSame(TreeNode t1, TreeNode t2) {
    return (t1 == null && t2 == null) ||
        (t1 != null && t2 != null && t1.val == t2.val);

  }
}