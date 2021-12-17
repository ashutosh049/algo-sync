package com.discussion.day4.binary_tree_traversal.dfs.post_order.iterative;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {

  public static void main(String[] args) {

    TreeNode node7 = new TreeNode(7, null, null);
    TreeNode node6 = new TreeNode(6, null, null);
    TreeNode node5 = new TreeNode(5, null, null);
    TreeNode node4 = new TreeNode(4, null, null);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, node6, node7);
    TreeNode node1 = new TreeNode(1, node2, node3);

    List<?> result = postOrderTraversal_1_stack(node1);
    System.out.println("1 stack: " + result);

    result = postOrderTraversal_1_stack_and_linkedList(node1);
    System.out.println("1 stack(LinkedList/Deque): " + result);

    result = postOrderTraversal_2_stack_method_1(node1);
    System.out.println("2 stack(Approach 1): " + result);

    result = postOrderTraversal_2_stack_method_2(node1);
    System.out.println("2 stack(Approach 2): " + result);

    result = postOrderTraversal_MorrisTraversal(node1);
    System.out.println("Morris Traversal: " + result);


  }

  /**
   * @param root
   * @return
   */
  private static List<Integer> postOrderTraversal_1_stack(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    TreeNode pre = null;

    while (curr != null || !stack.isEmpty()) {

      if (curr != null) {
        stack.push(curr);
        curr = curr.left; // at end cur==null
      } else {

        curr = stack.peek(); // 7

        if (curr.right == null || curr.right == pre) {
          curr = stack.pop();
          result.add(curr.val);
          pre = curr;
          curr = null;
        } else {
          curr = curr.right;
        }
      }
    }
    return result;
  }

  /**
   * Instead of using an ArrayList to store the resulting elements, we can use LinkedList(and
   * utilize the ability of deque to insert element at front) to keep pre-pending resulting nodes in
   * our list.
   * <p>
   * We are using 'addFirst' method of Deque interface.
   *
   * @param root
   * @return
   * @see java.util.Deque#addFirst(java.lang.Object)
   */
  private static List<?> postOrderTraversal_1_stack_and_linkedList(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> s = new Stack<>();

    s.push(root);

    while (!s.isEmpty()) {
      TreeNode curr = s.pop();
      result.addFirst(curr.val);

      if (curr.left != null) {
        s.push(curr.left);
      }

      if (curr.right != null) {
        s.push(curr.right);
      }
    }

    return result;
  }

  private static List<Integer> postOrderTraversal_2_stack_method_1(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> parentStack = new Stack<>();

    TreeNode curr = root;

    stack.push(curr);

    while (!stack.isEmpty()) {
      curr = stack.pop();

      parentStack.push(curr);

      if (curr.left != null) {
        stack.push(curr.left);
      }
      if (curr.right != null) {
        stack.push(curr.right);
      }
    }

    while (!parentStack.isEmpty()) {
      curr = parentStack.pop();
      result.add(curr.val);
    }

    return result;
  }

  private static List<Integer> postOrderTraversal_2_stack_method_2(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> parentStack = new Stack<>();
    TreeNode curr = root;

    stack.push(curr);

    while (!stack.isEmpty()) {
      curr = stack.peek();

      if (!parentStack.isEmpty() && parentStack.peek() == curr) {

        result.add(curr.val);
        stack.pop();
        parentStack.pop();

      } else {

        parentStack.push(curr);

        if (curr.right != null) {
          stack.push(curr.right);
        }

        if (curr.left != null) {
          stack.push(curr.left);
        }

      }
    }

    return result;
  }

  private static List<Integer> postOrderTraversal_MorrisTraversal(TreeNode root) {
    List<Integer> out = new ArrayList<>();
    if (root == null) {
      return out;
    }

    TreeNode dummy = new TreeNode(-1);
    dummy.left = root;
    root = dummy;
    TreeNode pre = null;

    while (root != null) {

      if (root.left == null) {
        root = root.right;
      } else {
        pre = root.left;

        while (pre.right != null && pre.right != root) {
          pre = pre.right;
        }

        if (pre.right == null) {
          pre.right = root;
          root = root.left;
        } else {
          TreeNode node = pre;
          reverse(root.left, pre);
          while (node != root.left) {
            out.add(node.val);
            node = node.right;
          }
          //print again since we are stopping at node = node.left
          out.add(node.val);
          reverse(pre, root.left);
          pre.right = null;
          root = root.right;
        }

      }
    }
    return out;
  }

  private static void reverse(TreeNode from, TreeNode to) {
    if (from == to) {
      return;
    }
    TreeNode prev = from;
    TreeNode node = from.right;

    while (prev != to) {
      TreeNode next = node.right;
      node.right = prev;
      prev = node;
      node = next;
    }

  }

}
