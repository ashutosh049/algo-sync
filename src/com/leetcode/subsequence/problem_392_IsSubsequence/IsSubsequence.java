package com.leetcode.subsequence.problem_392_IsSubsequence;

public class IsSubsequence {

  public static void main(String[] args) {

  }

  public static boolean isSubsequence(String s, String t) {

    Integer sourceLen = s.length(), targetLen = t.length();
    // the source string is empty
    if (sourceLen == 0) {
      return true;
    }

    int[][] dp = new int[sourceLen + 1][targetLen + 1];
    // DP calculation, we fill the matrix column by column, bottom up
    for (int col = 1; col <= targetLen; ++col) {
      for (int row = 1; row <= sourceLen; ++row) {
        if (s.charAt(row - 1) == t.charAt(col - 1))
        // find another match
        {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else
        // retrieve the maximal result from previous prefixes
        {
          dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
        }
      }
      // check if we can consume the entire source string,
      // with the current prefix of the target string.
      if (dp[sourceLen][col] == sourceLen) {
        return true;
      }
    }

    // matching failure
    return false;
  }

}
