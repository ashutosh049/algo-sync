package com.scalar.classroom.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PerfectCards {

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();

    int[] ipIntegers = new int[]{1, 2};
    for (int i : ipIntegers) {
      nums.add(i);
    }
    System.out.println("--- solve_GFG ----");
    String res = solve(nums);
    System.out.println(res);
  }

  public static String solve(ArrayList<Integer> A) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < A.size(); i++) {
      map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
    }

    if (map.size() == 2) {
      Set<Integer> values = new HashSet<Integer>(map.values());
      if(values.size() ==1)
        return "WIN";
    }

    return "LOSE";
  }

}
