package com.leetcode.subarray.problem_1588_sum_of_all_odd_length_subarrays;

//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class Solution {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 4, 2, 5, 3};
    int sum = sumOddLengthSubarrays(arr);
    System.out.println("total sum of all odd lenght sub-arrays: " + sum);

    System.out.println("-----GetAllSubarrays-----");
    GetAllSubarrays(arr);
  }

  /**
   * TC: O(n^2) SC: O(1)
   *
   * @param arr
   * @return
   */
  public static int sumOddLengthSubarrays(int[] arr) {
    int n = arr.length;
    int globalSum = 0;

    for (int i = 0; i < n; i++) {
      int curSum = 0;
      for (int j = i; j < n; j++) {
        curSum += arr[j];
        if ((j - i) % 2 == 0) {
          globalSum += curSum;
        }
      }
    }

    return globalSum;

  }

  public static void GetAllSubarrays(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + ", ");
        }
        System.out.println();
      }
    }
  }

  /**
   * TC: O(n^2) SC: O(n)
   *
   * @param arr
   * @return
   */
  public static int sumOddLength_CumSum(int[] arr) {
    int n = arr.length;
    int globalSum = 0;

    int[] cumSumArr = new int[n + 1];
    cumSumArr[0] = 0;

    for (int i = 1; i <= n; i++) {
      cumSumArr[i] = cumSumArr[i - 1] + arr[i - 1];
    }

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j = j + 2) {
        globalSum += cumSumArr[j + 1] - cumSumArr[i];
      }
    }

    return globalSum;

  }

}