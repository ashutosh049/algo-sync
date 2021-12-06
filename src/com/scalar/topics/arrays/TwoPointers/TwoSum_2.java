package com.scalar.topics.arrays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted Array of integers, return all the pairs which add to 'k'.
 */
public class TwoSum_2 {

  public static void main(String[] args) {

    int[] Arr = new int[]{1, 4, 4, 5, 5, 5, 6, 6, 1, 1};
    int k = 11;
    System.out.println("Sum equals to " + k + " = " + twoSum(Arr, k));

  }

  /**
   * Using 2 pointers
   *
   * @param arr
   * @param k
   * @return
   */
  private static List<List<Integer>> twoSum(int[] arr, int k) {
    boolean found = false;
    int i = 0;
    int j = arr.length - 1;
    List<List<Integer>> solList = new ArrayList<>();

    Arrays.sort(arr);

    while (i < j) {
      if (arr[i] + arr[j] == k) {
        List<Integer> foundIndicesList = new ArrayList<>();
        found = true;
        foundIndicesList.add(i);
        foundIndicesList.add(j);
      } else if (arr[i] + arr[j] < k) {
        i++;
      } else {
        j--;
      }
    }
    return solList;
  }


}
