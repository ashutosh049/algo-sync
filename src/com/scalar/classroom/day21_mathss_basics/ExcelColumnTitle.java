package com.scalar.classroom.day21_mathss_basics;

import com.util.Util;

/**
 * <pre>Problem Description
 *
 * Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * First and only argument of input contains single integer A
 *
 *
 *
 * Output Format
 * Return a string denoting the corresponding title.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 *
 * A = 27
 *
 *
 * Example Output
 * Output 1:
 *
 * "C"
 * Output 2:
 *
 * "AA"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * 3 corrseponds to C.
 * Explanation 2:
 *
 *     1 -> A,
 *     2 -> B,
 *     3 -> C,
 *     ...
 *     26 -> Z,
 *     27 -> AA,
 *     28 -> AB </pre>
 */
public class ExcelColumnTitle {

  public static void main(String[] args) {

    System.out.println("Max int: " + Integer.MAX_VALUE);
    System.out.println("Min int: " + Integer.MIN_VALUE);

    System.out.println("diff: " + (Integer.MAX_VALUE - (int) Math.pow(10, 9)));

    System.out.println("Max int binary : " + Integer.toBinaryString(Integer.MAX_VALUE));
    System.out.println("Min int binary : " + Integer.toBinaryString(Integer.MIN_VALUE));

    /*System.out.println("943566 : " + convertToTitle_accepted(943566));
    System.out.println("2147483647 : " + convertToTitle_accepted(2147483647));
    System.out.println("2147483646 : " + convertToTitle_accepted(2147483646));
    System.out.println("2147483645 : " + convertToTitle_accepted(2147483645));*/

    System.out.println("-------------");
    System.out.println("943566 : " + convertToTitle_editorial(943566));
    System.out.println("2147483647 : " + convertToTitle_editorial(2147483647));
    System.out.println("2147483646 : " + convertToTitle_editorial(2147483646));
    System.out.println("2147483645 : " + convertToTitle_editorial(2147483645));

  }

  public static String convertToTitle_editorial(int A) {
    char[] array = new char[26];

    for (int i = 0; i < 26; i++) {
      array[i] = (char) ('A' + i);
    }

    System.out.println("char array");
    Util.printArrayWithIndices(array);

    int num = 26;
    int index;
    String res = "";

    while (A > 0) {
      index = (A - 1 + num) % num;
      A = (A - 1) / num;
      res = array[index] + res;
    }

    return res;

  }

  public static String convertToTitle(int num) {
    final int base = 26;
    String title = "";

    if (num == 0) {
      return title;
    }

    while (num > 0) {
      title = getChar(num % base) + title;
      num /= base;
    }

    //title = getCodePoint(A, 1) + title;
    return title;

  }

  private static char getChar(int i) {
    return (char) (65 + i - 1);
  }

  private static char getCodePoint(int i) {
    if (i == 0) {
      i = 26;
    }
    return getCodePoint(i, 1);
  }

  private static char getCodePoint(int i, int offset) {
    return (char) ((int) 'A' + i - offset);
  }

  public static String convertToTitle_recursion(int n) {
    return n == 0 ? "" : convertToTitle_recursion(--n / 26) + (char) ('A' + (n % 26));
  }

  public static int titleToNumber(String A) {

    int n = A.length();
    double colNum = 0;

    for (int i = 0; i < n; i++) {
      char colTitle = A.charAt(n - 1 - i);
      colNum += getCodePoint(colTitle) * Math.pow(26, i);
    }

    return (int) colNum;
  }

  private static int getCodePoint(char c) {
    return (int) c - (int) 'A' + 1;
  }

  public static String convertToTitle_accepted(int A) {
    StringBuilder result = new StringBuilder();

    while (A > 0) {
      A--;
      result.insert(0, (char) ('A' + A % 26));
      A /= 26;
    }

    return result.toString();

  }

/**  nums [1,2,3,4,5]
 * k = 9
 * Possible sub-arrays:
 * 1.[1]=1
 * 2.[1,2]=3
 * 3.[1,2,3]=6
 * 4.[1,2,3,4]=10
 * 5.[1,2,3,4,5]=15
 * 6.[2] = 2
 * 7.[2,3] = 5
 * 8.[2,3,4] =9
 * 9.[2,3,4,5] = 14
 * 10.[3] =3
 * 11.[3,4] =7
 * 12.[3,4,5] =12
 * 13.[4] =4
 * 14.[4,5] =9
 * 15.[5] =5
 *
 * Output: 1, as there is only 1 sub-array whose sum is 9
 **/

}
