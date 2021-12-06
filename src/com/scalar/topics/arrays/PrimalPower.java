package com.scalar.topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimalPower {

  public static void main(String[] args) {
    //97, 43, 29, 11, 100, 47, 76, 83, 37, 19, 17, 19, 71, 0, 1, -82, 2, -83, 37, 13, 5, 97, 17, 30, 31, 48, 2, 19, 31, 91, 19, 2, 5, 89, 2, 67, 31, 47, 43, 31, 5, 17, 83, 11, 47, 73, 19, 3, 3, 19, 59, 91, 67, 7, 43, 4, 3, 51, 52, 23, 3, 37, 53, 89, 9, 41, 19, 61, 7, 5, 53, 59, 19, 11, 79, 37, 31, 37, 73, 82, 41, 2, 13, 8, 2, 36, 19, 58, 17, 17, 59, 59, 37, 11, 13, 37, 47, 83, 31, 3

    List<Integer> arr = new ArrayList<>();
    /*arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);*/
    arr = Arrays.asList(
        new Integer[]{97, 43, 29, 11, 100, 47, 76, 83, 37, 19, 17, 19, 71, 0, 1, -82, 2, -83, 37,
            13, 5, 97, 17, 30, 31, 48, 2, 19, 31, 91, 19, 2, 5, 89, 2, 67, 31, 47, 43, 31, 5, 17,
            83, 11, 47, 73, 19, 3, 3, 19, 59, 91, 67, 7, 43, 4, 3, 51, 52, 23, 3, 37, 53, 89, 9, 41,
            19, 61, 7, 5, 53, 59, 19, 11, 79, 37, 31, 37, 73, 82, 41, 2, 13, 8, 2, 36, 19, 58, 17,
            17, 59, 59, 37, 11, 13, 37, 47, 83, 31, 3});

    int sol = solve(arr);

    System.out.println(sol);

  }

  public static int solve(List<Integer> A) {
    int countPrime = 0;

    if (A != null && A.size() >= 1) {
      int n = A.size();

      for (int i = 0; i < n; i++) {
        if (isPrime(A.get(i))) {
          countPrime++;
        }
      }

    }
    return countPrime;

  }

  private static boolean isPrime(int a) {
    if (a <= 1) {
      return false;
    }
    int dCount = 2;
    for (int i = 2; i <= a / 2; i++) {
      if (a % i == 0) {
        dCount++;
      }
    }
    return dCount <= 2;
  }
}
