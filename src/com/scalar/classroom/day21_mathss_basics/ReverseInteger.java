package com.scalar.classroom.day21_mathss_basics;

public class ReverseInteger {

  public static void main(String[] args) {

    System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
    System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);

    int a = Integer.MAX_VALUE;
    int rev = reverse(a);
    System.out.println("reverse of " + a + ": " + rev);

    a = Integer.MIN_VALUE;
    rev = reverse(a);
    System.out.println("reverse of " + a + ": " + rev);
  }

  public static int reverse(int A) {

    String num = String.valueOf(A);

    boolean isNeg = false;
    if (num.charAt(0) == '-') {
      isNeg = true;
      num = num.substring(1);
    }
    int n = num.length();
    String rev = "";

    for (int i = n - 1; i >= 0; i--) {
      rev += num.charAt(i);
    }

    if (isNeg) {
      rev = '-' + rev;
    }

    try {
      return Integer.valueOf(rev);
    } catch (NumberFormatException e) {
      return 0;
    }

  }

  public int reverse_editorial(int A) {
    int reverse = A;
    int sign = 1;

    if (A < 0) {
      A *= -1;
      sign = -1;
    }

    reverse = reverseOf(A);

    if (reverse == Integer.MIN_VALUE) {
      return 0;
    }

    reverse *= sign;

    return reverse;

  }

  public int reverseOf(int num) {

    int newNum = 0;

    while (num > 0) {
      int digit = num % 10;

      if (newNum > Integer.MAX_VALUE / 10 || ((newNum == Integer.MAX_VALUE / 10)
          && digit > Integer.MAX_VALUE % 10)) {
        return Integer.MIN_VALUE;
      }

      newNum = newNum * 10 + digit;
      num /= 10;
    }

    return (int) newNum;

  }
}
