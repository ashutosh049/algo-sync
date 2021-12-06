package com.scalar.topics.arrays;

import com.util.Util;

public class ReverseArray {

  public static void main(String[] args) {

    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    System.out.println("Original : ");
    Util.printArray(arr);

    reverse(arr);

    System.out.println("\nreversed : ");
    Util.printArray(arr);

  }

  public static void reverse(int[] arr) {

    int n = arr.length;

    for (int i = 0; i < n / 2; i++) {
      int tmp = arr[n - 1 - i];
      arr[n - 1 - i] = arr[i];
      arr[i] = tmp;
    }

  }
}
