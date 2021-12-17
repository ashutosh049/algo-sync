package com.discussion.day5;

import com.util.TreeNode;

public class Merge2BinaryTree {

  private static int count = 0;

  public static void main(String[] args) {

    TreeNode nodet17 = new TreeNode(7, null, null);
    TreeNode nodet16 = new TreeNode(6, nodet17, null);
    TreeNode nodet15 = new TreeNode(5, nodet16, null);
    TreeNode nodet14 = new TreeNode(4, nodet15, null);
    TreeNode nodet13 = new TreeNode(3, null, null);
    TreeNode nodet12 = new TreeNode(2, nodet14, null);

    TreeNode root1 = new TreeNode(1, nodet12, nodet13);

    TreeNode nodet27 = new TreeNode(7, null, null);
    TreeNode nodet26 = new TreeNode(6, null, nodet27);
    TreeNode nodet25 = new TreeNode(5, null, nodet26);
    TreeNode nodet24 = new TreeNode(4, null, nodet25);
    TreeNode nodet23 = new TreeNode(3, null, nodet24);
    TreeNode nodet22 = new TreeNode(2, null, nodet23);
    TreeNode root2 = new TreeNode(1, null, nodet22);

    //mergeTrees(root1, root2);
    mergeTrees_ours(root1, root2);

  }

  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    System.out.println("count:" + (++count));
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  public static TreeNode mergeTrees_ours(TreeNode root1, TreeNode root2) {
    TreeNode result = null;
    return mergeTrees(root1, root2, result);
  }

  private static TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode result) {
    System.out.println("count:" + (++count));
    if (root1 == null) {
      System.out.println("root1 is null");
      return root2;
    } else if (root2 == null) {
      System.out.println("root2 is null");
      return root1;
    }

    if (result == null) {
      result = validateAndCreate(root1, root2);

    }

    result.left = mergeTrees(root1.left, root2.left, result.left);
    result.right = mergeTrees(root1.right, root2.right, result.right);
    return result;
  }


  private static TreeNode validateAndCreate(TreeNode n1, TreeNode n2) {
    TreeNode newNode = null;

    if (n1 == null && n2 != null) {
      newNode = n2;
    } else if (n1 != null && n2 == null) {
      newNode = n1;
    } else if (n1 != null && n2 != null) {
      newNode = new TreeNode(n1.val + n2.val);

    }

    return newNode;

  }

}
