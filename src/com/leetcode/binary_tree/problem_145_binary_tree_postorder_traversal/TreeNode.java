package com.leetcode.binary_tree.problem_145_binary_tree_postorder_traversal;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode constructTree(int arg[], int size) {
    Index index = new Index();
    index.postindex = size - 1;
    return constructTreeUtil(
        arg, index, arg[index.postindex], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
  }

  private static TreeNode constructTreeUtil(
      int arg[], Index postIndex, int key, int min, int max, int size) {
    // Base case
    if (postIndex.postindex < 0) return null;

    TreeNode root = null;

    // If current element of post[] is in range, then
    // only it is part of current subtree
    if (key > min && key < max) {
      // Allocate memory for root of this subtree and decrement
      // *postIndex
      root = new TreeNode(key);
      postIndex.postindex = postIndex.postindex - 1;

      if (postIndex.postindex > 0) {
        // All nodes which are in range {key..max} will go in
        // right subtree, and first such node will be root of right
        // subtree
        root.right = constructTreeUtil(arg, postIndex, arg[postIndex.postindex], key, max, size);

        // Construct the subtree under root
        // All nodes which are in range {min .. key} will go in left
        // subtree, and first such node will be root of left subtree.
        root.left = constructTreeUtil(arg, postIndex, arg[postIndex.postindex], min, key, size);
      }
    }
    return root;
  }

  void printInorder(TreeNode node) {
    if (node == null) return;
    printInorder(node.left);
    System.out.print(node.val + " ");
    printInorder(node.right);
  }

  private void setLeft(TreeNode left) {
    this.left = left;
  }

  private void setRight(TreeNode right) {
    this.right = right;
  }
}

class Index {
  int postindex = 0;
}
