package com.scalar.topics.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, every element appears thrice except for one which occurs once.
 * <pre>Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * Note: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 * Input Format:
 *
 *     First and only argument of input contains an integer array A
 * Output Format:
 *
 *     return a single integer.
 * Constraints:
 *
 * 2 <= N <= 5 000 000
 * 0 <= A[i] <= INT_MAX
 * For Examples :
 *
 * Example Input 1:
 *     A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Example Output 1:
 *     4
 * Explanation:
 *     4 occur exactly once
 * Example Input 2:
 *     A = [0, 0, 0, 1]
 * Example Output 2:
 *     1
 * </pre>
 */
public class SingleNumber_2 {

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(4);
/*    arr.add(2);
    arr.add(3);
    arr.add(2);
    arr.add(1);
    arr.add(2);
    arr.add(3);*/

    int missing = singleNumber(arr);
    System.out.println("Single missing no:"+missing);
  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static int singleNumber(final List<Integer> A) {
    int missingNo = 0;
    for (int i = 0; i < A.size(); i++) {
      missingNo ^= A.get(i);
    }
    return missingNo;
  }
}