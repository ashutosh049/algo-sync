package com.scalar.topics.arrays;

import com.util.Util;

public class ReverseArray2Pointer {

  public static void main(String[] args) {

    int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    System.out.println("Original : ");
    Util.printArray(arr);

    reverse2Pointer(arr, 0, arr.length);

    System.out.println("\nreversed : ");
    Util.printArray(arr);

  }

  public static void reverse2Pointer(int[] arr, int low, int high) {
    int i = low;
    int j = high - 1;
    while (i < j) {
      int tmp = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
      i++;
      j--;
    }
  }
}
