package com.scalar.classroom.day11_intro_to_hashing;

public class PermutationOfAInB {

  public int solve(String A, String B) {
    if (A.length() > B.length()) {
      return 0;
    }

    int permCount = 0;
    int[] sourceCharCounts = new int[26];
    int[] targetCharCounts = new int[26];

    for (int i = 0; i < A.length(); i++) {
      sourceCharCounts[A.charAt(i) - 'a']++;
      targetCharCounts[B.charAt(i) - 'a']++;
    }

    for (int i = 0; i < B.length() - A.length(); i++) {
      if (matches(sourceCharCounts, targetCharCounts)) {
        permCount++;
      }
      targetCharCounts[B.charAt(i + A.length()) - 'a']++;
      targetCharCounts[B.charAt(i) - 'a']--;
    }

    if (matches(sourceCharCounts, targetCharCounts)) {
      permCount++;
    }

    return permCount;
  }

  public boolean matches(int[] sourceCharCounts, int[] targetCharCounts) {
    for (int i = 0; i < 26; i++) {
      if (sourceCharCounts[i] != targetCharCounts[i]) {
        return false;
      }
    }
    return true;
  }

}
