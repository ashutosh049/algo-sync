package com.leetcode.binary_tree.easy.binary_tree_paths;

import static com.util.TreeNode.buildFromNodes;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * <p>
 * Example 1
 *
 * <pre>
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * </pre>
 * <p>
 * Example 2
 *
 * <pre>
 * Input: root = [1]
 * Output: ["1"]
 * </pre>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-paths/"> 257. Binary Tree Paths</a>
 */
public class BinaryTreePaths {

  public static void main(String[] args) {

    Integer[] nodes = new Integer[]{1, 2, 8, 6, 3, null, 9, 7, null, null, 4, 10, 11, null, null, 5,
        null, null, null, 12, null, null, null, null,
        13}; // expected output [1->2->6->7, 1->2->3->4->5, 1->8->9->10, 1->8->9->11->12->13]

    TreeNode root = buildFromNodes(nodes);

    System.out.println("Iterative DFS (post-order, StringBuilder): " + binaryTreePaths(root));

  }

  /**
   * Iterative DFS (post-order, StringBuilder)
   *
   * @param root
   * @return
   */
  public static List<String> binaryTreePaths(TreeNode root) {

    List<String> out = new ArrayList<>();

    if (root == null) {
      return out;
    }

    Stack<TreeNode> nodeStack = new Stack();
    TreeNode curr = root;
    TreeNode pre = null;
    StringBuilder sb = new StringBuilder();

    while (curr != null || !nodeStack.isEmpty()) {
      if (curr != null) {
        if (sb.length() > 0) {
          sb.append("->");
        }
        sb.append(curr.val);
        nodeStack.push(curr);
        curr = curr.left;
      } else {
        curr = nodeStack.peek();

        // if leaf node
        if (curr.left == null && curr.right == null) {
          out.add(sb.toString());
        }

        if (curr.right == null || curr.right == pre) {
          curr = nodeStack.pop();

          int currAppendedStringLength = String.valueOf(curr.val).length();

          if (sb.lastIndexOf("->") > -1) {
            currAppendedStringLength += 2;
          }
          sb.delete(sb.length() - currAppendedStringLength, sb.length());

          pre = curr;
          curr = null;
        } else {
          curr = curr.right;
        }
      }
    }
    return out;
  }

}
