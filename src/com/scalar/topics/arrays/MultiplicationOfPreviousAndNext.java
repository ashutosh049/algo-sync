package com.scalar.topics.arrays;

import java.util.ArrayList;

public class MultiplicationOfPreviousAndNext {

  public static void main(String[] args) {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);

    ArrayList<Integer> sol = solve(arr);

    System.out.println(sol);

  }

  public static ArrayList<Integer> solve(ArrayList<Integer> A) {
    ArrayList<Integer> solList = new ArrayList<Integer>();
    if (A != null && A.size() >= 2) {
      int n = A.size();
      for (int i = 0; i < n; i++) {
        if (i == 0) {
          solList.add(i, (A.get(i) * A.get(i + 1)));
        } else if (i == n - 1) {
          solList.add(i, (A.get(i) * A.get(i - 1)));
        } else {
          solList.add(i, (A.get(i - 1) * A.get(i + 1)));
        }
      }
    }
    return solList;
  }
}
