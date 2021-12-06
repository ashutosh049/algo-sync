package com.scalar.classroom.day17_string_manipulation;

public class IsAlpha {

  public static void main(String[] args) {

    //printIntValueOFChars();
    removeChartAt();

    char[] c = new char[]{'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
    System.out.println(solve(c));
  }

  private static void removeChartAt() {
    String A = "google";
    int i = 3;
    String prev = A.substring(0, i);
    String later = A.substring(i + 1);
    A = prev + later;
    System.out.println("prev :" + prev);
    System.out.println("later :" + later);
    System.out.println("Removed :" + A);
  }

  public static int solve(char[] A) {
    for (int i = 0; i < A.length; i++) {
      char c = A[i];
      if (!isLowercase(c) && !isUppercase(c) && !isNumber(c)) {
        return 0;
      }
    }
    return 1;
  }

  private static boolean isLowercase(char c) {
    return c >= (int) 'a' && c <= (int) 'z';
  }

  private static boolean isUppercase(char c) {
    return c >= (int) 'A' && c <= (int) 'Z';
  }

  private static boolean isNumber(char c) {
    return c >= (int) '0' && c <= (int) '9';
  }

  private static void printIntValueOFChars() {
    char[] c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    for (int i = 0; i < c.length; i++) {
      System.out.println("[" + (int) c[i] + "]" + c[i]);
    }

    c = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    for (int i = 0; i < c.length; i++) {
      System.out.println("[" + (int) c[i] + "]" + c[i]);
    }
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'
        || c == 'I' || c == 'O' || c == 'U';
  }
}