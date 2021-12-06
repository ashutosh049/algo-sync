package com.scalar.classroom.day12;

import com.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <pre>Problem Description
 *
 * For Given Number A find if its COLORFUL number or not.
 *
 * If number A is a COLORFUL number return 1 else return 0.
 *
 * What is a COLORFUL Number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 *
 *
 * Problem Constraints
 * 1 <= A <= 2 * 109
 *
 *
 *
 * Input Format
 * Single Argument which denotes integer A.
 *
 *
 *
 * Output Format
 * Return 1 if integer A is COLORFUL else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 23
 * Input 2:
 *
 *  A = 236
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possible Sub-sequences: [2, 3, 23] where
 *  2 -> 2
 *  3 -> 3
 *  23 -> 6  (product of digits)
 *  This number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Explanation 2:
 *
 *  Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 *  2 -> 2
 *  3 -> 3
 *  6 -> 6
 *  23 -> 6  (product of digits)
 *  36 -> 18  (product of digits)
 *  236 -> 36  (product of digits)
 *  This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same. </pre>
 */
public class ColorfulNumber {

  public static void main(String[] args) {
    int input2 = 263;
    System.out.println(input2 + " is colorful: " + isColorful(input2));
    System.out.println(input2 + " is colorful: " + colorful_IB(input2));

  }

  public static int isColorful(int num) {

    Map<String, Integer> prodMap = new HashMap<>();
    List<Integer> allsubseq = genSubsequence_number(String.valueOf(num), "", new ArrayList<>());

    Util.printArrayList(allsubseq);

    for (int i = 0; i < allsubseq.size(); i++) {
      String product = getProduct(allsubseq.get(i));
      if (prodMap.containsKey(product)) {
        return 0;
      } else {
        prodMap.put(product, allsubseq.get(i));
      }
    }
    return 1;
  }

  private static List<Integer> genSubsequence_number(String input, String output,
      List<Integer> subseqList) {

    if (input.length() == 0) {
      if (output.length() >= 1) {
        subseqList.add(Integer.valueOf(output));
      }
      return subseqList;
    }

    genSubsequence_number(input.substring(1), output, subseqList);
    genSubsequence_number(input.substring(1), output + input.charAt(0), subseqList);

    return subseqList;
  }

  private static String getProduct(int n) {
    int product = 1;

    while (n != 0) {
      product = product * (n % 10);
      n = n / 10;
    }

    return String.valueOf(product);
  }

  public static int colorful_IB(int a) {

    String A = Integer.toString(a);
    HashSet<Integer> set = new HashSet<>();
    int prod = 0;
    for (int i = 0; i < A.length(); i++) {
      prod = 1;
      for (int j = i; j < A.length(); j++) {
        prod *= A.charAt(j) - '0';
        if (set.contains(prod)) {
          return 0;
        } else {
          set.add(prod);
        }
      }
    }
    return 1;
  }

  /*private static int genSubsequence(String input, String output, Map<Integer, Integer> seqMap) {

    if (input.length() == 0) {
      if (output.length() >= 1) {
        seqMap.put(getProduct(Integer.valueOf(output)), Integer.valueOf(output));
      }
      return isColorful(seqMap, Integer.valueOf(output));
    }

    genSubsequence(input.substring(1), output, seqMap);
    genSubsequence(input.substring(1), output + input.charAt(0), seqMap);

    return isColorful(seqMap, Integer.valueOf(output));
  }*/



  /*private static int isColorful(Map<Integer, Integer> seqMap, int key) {
    return seqMap.containsKey(Integer.valueOf(key)) ? 0 : 1;
  }*/


}
