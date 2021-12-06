package com.scalar.classroom.day12;

import com.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

public class EqualPQRSLexicographically {

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();

    /**
     * 0, 1, 2, 3, 4, 5, 6
     * 3, 4, 7, 1, 2, 9, 8
     *
     * 1. 3+7= 1+9
     */
    int[] ipIntegers = new int[]{3, 4, 7, 1, 2, 9, 8};
    for (int i : ipIntegers) {
      nums.add(i);
    }
    System.out.println("--- solve_GFG ----");
    Util.printArrayList(equal(nums));
  }

  public static ArrayList<Integer> equal(ArrayList<Integer> arr) {
    HashMap<Integer, pair> map = new HashMap<>();
    ArrayList<Integer> solList = new ArrayList<>();
    int n = arr.size();
    int A1 = Integer.MAX_VALUE;
    int B1 = Integer.MAX_VALUE;
    int A2 = Integer.MAX_VALUE;
    int B2 = Integer.MAX_VALUE;

    //3, 4, 7, 1, 2, 9, 8
    for (int i = 0; i < n; ++i) {

      for (int j = i + 1; j < n; ++j) {
        int x = arr.get(i);
        int y = arr.get(j);
        int sum = x + y;
        if (map.containsKey(sum)) {
          pair p = map.get(sum);

          if (p.first != p.second && p.first != i && p.first != j && p.second != i && p.second != j
              && i != j) {
            if (p.first < A1) {
              A1 = p.first;
              B1 = p.second;
              A2 = i;
              B2 = j;
            } else if (p.first == A1 && p.second < B1) {
              A1 = p.first;
              B1 = p.second;
              A2 = i;
              B2 = j;
            } else if (p.second == B1 && i < A2) {
              A1 = p.first;
              B1 = p.second;
              A2 = i;
              B2 = j;
            } else if (i == A2 && j < B2) {
              A1 = p.first;
              B1 = p.second;
              A2 = i;
              B2 = j;
            }
          }

          //return solList;
        } else {
          map.put(sum, new pair(i, j));
        }
      }
    }

    if (A1 != Integer.MAX_VALUE) {
      solList.add(A1);
      solList.add(B1);
      solList.add(A2);
      solList.add(B2);
    }

    return solList;
  }

  //--------scalar solution--------
  public ArrayList<Integer> equal_scalar_sol(ArrayList<Integer> A) {

    ArrayList<Integer> res = new ArrayList<>();
    HashMap<Integer, ArrayList<Node>> hashMap = new HashMap<>();
    int n;
    int sum;
    ArrayList<Node> nodes;
    Node curNode;
    n = A.size();

    if (A == null || A.size() < 4) {
      return res;
    }

    for (int i = 0; i < n; i++) {

      for (int j = i + 1; j < n; j++) {

        sum = A.get(i) + A.get(j);
        curNode = new Node(i, j);

        if (hashMap.containsKey(sum)) {
          nodes = hashMap.get(sum);
        } else {
          nodes = new ArrayList<>();
        }

        nodes.add(curNode);
        hashMap.put(sum, nodes);

      }

    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {

        sum = A.get(i) + A.get(j);
        curNode = new Node(i, j);

        if (hashMap.containsKey(sum)) {
          nodes = hashMap.get(sum);

          for (Node node : nodes) {
            if (overlaps(curNode, node)) {
              continue;
            }
            res.add(curNode.i);
            res.add(curNode.j);
            res.add(node.i);
            res.add(node.j);
            return res;
          }
        }
      }
    }

    return res;


  }

  public boolean overlaps(Node n1, Node n2) {

    if (n1.i == n2.i || n1.i == n2.j || n1.j == n2.i || n1.j == n2.j) {
      return true;
    }

    return false;
  }

  static class pair {

    int first, second;

    pair(int f, int s) {
      first = f;
      second = s;
    }
  }

  class Node {

    int i, j;

    public Node(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

}

