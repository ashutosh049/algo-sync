package com.leetcode.binary_tree.easy.binary_tree_inorder_traversal;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInOrderTraversal {

  static List<Integer> out;

  public static void main(String[] args) {

    Integer[] nodes = new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4};
    TreeNode root = buildFromNodes(nodes);

    System.out.println("Iterative: " + inOrderTraversalIterative(root));

    out = new ArrayList<>();
    inOrderTraversalRecursive(root);
    System.out.println("Recursive: " + out);

  }

  private static List<Integer> inOrderTraversalIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {

      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
      }
    }
    return result;
  }

  private static void inOrderTraversalRecursive(TreeNode root) {

    if (root == null) {
      return;
    }

    inOrderTraversalRecursive(root.left);
    out.add(root.val);
    inOrderTraversalRecursive(root.right);

  }

}
