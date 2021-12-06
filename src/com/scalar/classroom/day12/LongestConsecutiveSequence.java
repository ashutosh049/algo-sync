package com.scalar.classroom.day12;

import java.util.HashMap;

/**
 * <pre>Problem Description
 *
 * Given an unsorted integer array A of size N.
 *
 * Find the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -106 <= A[i] <= 106
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 *
 * A = [2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 *
 *  The set of consecutive elements will be [1, 2].</pre>
 */
public class LongestConsecutiveSequence {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int longestConsecutive(final int[] A) {

    HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

    int maxCount = 0;
    for (int ele : A) {
      if (hMap.get(ele) == null) {
        int lCount = 0;
        int rCount = 0;
        if (hMap.get(ele - 1) != null) {
          lCount = hMap.get(ele - 1);
        }
        if (hMap.get(ele + 1) != null) {
          rCount = hMap.get(ele + 1);
        }

        hMap.put(ele, lCount + 1 + rCount);

        hMap.put(ele - lCount, hMap.get(ele));
        hMap.put(ele + rCount, hMap.get(ele));

        if (maxCount < lCount + 1 + rCount) {
          maxCount = lCount + 1 + rCount;
        }
      }
    }

    return maxCount;
  }
}