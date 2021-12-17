package com.discussion.day1;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("All")
public class PrintsubArray {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4};

    //System.out.println("bruteforceSubarraySum : " + bruteforceSubarraySum(arr));
    //System.out.println("optimizedSubarraySum : " + optimizedSubarraySum(arr));
    //System.out.println("regroupingSubarraySum : " + regroupingSubarraySum(arr));

     printSubarray_1(arr);
  }

  private static int bruteforceSubarraySum(int[] arr) {
    int n = arr.length;
    int totalSum = 0;
    for (int i = 0; i < n; i++) { // O(n)
      for (int j = i; j < n; j++) { // O(n)
        for (int k = i; k <= j; k++) {
          totalSum += arr[k];
        }
      }
    }
    return totalSum;
  }

  private static int optimizedSubarraySum(int[] arr) {
    int n = arr.length;
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
      int rangeSum = 0;
      for (int j = i; j < n; j++) {
        rangeSum += arr[j];
        totalSum += rangeSum;
      }
    }
    return totalSum;
  }

  private static int regroupingSubarraySum(int[] arr) {
    int n = arr.length;
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
      totalSum += arr[i] * (i + 1) * (n - i);
    }
    return totalSum;
  }

  private static void printSubarray_2(int[] arr) {

    int subArrSize = 0;

    for (int i = 0; i < arr.length; i++) {
      List<Integer> subArr = new ArrayList<>();
      for (int j = i; j < arr.length; j++) {
        // System.out.println("["+arr[j]+"]");
        subArr.add(arr[j]);
        System.out.println("subarr:: ");
        subArr.stream().forEach(x -> System.out.println(x));
        subArrSize++;
      }
      System.out.println("subArrSize: " + subArrSize);
    }
  }

  /** Prints subarrays using 3 for loops */
  private static void printSubarray_1(int[] arr) {

    int n = arr.length;

    for (int i = 0; i < n; i++) { // O(n)
      for (int j = i; j < n; j++) { // O(n)
        readPrintArrayForRange(arr, i, j); // O(n)
      }
    }
  }

  /**
   * Prints elemts for given array from index i to j, all inclusive TC: O(n)
   *
   * @param arr
   * @param i
   * @param j
   * @param elements
   */
  private static void readPrintArrayForRange(int[] arr, int i, int j) {
    StringBuilder elements = new StringBuilder();
    for (int k = i; k <= j; k++) {
      elements.append(arr[k]);
      if (k < j) elements.append(",");
    }
    System.out.println("[" + elements.toString() + "]");
  }
}
// n = 10
// size :(n *(n+1))/2 = (10 * 11)/ 2 110/2 = 55
