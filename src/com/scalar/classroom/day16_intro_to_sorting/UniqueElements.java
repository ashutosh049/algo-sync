package com.scalar.classroom.day16_intro_to_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueElements {

  public int solve(ArrayList<Integer> A) {
    int res = 0;

    if (A != null && A.size() > 1) {

      int n = A.size();
      Collections.sort(A);

      for (int i = 1; i < n; i++) {
        int curVal = A.get(i);
        if (curVal == A.get(i - 1)) {
          A.set(i, curVal + 1);
          res++;
        } else if (curVal < A.get(i - 1)) {
          int diff = (A.get(i - 1) - curVal) + 1;
          A.set(i, (curVal + diff));
          res += diff;
        }
      }
    }
    return res;
  }

  public int solve_editorial(int[] A) {
    int n = A.length;
    // sort the array
    Arrays.sort(A);
    // initialize variables
    int steps = 0, i = 1, j = 0;
    // loop unitil you reach the end
    while (j < n) {
      // make current element unique
      if (i >= A[j]) {
        steps += (i - A[j++]);
        i += 1;
      } else {
        i = A[j] + 1;
        j += 1;
      }
    }
    // return the answer
    return steps;
  }
}
