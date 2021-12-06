package com.scalar.classroom.day21_mathss_basics;

public class Solution {

  public int solve(int[] A, int K) {
    final int mod = (int) Math.pow(10, 9) + 7;
    int freq[] = new int[K];
    int n = A.length;

    for (int i = 0; i < n; i++) {
      ++freq[A[i] % K];
    }

    // If both pairs are divisible by 'K'
    int sum = freq[0] * (freq[0] - 1) / 2;

    // count for all i and (k-i)
    // freq pairs
    for (int i = 1; i <= K / 2 && i != (K - i); i++) {
      sum += freq[i] * freq[K - i];
    }

    // If K is even
    if (K % 2 == 0) {
      sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
    }

    return sum % mod;
  }
}
