package com.leetcode.binary_tree.easy.sub_tree_of_another_tree;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p><pre>
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * </pre> <p>
 * Example 1
 *
 * <pre>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * </pre> <p>
 *
 * @see <a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another
 * Tree </a>
 */
public class SubtreeOfAnotherTree {


  public static void main(String[] args) {

    TreeNode root = buildFromNodes(new Integer[]{1, 1});
    TreeNode subRoot = buildFromNodes(new Integer[]{1, 1});
    System.out.println("is sub-tree: " + isSubTreeUsingNestedLoop(root, subRoot));

    root = buildFromNodes(new Integer[]{3, 4, 5, 1, 2});
    subRoot = buildFromNodes(new Integer[]{4, 1, 2});
    System.out.println("is sub-tree: " + isSubTreeUsingNestedLoop(root, subRoot));

    root = buildFromNodes(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
    subRoot = buildFromNodes(new Integer[]{4, 1, 2});
    System.out.println("is sub-tree: " + isSubTreeUsingNestedLoop(root, subRoot));


  }

  /**
   * Nested loop : (iterative)
   * <p>
   * 1. Start iterating each node of T1
   *    a. For each node of T1, do
   *      a.1 Check if this tree(of T1) is symmetric to subRoot
   *      a.2 If not, return
   *    b. If root tree is not symmetric at this node, traverse to child nodes of root tree
   */
  private static boolean isSubTreeUsingNestedLoop(TreeNode t1, TreeNode t2) {

    boolean isSubTree = false;

    if (t1 == null && t2 == null) {
      return true;
    } else if (t1 == null || t2 == null) {
      return false;
    } else {

      TreeNode curr = t1;

      Stack<TreeNode> s = new Stack();

      while (curr != null || !s.isEmpty()) {

        if (curr != null) {
          s.push(curr);
          curr = curr.left;
        } else {
          curr = s.pop();
          if (ifSame(curr, t2) && isSameTree(curr, t2)) {
            isSubTree = true;
            break;
          }
          curr = curr.right;
        }
      }

    }

    return isSubTree;
  }

  //is same tree(iterative)
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
      // To avoid NPE before fetching child
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


  private static boolean isSubTreeUsingDFSStringMatching(TreeNode root, TreeNode subRoot) {
    boolean isSubTree = false;
    if (root == null && subRoot == null) {
      isSubTree = true;
    } else if (root == null || subRoot == null) {
      isSubTree = true;
    } else {
      String tree1 = preOrderUnique(root, "");
      String tree2 = preOrderUnique(subRoot, "");
      isSubTree = tree1.indexOf(tree2) >= 0;
    }

    return isSubTree;

  }

  private static String preOrderUnique(TreeNode root, String orderString) {
    if (root == null) {
      return orderString;
    }
    orderString = "#" + root.val;

    return orderString
        + preOrderUnique(root.left, root.left == null ? "lNull" : "")
        + preOrderUnique(root.right, root.right == null ? "rNull" : "");
  }
}