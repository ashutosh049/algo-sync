package com.scalar.classroom.day17_string_manipulation;

public class ClosestPalindrome {

  public static void main(String[] args) {

    String s = "";

    s = "aaaaaaaaaabaaaaaaaaa";
    System.out.println("palindrom: " + solve(s));

    s = "asdfghjklasdfghjklasdfgqjklasdfghjkllkjhgfdsalkjhgfdsalkjhgfdsalkjhgfdsa";
    System.out.println("palindrom: " + solve(s));

    s = "aa";
    System.out.println("palindrome: " + solve(s));

  }

  public static String solve(String A) {
    int count = 0;

    int l = 0, r = A.length() - 1;

    while (l < r && A.charAt(l) == A.charAt(A.length() - 1 - l)) {
      l++;
      r--;
    }

    if (Math.abs(l - r) == 1) {
      if (A.charAt(l) == A.charAt(r)) {
        return "NO";
      } else {
        return "YES";
      }
    }

    count++;
    char[] aArr = A.toCharArray();
    aArr[l] = aArr[r];
    A = new String(aArr);

    int i = 0, j = A.length() - 1;
    while (i < j) {
      if (A.charAt(i) != A.charAt(j)) {
        return "NO";
      }
      i++;
      j--;
    }
    return "YES";
  }
}
