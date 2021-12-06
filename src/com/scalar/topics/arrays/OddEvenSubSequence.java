package com.scalar.topics.arrays;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSubSequence {

  public static void main(String[] args) {

    ArrayList<Integer> A = new ArrayList<Integer>();

    A.add(1);
    A.add(1);
    A.add(2);
    A.add(3);

    int count = solve(A);
    System.out.println("Max subsequence count : " + count);

  }

  public static int solve(ArrayList<Integer> A) {
    int oCount = 1;
    int eCount = 1;

    if (A != null && A.size() >= 1) {

      int curr = A.get(0);

      if (isOdd(curr)) {
        oCount = findNext(A, 1, (A.size() - 1), RequiredNumType.EVEN, oCount);
      }

      if (isEven(curr)) {
        oCount = findNext(A, 1, (A.size() - 1), RequiredNumType.ODD, eCount);
      }
    }
    return Math.max(oCount, eCount);
  }

  private static int findNext(List<Integer> arr, int l, int r, RequiredNumType type, int count) {

    if (l > r) {
      return count;
    }

    int curr = arr.get(l);

    if (type.equals(RequiredNumType.EVEN) && isEven(curr)) {
      count++;
      type = RequiredNumType.ODD;
    } else if (type.equals(RequiredNumType.ODD) && isOdd(curr)) {
      count++;
      type = RequiredNumType.EVEN;
    }

    return findNext(arr, (l + 1), r, type, count);
  }

  private static boolean isOdd(int a) {
    return a % 2 != 0;
  }

  private static boolean isEven(int a) {
    return a % 2 == 0;
  }

  private enum RequiredNumType {
    EVEN, ODD;
  }
}
