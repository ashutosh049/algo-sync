package com.scalar.classroom.day12;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayWithGivenSum {

  public static int subarraySum(int[] nums, int k) {
    int count = 0;

    for (int start = 0; start < nums.length; start++) {
      int sum = 0;
      for (int end = start; end < nums.length; end++) {
        sum += nums[end];
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }

  public static int subarraySumMap(int[] nums, int k) {
    int count = 0, sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public ArrayList<Integer> solve(ArrayList<Integer> nums, int k) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (k <= 0) {
      solList.add(-1);
      return solList;
    }

    for (int i = 0; i < nums.size(); i++) {
      int sum = 0;

      for (int j = i; j < nums.size(); j++) {
        sum += nums.get(j);
        solList.add(nums.get(j));
        if (sum == k) {
          return solList;
        }
      }

      solList = new ArrayList<>();

    }

    if (solList.size() <= 0) {
      solList.add(-1);
    }

    return solList;

  }

  /*public ArrayList<Integer> solve_map(ArrayList<Integer> nums, int k) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (k >= 1) {
      int count = 0, sum = 0;

      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

      map.put(0, 1);

      for (int i = 0; i < nums.size(); i++) {
        sum += nums.get(i);
        solList.add(nums.get(i));

        if (map.containsKey(sum - k)) {
          count += map.get(sum - k);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    if (solList.size() <= 0) {
      solList.add(-1);
    }

    return solList;

  }*/
}