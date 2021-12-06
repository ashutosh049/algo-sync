package com.leetcode.subsequence.problem_940_DistinctSubsequences2;

import java.util.Arrays;

/**
 * <pre>Given a string S, count the number of distinct, non-empty subsequences of S .
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * Example 2:
 *
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 * Example 3:
 *
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 *
 *
 *
 * Note:
 *
 * S contains only lowercase letters.
 * 1 <= S.length <= 2000</pre>
 */
public class DistinctSubsequences2 {

  public static void main(String[] args) {

  }

  public int distinctSubseqII(String S) {
    int MOD = 1_000_000_007;
    int N = S.length();
    int[] dp = new int[N + 1];
    dp[0] = 1;

    int[] last = new int[26];
    Arrays.fill(last, -1);

    for (int i = 0; i < N; ++i) {
      int x = S.charAt(i) - 'a';
      dp[i + 1] = dp[i] * 2 % MOD;
      if (last[x] >= 0) {
        dp[i + 1] -= dp[last[x]];
      }
      dp[i + 1] %= MOD;
      last[x] = i;
    }

    dp[N]--;
    if (dp[N] < 0) {
      dp[N] += MOD;
    }
    return dp[N];
  }

}
