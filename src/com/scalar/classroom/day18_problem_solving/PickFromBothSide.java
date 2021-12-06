package com.scalar.classroom.day18_problem_solving;

import com.util.Util;
import java.util.List;

/**
 * <h3>Pick from both sides!</h3>
 * <pre>Problem Description
 *
 * Given an integer array A of size N.
 *
 * You can pick B elements from either left or right end of the array A to get maximum sum.
 *
 * Find and return this maximum possible sum.
 *
 * NOTE: Suppose B = 4 and array A contains 10 elements then:
 *
 * You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= B <= N
 *
 * -103 <= A[i] <= 103
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible sum of elements you picked.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [1, 2]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  8
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 *
 *  Pick element 2 from end as this is the maximum we can get</pre>
 */
public class PickFromBothSide {

  public static void main(String[] args) {
    PickFromBothSide obj = new PickFromBothSide();

    int[] A = new int[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961,
        -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726,
        -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747,
        -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
    int B = 48;

    int maxSum = obj.solve(A, B);
    System.out.println("maxSum:" + maxSum);

    A = new int[]{-584, -714, -895, -512, -718, -545, 734, -886, 701, 316, -329, 786, -737, -687,
        -645, 185, -947, -88, -192, 832, -55, -687, 756, -679, 558, 646, 982, -519, -856, 196, -778,
        129, -839, 535, -550, 173, -534, -956, 659, -708, -561, 253, -976, -846, 510, -255, -351,
        186, -687, -526, -978, -832, -982, -213, 905, 958, 391, -798, 625, -523, -586, 314, 824,
        334, 874, -628, -841, 833, -930, 487, -703, 518, -823, 773, -730, 763, -332, 192, 985, 102,
        -520, 213, 627, -198, -901, -473, -375, 543, 924, 23, 972, 61, -819, 3, 432, 505, 593, -275,
        31, -508, -858, 222, 286, 64, 900, 187, -640, -587, -26, -730, 170, -765, -167, 711, 760,
        -104, -333};
    B = 32;

    maxSum = obj.solve(A, B);
    System.out.println("maxSum:" + maxSum);
  }

  public int solve(int[] A, int B) {

    int n = A.length;
    int i = 0;
    int[] pSum = new int[B + 1];
    int[] sSum = new int[B + 1];
    pSum[0] = 0;
    sSum[0] = 0;

    for (i = 1; i <= B; i++) {
      pSum[i] = pSum[i - 1] + A[i - 1];
    }

    System.out.println("Prefix Sum:");
    Util.printArrayWithIndices(pSum);

    for (i = 1; i <= B; i++) {
      sSum[i] = sSum[i - 1] + A[n - i];
    }

    System.out.println("\nSuffix Sum:");
    Util.printArrayWithIndices(sSum);

    i = B;
    int j = 0;
    int maxSum = Integer.MIN_VALUE;

    while (i >= 0 && j <= B) {
      int lSum = 0;
      int rSum = 0;
      if (i >= 0) {
        lSum += pSum[i];
      }
      if (j >= 0) {
        rSum += sSum[j];
      }
      maxSum = Math.max(maxSum, (lSum + rSum));
      System.out
          .println("i(" + i + ")= " + lSum + ", j(" + j + ")= " + rSum + ", curSum=" + (lSum + rSum)
              + " maxSum:: " + maxSum);
      i--;
      j++;
    }

    return maxSum;
  }

  int solve_editorial(List<Integer> A, int B) {
    int n = A.size();
    int suff[] = new int[n + 1];

    suff[n] = 0;
    suff[n - 1] = A.get(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      suff[i] = A.get(i) + suff[i + 1];
    }

    int prefSum = 0;
    int ans = suff[n - B];

    for (int i = 0; i < B; i++) {
      prefSum = prefSum + A.get(i);
      int suffSum = suff[n - B + (i + 1)];
      ans = Math.max(ans, prefSum + suffSum);
    }
    return ans;

  }
}
