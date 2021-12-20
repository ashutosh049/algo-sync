package com.leetcode.binary_tree.medium.count_univalue_subtrees;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;


class CountUnivalueSubtrees {

  static int uniCount; // class level variable to keep the count of uni-valued tree/sub-tree

  public static void main(String[] args) {
    Integer[] nodes = new Integer[]{};
    TreeNode root = buildFromNodes(nodes);
  }

  public static int countUnivalSubtreesRecursiveUsingGlobalVariable(TreeNode root) {
    uniCount = 0;
    recurseAndUpdate(root);
    return uniCount;
  }


  private static boolean recurseAndUpdate(TreeNode root) {

    if (root == null) {
      return true;
    }

    if (root.left == null && root.right == null) { // If root is a leaf node
      uniCount++;
      return true;
    } else if (root.left == null && root.right != null) { // If root has only right child
      boolean currRes = root.val == root.right.val;
      boolean rightRes = recurseAndUpdate(root.right);

      if (currRes && rightRes) {
        uniCount++;
        return true;
      }

    } else if (root.left != null && root.right == null) { // If root has only left child

      boolean currRes = root.val == root.left.val;
      boolean leftRes = recurseAndUpdate(root.left);

      if (currRes && leftRes) {
        uniCount++;
        return true;
      }

    } else { // If root have both the left & right child

      boolean currRes = root.val == root.left.val && root.val == root.right.val;
      boolean leftRes = recurseAndUpdate(root.left);
      boolean rightRes = recurseAndUpdate(root.right);

      if (currRes && leftRes && rightRes) {
        uniCount++;
        return true;
      }

    }

    return false;

  }

}