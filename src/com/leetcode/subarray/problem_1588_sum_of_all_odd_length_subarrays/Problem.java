package com.leetcode.subarray.problem_1588_sum_of_all_odd_length_subarrays;

public class Problem {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 4, 2, 5, 3};
    int totalSum = sumOddLengthSubarrays(arr);
    System.out.println("totalSum:" + totalSum);
  }

  public static int sumOddLengthSubarrays(int[] arr) {

    int n = arr.length;
    int totalSum = 0;

    for (int i = 0; i < n; i++) {
      int curSum = 0;
      for (int j = i; j < n; j++) {
        curSum += arr[j];
        // We need to add  the cursum to total only when the length of
        //sub-array is odd.
        //To get the length of sub array: end-start+1
        int lengthSubArray = j - i + 1;
        if (j % 2 == 0) {
          totalSum += curSum;
        }
      }
    }

    return totalSum;

  }
}
