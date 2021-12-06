package com.leetcode.subarray.problem_53_maximum_subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * <p>A subarray is a contiguous part of an array.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum =
 * 6. Example 2:
 *
 * <p>Input: nums = [1] Output: 1 Example 3:
 *
 * <p>Input: nums = [5,4,-1,7,8] Output: 23
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 105 -104 <= nums[i] <= 104
 *
 * <p>Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">maximum-subarray</a>
 */
@SuppressWarnings("Duplicates")
public class MaximumSubArray {

  private static MaximumSubArray maximumSubArray;
  private static Map<Integer[], Integer> testCases;

  // @formatter:off
  static {
    maximumSubArray = new MaximumSubArray();
    testCases = new HashMap<>();

    testCases.put(new Integer[] {1}, 1);
    testCases.put(new Integer[] {-1, 1}, 1);
    testCases.put(new Integer[] {-1, -1}, -1);
    testCases.put(new Integer[] {-1, -2}, -1);
    testCases.put(new Integer[] {0}, 0);
    testCases.put(
        new Integer[] {
          -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5,
          4, -2, 1, -3, 4, -1, 2, 1, -5, 4
        },
        9);
    testCases.put(new Integer[] {-1, -2, -3, -4, -5, -6, -7, -8, -9}, -1);
  }
  // @formatter:on

  public static void main(String[] args) {
    maximumSubArray.maxSubArray();
  }

  public void maxSubArray() {

    System.out.println("----- bruteForce -------");
    testCases.entrySet().stream()
        .forEach(
            entry -> {
              int result = bruteForce(entry.getKey());
              System.out.println(
                  (entry.getValue().intValue() == result)
                      ? "Ok"
                      : "Wrong. Expected:" + entry.getValue().intValue() + ", got:" + result);
            });

    System.out.println("----- optimizedBruteForce -------");
    testCases.entrySet().stream()
        .forEach(
            entry -> {
              int result = optimizedBruteForce(entry.getKey());
              System.out.println(
                  (entry.getValue().intValue() == result)
                      ? "Ok"
                      : "Wrong. Expected:" + entry.getValue().intValue() + ", got:" + result);
            });

    System.out.println("----- kadanesAlgo -------");
    testCases.entrySet().stream()
        .forEach(
            entry -> {
              int result = kadanesAlgo(entry.getKey());
              System.out.println(
                  (entry.getValue().intValue() == result)
                      ? "Ok"
                      : "Wrong. Expected:" + entry.getValue().intValue() + ", got:" + result);
            });
  }

  /**
   * TC: O(n^3) SC: O(1)
   *
   * @param nums
   * @return
   */
  private int bruteForce(Integer[] nums) {

    int n = nums.length;

    if (n == 1) return nums[0];

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int subArrSum = 0;
        for (int k = i; k <= j; k++) {
          subArrSum += nums[k];
        }
        maxSum = Math.max(maxSum, subArrSum);
      }
    }

    return maxSum;
  }

  /**
   * TC: O(n^2) SC: O(1)
   *
   * @param nums
   * @return
   */
  private int optimizedBruteForce(Integer[] nums) {

    int n = nums.length;

    if (n == 1) return nums[0];

    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int subArrSum = 0;
      for (int j = i; j < n; j++) {
        subArrSum += nums[j];
        maxSum = Math.max(maxSum, subArrSum);
      }
    }

    return maxSum;
  }

  /**
   * TC: O(n) SC: O(1)
   *
   * @param nums
   * @return
   */
  private int kadanesAlgo(Integer[] nums) {

    int n = nums.length;

    if (n == 1) return nums[0];

    int maxSum = nums[0];
    int currSum = nums[0];

    for (int i = 1; i < n; i++) {
      int newElm = nums[i];
      int newSum = currSum + newElm;

      if (newSum > newElm) {
        currSum = newSum;
      } else {
        currSum = newElm;
      }

      maxSum = Math.max(maxSum, currSum);
    }

    return maxSum;
  }
}
