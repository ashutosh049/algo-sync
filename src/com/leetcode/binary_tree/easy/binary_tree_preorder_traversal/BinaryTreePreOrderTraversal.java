package com.leetcode.binary_tree.easy.binary_tree_preorder_traversal;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p><pre>
 *
 * </pre> <p>
 * Example 1
 *
 * <pre>
 *
 *
 * </pre> <p>
 *
 * @see <a href="> </a>
 */
@SuppressWarnings("Duplicates")
public class BinaryTreePreOrderTraversal {

  static List<String> preOrder;

  public static void main(String[] args) {
    TreeNode root = buildFromNodes(new Integer[]{1, 1});
    TreeNode subRoot = buildFromNodes(new Integer[]{1, null, 1});

    System.out.println("---------- pre-order classic -----------");
    preOrder = new ArrayList<>();
    preOrder(root);
    System.out.println("Preorder root: " + preOrder);

    preOrder = new ArrayList<>();
    preOrder(subRoot);
    System.out.println("Preorder sub-root: " + preOrder);

    System.out.println("---------- pre-order unique -----------");
    System.out.println("root: " + preOrderUnique(root, ""));
    System.out.println("sub-root: " + preOrderUnique(subRoot, ""));
  }

  // your logic/solution goes here

  /**
   * Recursive pre-order classic ways
   *
   * @param root
   */
  private static void preOrder(TreeNode root) {
    if (root != null) {
      preOrder.add(String.valueOf(root.val));
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  /**
   * Recursive pre-order unique order generation
   * <p>
   * <p>
   * This type of unique order generation is useful for comparing or matching the traversal order of
   * 2 different trees/sub-tree like in problem "SubTree Of Another Tree"
   *
   * @param root
   * @param orderString
   * @return
   */
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