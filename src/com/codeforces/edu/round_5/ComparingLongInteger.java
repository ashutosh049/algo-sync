package com.codeforces.edu.round_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparingLongInteger {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine().trim();
    String b = br.readLine().trim();

    System.out.println(compare(a, b));
  }

  private static long getNumber(String s) {
    String num = s.trim();
    return Long.valueOf(num).longValue();
  }

  private static String compare(String a, String b) {

    String x = removeLeadingZeroes(a);
    String y = removeLeadingZeroes(b);

    int xLen = x.length();
    int yLen = y.length();

    if(xLen > yLen){
        return ">";
    }else if(xLen < yLen){
        return "<";
    }else{
        int l = x.length();
        l = x.length() < y.length() ? x.length() : y.length();

        for (int i = 0; i < l; i++) {
          int m = Integer.valueOf(x.charAt(i)).intValue();
          int n = Integer.valueOf(y.charAt(i)).intValue();
          if (m > n) {
            return ">";
          } else if (m < n) {
            return "<";
          } else if (m == n && i == l) {
            return "=";
          }
        }

    }

    return "=";
  }

  private static String removeLeadingZeroes(String a) {
    if (a.length() == 1) {
      return a;
    }

    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (a.charAt(i) == '0' && i < a.length()-1) {
      i++;
    }

    for (int j = i; j < a.length(); j++) {
      sb.append(a.charAt(j));
    }

    return sb.toString();
  }

  protected enum ComparisonSymbols {
    GREATER_THAN() {
      @Override
      String getSymbol() {
        return ">";
      }
    },
    SMALLER_THAN() {
      @Override
      String getSymbol() {
        return "<";
      }
    },
    EQUAL_TO() {
      @Override
      String getSymbol() {
        return "=";
      }
    };

    abstract String getSymbol();
  }
}
