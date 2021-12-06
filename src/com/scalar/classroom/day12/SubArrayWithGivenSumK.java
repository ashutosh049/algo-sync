package com.scalar.classroom.day12;

import com.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>Subarray with given sum
 * Problem Description
 *
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.</pre>
 */
public class SubArrayWithGivenSumK {

  public static void main(String[] args) {

    ArrayList<Integer> nums = new ArrayList<>();

    int[] ipIntegers = new int[]{1, 2, 3, 4, 5};
    int b = 5;
    for (int i : ipIntegers) {
      nums.add(i);
    }
    System.out.println("--- solve_GFG ----");
    Util.printArrayList(solve_GFG(nums, b));
    System.out.println("--- solve_bruteforce ----");
    Util.printArrayList(solve_bruteforce(nums, b));
    System.out.println("--- solve_sol_scalar ----");
    Util.printArray(solve_sol_scalar(nums, b));

    //-----------------------------------------------
    ipIntegers = new int[]{5, 10, 20, 100, 105};
    b = 110;
    nums = new ArrayList<>();

    for (int i : ipIntegers) {
      nums.add(i);
    }
    System.out.println("--- solve_GFG ----");
    Util.printArrayList(solve_GFG(nums, b));
    System.out.println("--- solve_bruteforce ----");
    Util.printArrayList(solve_bruteforce(nums, b));
    System.out.println("--- solve_sol_scalar ----");
    Util.printArray(solve_sol_scalar(nums, b));

    //-----------------------------------------------
    ipIntegers = new int[]{1, 2, 2, 6, 4, 8, 7, 3, 5};
    b = 8;
    nums = new ArrayList<>();
    for (int i : ipIntegers) {
      nums.add(i);
    }

    System.out.println("--- solve_GFG ----");
    Util.printArrayList(solve_GFG(nums, b));
    System.out.println("--- solve_bruteforce ----");
    Util.printArrayList(solve_bruteforce(nums, b));
    System.out.println("--- solve_sol_scalar ----");
    Util.printArray(solve_sol_scalar(nums, b));

    //------------
    /*Set<Integer> set = new HashSet<>();

    set.add(0);

    int sum = 0;

    for (int value: nums) {
      sum += value;

      if (set.contains(sum)) {
        return 1;
      }

      set.add(sum);
    }

    return 0;*/
    //------------
  }

  public static ArrayList<Integer> solve_GFG(ArrayList<Integer> nums, int givenSum) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (givenSum <= 0) {
      solList.add(-1);
      return solList;
    }

    int currSum = nums.get(0), start = 0, i;

    for (i = 1; i <= nums.size(); i++) {

      while (currSum > givenSum && start < i - 1) {
        currSum = currSum - nums.get(start);
        start++;
      }

      if (currSum == givenSum) {
        int p = i - 1;
        for (int ii = start; ii <= p; ii++) {
          solList.add(nums.get(ii));
        }
        break;
      }

      if (i < nums.size()) {
        currSum = currSum + nums.get(i);
      }
    }

    if (solList.size() == 0) {
      solList.add(-1);
    }

    return solList;
  }

  public static ArrayList<Integer> solve_bruteforce(ArrayList<Integer> nums, int givenSum) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (givenSum <= 0) {
      solList.add(-1);
      return solList;
    }

    int n = nums.size();
    // 1. Get all sub array
    // 2. Check if sum is equal to given sum
    for (int i = 0; i < n; i++) {
      int curSum = 0;
      for (int j = i + 1; j < n; j++) {
        //sum i -> j
        if (sumUpto(nums, i, j) == givenSum) {
          for (int k = i; k <= j; k++) {
            solList.add(nums.get(k));
          }
        }
      }
    }

    // If solution list is empty, i.e. we did not find any sub-array with given sum, return add -1 to sol list
    if (solList.size() == 0) {
      solList.add(-1);
    }

    return solList;
  }

  public static int[] solve_sol_scalar(ArrayList<Integer> nums, int givenSum) {

    long n = nums.size();
    int l = 0, r = 0;
    long sum = nums.get(l);

    while (r < n && l <= r) {
      if (sum == givenSum) {
        int[] ans = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
          ans[i - l] = nums.get(i);
        }
        return ans;
      } else if (sum < givenSum) {
        r++;
        if (r < n) {
          sum += nums.get(r);
        }
      } else {
        sum -= nums.get(l);
        l++;
      }
    }

    int ans[] = new int[1];
    ans[0] = -1;
    return ans;
  }

  private static int sumUpto(ArrayList<Integer> nums, int i, int j) {
    int totalSum = 0;
    for (int k = 0; k <= j; k++) {
      totalSum += nums.get(k);
    }
    return totalSum;
  }

  public static ArrayList<Integer> solve(ArrayList<Integer> nums, int k) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (k <= 0) {
      solList.add(-1);
      return solList;
    }

    Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

    insert(hashMap, 0, -1);

    int currSum = 0;

    // 1, 2, 3, 4, 5
    for (int index = 0; index < nums.size(); index++) {
      currSum += nums.get(index);

      if (hashMap.containsKey(currSum - k)) {
        solList = hashMap.get(currSum - k);
        break;
      }

      insert(hashMap, currSum, index);
    }

    return solList;
  }

  private static void insert(Map<Integer, ArrayList<Integer>> hashMap, Integer key, Integer value) {
    hashMap.putIfAbsent(key, new ArrayList<>());
    hashMap.get(key).add(value);

    for (int k : hashMap.keySet()) {
      System.out.println(k + ", " + hashMap.get(k));
    }
    System.out.println("-----------");
  }

}
