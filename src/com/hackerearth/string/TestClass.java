package com.hackerearth.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestClass {

  public static void main(String[] args) throws IOException {

    String A = "xyzpqrabcdf";
    String B = "yzaqrsbcdef";
    String C = "yyzzxxxqppqabcddce";
    String D = "aaaaaaappppaaaaaaa";

    String out_ = Solution(A, B, C);
    System.out.println(C + "\n->\n" + out_);
  }

  static String Solution(String A, String B, String C) {
    // Write your code here
    Map<Character, Character> charMap = new HashMap<>();
    for (int i = 0; i < A.length(); i++) {

      char curA = A.charAt(i);
      char curB = B.charAt(i);

      char x1 = A.charAt(i);
      char x2 = B.charAt(i);

      if (x1 < x2) {
        x2 = x1;
      } else {
        x1 = x2;
      }

      Character r1 = charMap.get(curA);
      if (r1 != null) {
        if (r1.compareTo(x1) > 0) {
          r1 = x1;
          charMap.put(curA, r1);
        }
      } else {
        charMap.put(curA, x1);
      }

      Character r2 = charMap.get(curB);
      if (r2 != null) {
        if (r2.compareTo(x2) > 0) {
          r2 = x2;
          charMap.put(curB, r2);
        }
      } else {
        charMap.put(curB, x2);
      }
    }

    String lexSamllest = C;
    for (int i = 0; i < C.length(); i++) {
      Character r = charMap.get(C.charAt(i));
      if (r != null) {
        lexSamllest = lexSamllest.replace(C.charAt(i), r);
      }
    }

    return lexSamllest;

  }
}