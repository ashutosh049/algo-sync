package com.bst;

public class ConstructBST {
  // Recursive function to perform inorder traversal on a given binary tree
  public static void inorder(Node root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
  }

  // Recursive function to build a binary search tree from
  // its postorder sequence
  public static Node constructBST(int[] postorder, int start, int end) {
    // base case
    if (start > end) {
      return null;
    }

    // Construct the root node of the subtree formed by keys of the
    // postorder sequence in range `[start, end]`
    Node node = new Node(postorder[end]);

    // search the index of the last element in the current range of postorder
    // sequence, which is smaller than the root node's value
    int i;
    for (i = end; i >= start; i--) {
      if (postorder[i] < node.val) {
        break;
      }
    }

    // Build the right subtree before the left subtree since the values are
    // being read from the end of the postorder sequence.

    // recursively construct the right subtree
    node.right = constructBST(postorder, i + 1, end - 1);

    // recursively construct the left subtree
    node.left = constructBST(postorder, start, i);

    // return current node
    return node;
  }

  public static void main(String[] args) {
    /* Construct the following BST
              15
            /    \
           /      \
          10       20
         /  \     /  \
        /    \   /    \
       8     12 16    25
    */

    //int[] postorder = {1,2,3,4,5,6,7,8,9};
    int[] postorder = {9,8,7,6,5,4,3,2,1};

    // construct the BST
    Node root = constructBST(postorder, 0, postorder.length - 1);

    // print the BST
    System.out.print("Inorder traversal of BST is ");

    // inorder on the BST always returns a sorted sequence
    inorder(root);
  }
}
