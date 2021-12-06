package com.scalar.topics.arrays.TwoPointers;

import java.util.Arrays;

/**
 * Return true if there exist a pair in Array whose sum is equal to K
 */
public class TwoSum_1 {

  public static void main(String[] args) {

    int[] Arr = new int[]{2, 3, 4, 12, 65, 34, 89, 12, 17, 259, 31, 22, 61};
    int k = 46;
    System.out.println("Sum equals to " + k + " = " + twoSum(Arr, k));

  }

  /**
   * Using 2 pointers
   *
   * @param arr
   * @param k
   * @return
   */
  private static boolean twoSum(int[] arr, int k) {
    boolean found = false;
    int i = 0;
    int j = arr.length - 1;

    Arrays.sort(arr);

    while (i < j) {
      if (arr[i] + arr[j] == k) {
        System.out.println("Pair found at i=" + i + "["+arr[i]+"], j=" + j + "["+arr[j]+"]");
        found = true;
        break;
      } else if (arr[i] + arr[j] < k) {
        i++;
      } else {
        j--;
      }
    }
    return found;
  }


}
