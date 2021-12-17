package com.leetcode.un_tagged_problems.problem_498.problem_1143;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.</pre>
 */
class LongestCommonSubsequence {

  public static void main(String[] args) {

  }
  public static int longestCommonSubsequence(String text1, String text2) {
    int count = 0;

    if(text1 != null && text2 != null && text1.trim().length()>=1 && text2.trim().length()>=1){
      if (text2.length() > text1.length()){
        String tmp = text1;
        text1 = text2;
        text2 = tmp;
      }

      int i=0;
      int j=0;

      /*Map<Integer, Integer> countMap = new HashMap<>();

      for (; i < text1.length(); i++) {
        char x = text1.charAt(i);

        while (x != text2.charAt(j)){
          j++;
        }
        Integer length = countMap.get(j);
        if(length == null){
          countMap.put(j, 1);
        }else{
          countMap.put(j, length+1);
        }

      }*/

      Map<Integer, Integer> countMap = new HashMap<>();
      String subsequence = "";

      for (; i < text1.length(); i++) {
        char x = text1.charAt(i);

        while (x != text2.charAt(j)){
          j++;
        }

        if(j < text2.length()){
          subsequence += text2.charAt(j);
        }

      }

    }

    return count;
  }
}