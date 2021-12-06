package com.scalar.topics.arrays;

import static com.util.Util.printArray;

public class RotateArrayByKPositionsFromLeft {

  public static void main(String[] args) {

    int[] arr0 = new int[]{1, 2, 3, 4, 5};
    int k = 2;

    System.out.println("Original : ");
    printArray(arr0);

    //rotate(arr0, k);
    rotate(arr0, k % arr0.length);
    System.out.println("\nRotated by " + k + " positions from left : ");
    System.out.println(k + " % " + (arr0.length) + "= " + (k % arr0.length));
    printArray(arr0);

    int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    k = 11;
    rotate(arr1, k % arr1.length);
    System.out.println("\nRotated by " + k + " positions from left : ");
    System.out.println(k + " % " + (arr1.length) + "= " + (k % arr1.length));
    printArray(arr1);

  }

  public static void rotate(int[] arr, int k) {

    int n = arr.length;

    //Step-2: Reverse All
    reverse2Pointer(arr, 0, n);

    //Step-2: Reverse left part
    reverse2Pointer(arr, 0, (n - k));

    //Step-3: Reverse right part
    reverse2Pointer(arr, (n - k), n);
    //printArray(arr);
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
