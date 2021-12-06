package com.scalar.classroom.day21_mathss_basics;

import com.util.Util;

public class ModularProgramming {

  public static void main(String[] args) {
    int[] a = new int[]{0, 2, 3, 4, 5, 6, 1};
    String num = "0123456";

    int[] b = new int[a.length];

    for (int i = a.length-1; i >= 0 ; i++) {
      int x = Integer.valueOf(num) % 10;
      b[i-a.length+1]= num.charAt(x);
    }
    System.out.println("sol: ");
    Util.printArray(b);
  }

}
