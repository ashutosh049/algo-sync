package com.leetcode.subarray.problem_209_Minimum_Size_Subarray_Sum;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal
 * length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is
 * greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class problem_209_Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {
        int k = 7;
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};

        System.out.println("min subarray len (minSubArrayLen_atleastK):: "+minSubArrayLen_atleastK(k, arr));
        System.out.println("min subarray len (minSubArrayLen_equaklsK):: "+minSubArrayLen_equaklsK(k, arr));
    }

    /**
     * Atleast k
     */
    public static int minSubArrayLen_atleastK(int k, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= k) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


    /**
     * Equals to k
     */
    public static int minSubArrayLen_equaklsK(int k, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum == k) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
