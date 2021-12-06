package com.leetcode.problem_567_permutation_in_string;

import com.util.Util;
import java.util.HashMap;

/**
 * <pre>Given two strings s1 and s2, write a function to return true if s2 contains the permutation
 * of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Constraints:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000]</pre>
 */
public class PermutationInString {

  public static void main(String[] args) {

    String source = "abc";

    int[] s1map = new int[26];

    for (int i = 0; i < source.length(); i++) {
      int s1 = 'a';
      int s2 = source.charAt(i);
      System.out.println("s1:" + s1 + ", s2:" + s2);
      s1map[s2 - s1]++;
    }

    Util.printArray(s1map);


  }

  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1map = new int[26];
    int[] s2map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1map[s1.charAt(i) - 'a']++;
      s2map[s2.charAt(i) - 'a']++;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (s1map[i] == s2map[i]) {
        count++;
      }
    }
    for (int i = 0; i < s2.length() - s1.length(); i++) {
      int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
      if (count == 26) {
        return true;
      }
      s2map[r]++;
      if (s2map[r] == s1map[r]) {
        count++;
      } else if (s2map[r] == s1map[r] + 1) {
        count--;
      }
      s2map[l]--;
      if (s2map[l] == s1map[l]) {
        count++;
      } else if (s2map[l] == s1map[l] - 1) {
        count--;
      }
    }
    return count == 26;
  }

  public static int checkPermutations(String source, String target) {

    if (source.length() > target.length()) {
      return 0;
    }

    int[] s1map = new int[26];
    int[] s2map = new int[26];
    int count = 0;
    for (int i = 0; i < source.length(); i++) {
      s1map[source.charAt(i) - 'a']++;
      s2map[target.charAt(i) - 'a']++;
    }

    for (int i = 0; i < target.length() - source.length(); i++) {
      if (matches(s1map, s2map)) {
        count++;
        //return true;
      }
      s2map[target.charAt(i + source.length()) - 'a']++;
      s2map[target.charAt(i) - 'a']--;
    }

    if(matches(s1map, s2map)){
      count++;
    }
    return count;
  }

  public static boolean matches(int[] s1map, int[] s2map) {
    for (int i = 0; i < 26; i++) {
      if (s1map[i] != s2map[i]) {
        return false;
      }
    }
    return true;
  }

  public static int checkPermutation(String source, String target) {
    if (source.length() > target.length()) {
      return 0;
    }
    int count = 0;
    HashMap<Character, Integer> s1map = new HashMap<>();
    for (int i = 0; i < source.length(); i++) {
      s1map.put(source.charAt(i), s1map.getOrDefault(source.charAt(i), 0) + 1);
    }
    for (int i = 0; i <= target.length() - source.length(); i++) {
      HashMap<Character, Integer> s2map = new HashMap<>();
      for (int j = 0; j < source.length(); j++) {
        s2map.put(target.charAt(i + j), s2map.getOrDefault(target.charAt(i + j), 0) + 1);
      }

      if (matches(s1map, s2map)) {
        count++;
        //return true;
      }
    }
    //return false;
    return count;
  }

  public static boolean matches(HashMap<Character, Integer> s1map,
      HashMap<Character, Integer> s2map) {
    for (char key : s1map.keySet()) {
      if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0) {
        return false;
      }
    }
    return true;
  }
}