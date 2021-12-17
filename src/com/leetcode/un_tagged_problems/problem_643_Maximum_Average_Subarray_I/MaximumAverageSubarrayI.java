package com.leetcode.un_tagged_problems.problem_643_Maximum_Average_Subarray_I;

/**
 * <pre>Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].</pre>
 */
public class MaximumAverageSubarrayI {

  public static void main(String[] args) {

    System.out.println("Max average :" + findMaxAverage_slidingWindow(new int[]{0, 1, 1, 3, 3}, 4));

  }

  public static double findMaxAverage_slidingWindow(int[] nums, int k) {

    int n = nums.length;

    if (n == 1) {
      return (double) nums[0];
    }

    double maxSum = Double.MIN_VALUE;
    double curSum = 0;

    for (int i = 0; i < k; i++) {
      curSum += nums[i];
    }
    maxSum = curSum;

    for (int i = k; i < n; i++) {
      int p = nums[i - k];
      int c = nums[i];
      curSum = (curSum - p) + c;
      maxSum = Math.max(maxSum, curSum);
    }

    return maxSum / k;

  }

  /**
   * 1 <= k <= n <= 30,000. Elements of the given array will be in the range [-10,000, 10,000].
   * Example: nums [0,1,1,3,3] k=4
   **/
  public static double findMaxAverage_prefixSum(int[] nums, int k) {

    int n = nums.length;

    if (n == 1) {
      return (double) nums[0];
    }

    int[] pSum = new int[n + 1];
    pSum[0] = 0;

    for (int i = 1; i < (n + 1); i++) {
      pSum[i] = pSum[i - 1] + nums[i - 1];
    }

    double maxAvg = Double.MIN_VALUE;

    for (int i = k; i < n + 1; i++) {
      double curSum = pSum[i] - pSum[i - k];
      maxAvg = Math.max(maxAvg, curSum);
    }

    return maxAvg / k;

  }

  public double findMaxAverage(int[] nums, int k) {
    int ind = 0;
    int sum = 0;
    while(ind < k) {
      sum += nums[ind];
      ind++;
    }
    int maxSum = sum;
    while(ind < nums.length) {
      sum -= nums[ind-k];
      sum += nums[ind];
      if(maxSum < sum) {
        maxSum = sum;
      }
      ind++;
    }
    return (double) maxSum / (double) k;
  }

}
