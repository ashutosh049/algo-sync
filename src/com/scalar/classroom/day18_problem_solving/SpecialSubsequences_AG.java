package com.scalar.classroom.day18_problem_solving;

/**
 * <h3>Special Subsequences "AG"</h3>
 * <pre>Problem Description
 *
 * You have given a string A having Uppercase English letters.
 *
 * You have to find that how many times subsequence "AG" is there in the given string.
 *
 * NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 105
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "ABCGAG"
 * Input 2:
 *
 *  A = "GAB"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Subsequence "AG" is 3 times in given string
 * Explanation 2:
 *
 *  There is no subsequence "AG" in the given string.</pre>
 */
public class SpecialSubsequences_AG {

  /**
   * "AG" can be calculated by multiplying the no. of 'A' & 'G'. For every A encountered, increment
   * aMul count and for every 'G' encountered, increment gMul count. THen calculate the total-count
   * as 'tCount += aMul*gMul'. Once we are done with current 'G', decrement the gMul count.
   *
   * @param A
   * @return
   */
  public int solve_mysol(String A) {
    int n = A.length();
    double count = 0;
    int aMul = 0;
    int gMul = 0;

    for (int i = 0; i < n; i++) {
      char curChar = A.charAt(i);
      if (curChar == 'A') {
        aMul++;
      } else if (curChar == 'G') {
        gMul++;
        count += (aMul * gMul);
        count = count % (Math.pow(10, 9) + 7);
        gMul--;
      }
    }

    return (int) count;
  }

  /**
   * <h3>Solution Approach Editorial</h3>
   * The main task is to find the number of times subsequence “AG” appear in a string. Simply find
   * the number of G’s after any index 'i' by taking 'suffix-sum'. Then traverse the string again
   * and when you encounter an ‘A’ add number of G’s after that to the answer.
   *
   * @param A
   * @return
   */
  public int solve_editorial(String A) {

    int n = A.length(), ans = 0, MOD = 1000 * 1000 * 1000 + 7;
    int cnt_G[] = new int[n], count = 0;

    //Suffix count of G
    for (int i = n - 1; i >= 0; i--) {
      if (A.charAt(i) == 'G') {
        count = count + 1;
      }
      cnt_G[i] = count;
    }

    // traverse the string again from beginning
    for (int i = 0; i < n; i++) {
      // if current character is "A" then add number of G's after that
      if (A.charAt(i) == 'A') {
        ans = ans + cnt_G[i];
        ans = ans % MOD;
      }
    }

    return ans;
  }
}