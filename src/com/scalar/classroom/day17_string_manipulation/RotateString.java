package com.scalar.classroom.day17_string_manipulation;

public class RotateString {

  public static void main(String[] args) {
    String s = "scaler";
    int b = 2;

    System.out.println("Rotated: '" + solve(s, 2) + "'");
  }

  public static String solve(String A, int B) {
    StringBuilder sb = new StringBuilder();
    int n = A.length();
    int i = 0;

    int reverseBy = B % n;

    for (; i < reverseBy; i++) {
      sb.insert(0, A.charAt(n - i - 1));
    }
    i = n - i;
    sb.append(A.substring(0, i));
    return sb.toString();
  }
  // ---------Solution editorial---------
    /*void antirotate(string &s, int d)
    {
      reverse(s.begin(), s.begin()+d);
      reverse(s.begin()+d, s.end());
      reverse(s.begin(), s.end());
    }

  void clockrotate(string &s, int B)
  {
    antirotate(s, s.length()-B);
  }

  string Solution::solve(string A, int B) {
    int n = A.size();
    B = B%n;
    clockrotate(A, B);
    return A;
  }*/
}