package com.discussion.day4.binary_tree_traversal.dfs.post_order.resursive;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PostOrderRecursive {

  static List<Integer> result;

  public static void main(String[] args) {

    TreeNode node7 = new TreeNode(7, null, null);
    TreeNode node6 = new TreeNode(6, null, null);
    TreeNode node5 = new TreeNode(5, null, null);
    TreeNode node4 = new TreeNode(4, null, null);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, node6, node7);
    TreeNode node1 = new TreeNode(1, node2, node3);

    result = new ArrayList<>();
    List<Integer> result = postOrderTraversal(node1);

    System.out.println(result);

  }


  /**
   * <li>Recurse Left
   * <li>Recurse Right
   * <li>Process Root
   *
   * @param root
   * @return
   */
  private static List<Integer> postOrderTraversal(TreeNode root) {
    if (root == null) {
      return result;
    }

    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    result.add(root.val);

    return result;

  }

}
