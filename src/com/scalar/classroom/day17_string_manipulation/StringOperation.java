package com.scalar.classroom.day17_string_manipulation;

public class StringOperation {

  public static void main(String[] args) {
    String s = "lLdfRVCgbkND";
    String res = solve(s);
    System.out.println("After operation: " + res);
  }

  public static String solve(String S) {

    String A = S;
    int i = 0;

    while (i < A.length()) {
      if (isUppercase(A.charAt(i))) {
        String prev = A.substring(0, i);
        String later = A.substring(i + 1);
        A = prev + later;

      } else {
        if (isVowel(A.charAt(i))) {
          String vowel = "" + A.charAt(i);
          A = A.replaceAll(vowel, "#");
        }
        i++;
      }
    }

        /*for (i = 0; i < A.length(); i++) {
          if (isVowel(A.charAt(i))) {
            String vowel = "" + A.charAt(i);
            A = A.replaceAll(vowel, "#");
          }
        }*/

    return A+A;

  }

  private static boolean isUppercase(char c) {
    return c >= (int) 'A' && c <= (int) 'Z';
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'
        || c == 'I' || c == 'O' || c == 'U';
  }

  private static boolean isLowercase(char c) {
    return c >= (int) 'a' && c <= (int) 'z';
  }

  private static boolean isNumber(char c) {
    return c >= (int) '0' && c <= (int) '9';
  }
}
