package com.scalar.classroom.day11_intro_to_hashing;

import com.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_OnePassHashTable {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(
        new Integer[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8});

    ArrayList<Integer> solList = twoSum(list, -3);
    System.out.println("solList::");
    Util.printArrayList(solList);

  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static ArrayList<Integer> twoSum(final List<Integer> nums, int target) {

    ArrayList<Integer> solList = new ArrayList<>();

    if (nums != null && nums.size() >= 1) {
      int n = nums.size();
      Map<Integer, Integer> indexMap = new HashMap<>();

      for (int i = 0; i < n; i++) {
        int complement = target - nums.get(i);// -3 -4 = -7

        if (indexMap.containsKey(complement)) {
          solList.add(indexMap.get(complement)+1);
          solList.add(i+1);
          return solList;
        }else if (!indexMap.containsKey(nums.get(i))) {
          indexMap.put(nums.get(i), i);
        }

        System.out.println("-----indexMap------");
        Util.printMap(indexMap);

      }

    }
    return solList;
  }

}
