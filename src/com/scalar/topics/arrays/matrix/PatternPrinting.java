package com.scalar.topics.arrays.matrix;

public class PatternPrinting {

  public static void main(String[] args) {
    for (int i = 0; i <= 3; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(j+1);
      }
      System.out.println();
    }
  }

}
