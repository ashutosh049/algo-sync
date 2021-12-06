package com.scalar.topics.strings;

/**
 * <pre>
 *   Vowel it
 * Raman is very fond of vowels. One day, he got a string as a gift for his birthday. He got very excited and wanted to obtain the longest subsequence of vowels from the original string. You are asked to help Raman.
 *
 * Given a string A of lowercase English alphabets, find and return a string which is the longest subsequence of vowels in the string A.
 *
 * Note:
 *
 * 1. Vowels are 'a' , 'e' ,'i' , 'o' , 'u'.
 * 2. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements from the original sequence without changing the order of the remaining elements.
 * 3. It is guaranteed that atleast one vowel will be present in the given string.
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return a string which is the longest subsequence of vowels in the string A.
 * Constraints
 *
 * 1 <= length of the string <= 100000
 * For Example
 *
 * Input 1:
 *    abcdye
 * Output 1:
 *     ae
 *
 * Input 2:
 *     abhishek
 * Output 2:
 *     aie
 *
 * Input 3:
 *     interviewbit
 * Output 3:
 *     ieiei
 * </pre>
 */
public class VowelIt {

  public static void main(String[] args) {
    String s = "ashutosh";
    System.out.println("vowel::" + solve(s));
  }

  static String solve(String A) {
    final String[] vowels = {"a", "e", "i", "o", "u"};//"aeiou";

    StringBuilder maxSubSeq = new StringBuilder();

    for (int i = 0; i < A.length(); i++) {

      /*if (vowels.contains(A.charAt(i))) {
      }*/
      if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o'
          || A.charAt(i) == 'u') {
        maxSubSeq.append(A.charAt(i));
      }
      //if(A.charAt(i)==)
    }

    return maxSubSeq.toString();
  }
}