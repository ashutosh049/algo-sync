package com.scalar.classroom.day17_string_manipulation;

public class LexicographicallyLargest {

  public static void main(String[] args) {
    System.out.println("abb_c: " + getLargest1("abb_c"));
    System.out.println("ittmcsvmoa_jktvvblefw: " + getLargest1("ittmcsvmoa_jktvvblefw"));
  }

  public static String getLargest1(String A) {
    int i = A.indexOf('_');
    String S = A.substring(0, i);
    String T = A.substring(i + 1);

    char[] sArr = S.toCharArray();

    for (i = 0; i < S.length(); i++) {
      int largerCharIndex = getLargeAvailableCharIndex(S.charAt(i), T);
      if (largerCharIndex != -1) {
        char largerChar = T.charAt(largerCharIndex);
        T = removeCharAt(T, largerCharIndex);
        sArr[i] = largerChar;
      }
    }
    return new String(sArr);
  }

  private static int getLargeAvailableCharIndex(char c, String t) {
    int maxCharIndex = -1;
    char maxCharAvailable = c;
    if (t.length() >= 1) {
      for (int i = 0; i < t.length(); i++) {
        if (maxCharAvailable < t.charAt(i)) {
          maxCharIndex = i;
          maxCharAvailable = t.charAt(maxCharIndex);
        }
      }
    }
    return maxCharIndex;
  }

  private static String removeCharAt(String T, int largerCharIndex) {
    String prev = T.substring(0, largerCharIndex);
    String later = T.substring(largerCharIndex + 1);
    return prev + later;
  }

}
