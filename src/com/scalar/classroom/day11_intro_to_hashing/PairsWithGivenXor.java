package com.scalar.classroom.day11_intro_to_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>Problem Description
 *
 * Given an 1D integer array A containing N distinct integers.
 *
 * Find the number of unique pairs of integers in the array whose XOR is equal to B.
 *
 * NOTE:
 *
 * Pair (a, b) and (b, a) is considered to be same and should be counted once.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i], B <= 107
 *
 *
 *
 * Input Format
 * First argument is an 1D integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 10, 15, 7, 6]
 *  B = 5
 * Input 2:
 *
 *  A = [3, 6, 8, 10, 15, 50]
 *  B = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (10 ^ 15) = 5
 * Explanation 2:
 *
 *  (3 ^ 6) = 5 and (10 ^ 15) = 5</pre>
 */
public class PairsWithGivenXor {

  public static void main(String[] args) {
    int a = 1;
    int b = 2;
    int c = a ^ b;
    int a1 = b ^ c;
    int b1 = a ^ c;

    System.out.println("a ^ b : " + a + "^" + b + ": " + c);
    System.out.println("b ^ c : " + b + "^" + c + ": " + a1);
    System.out.println("a ^ c : " + a + "^" + c + ": " + b1);

  }

  public static int solveXor(ArrayList<Integer> A, int B) {

    int pairCount = 0;

    if (A != null && A.size() >= 1) {
      int n = A.size();
      Map<Integer, Integer> indexMap = new HashMap<>();

      for (int i = 0; i < n; i++) {
        int xorComplmnt = B ^ A.get(i);

        if (indexMap.containsKey(xorComplmnt)) {
          pairCount++;
        } else if (!indexMap.containsKey(A.get(i))) {
          indexMap.put(A.get(i), i);
        }
      }

    }
    return pairCount;
  }

}
