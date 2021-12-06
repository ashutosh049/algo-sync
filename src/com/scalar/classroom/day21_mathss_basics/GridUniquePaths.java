package com.scalar.classroom.day21_mathss_basics;

/**
 * <h3>Grid Unique Paths</h3>
 * <pre>Problem Description
 *
 * A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).
 *
 *
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Problem Constraints
 * A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 *
 *
 * Input Format
 * First argument of input will be single integer A.
 * Second argument of input will be single integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of unique paths.
 *
 *
 *
 * Example Input
 *  A = 2, B = 2
 *
 *
 * Example Output
 *  2
 *
 *
 * Example Explanation
 *  2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)</pre>
 */
public class GridUniquePaths {

  public int uniquePaths_editorial(int a, int b) {
    if (a == 1 || b == 1) {
      return 1;
    } else {
      int ans = 0;
      ans = uniquePaths_editorial(a - 1, b) + uniquePaths_editorial(a, b - 1);
      return ans;
    }
  }

  public int uniquePaths_editorial_fastest(int A, int B) {
    return ncr(A + B - 2, Math.min(A - 1, B - 1));
  }

  private int ncr(int n, int r) {
    long res = 1;
    int N = n;
    int R = Math.min(r, n - r);
    for (int i = 1; i <= R; i++) {
      res *= n;
      n--;
    }

    long res1 = 1;
    for (int i = 1; i <= r; i++) {
      res1 *= i;
    }

    return (int) (res / res1);
  }

  public int uniquePaths_editorial_lightWeight(int a, int b) {
    if (a == 1 || b == 1) {
      return 1;
    }
    for (int n = 0; n <= a + b; n++) {
      int nCk = 1;
      for (int k = 0; k <= n; k++) {
        if (n == a + b - 2 && k == b - 1) {
          return nCk;
        }
        nCk = nCk * (n - k) / (k + 1);
      }
    }
    return 0;
  }

}
