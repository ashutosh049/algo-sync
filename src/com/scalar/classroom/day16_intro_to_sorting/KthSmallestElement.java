package com.scalar.classroom.day16_intro_to_sorting;

import com.util.Util;
import java.util.Arrays;

public class KthSmallestElement {

  public static void main(String[] args) {

    int[] A = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81,
        42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17,
        46, 26, 81, 92};
    int b = 9;

    int ans = kthsmallest(A, b);
    System.out.println(b + " smallest element: " + ans);

  }

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public static int kthsmallest(final int[] A, int B) {

    System.out.println("Before sorting...");
    Util.printArrayWithIndices(A);
    System.out.println("After sorting...");
    Arrays.sort(A);
    Util.printArrayWithIndices(A);
    return A[B - 1];
  }

  public int kthsmallest_editorial(final int[] A, int B) {

    for (int i = 0; i < B; i++) {
      int minn = Integer.MAX_VALUE, idx = 0;
      for (int j = i; j < A.length; j++) {
        if (A[j] < minn) {
          minn = A[j];
          idx = j;
        }
      }

      int tmp = A[i];
      A[i] = A[idx];
      A[idx] = tmp;
    }

    return A[B - 1];
  }
}
