package com.scalar.topics.arrays.TwoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairWithGivenDifference {

  public static void main(String[] args) {
    Integer[] arr = new Integer[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322};

    int count = solve(Arrays.asList(arr), 369);
    System.out.println("Total count = " + count + "\n");

    int count1 = solve1(Arrays.asList(arr), 369);
    System.out.println("Total count = " + count1);
  }

  public static int solve(List<Integer> arr, int k) {

    int found = 0;
    int i = 0;
    int j = arr.size() - 1;

    //Arrays.sort(arr);
    Collections.sort(arr);
    int counter = 0;
    /*for (Integer integer : arr) {
      System.out.println("i[" + i + "]" + arr.get(i) + ", j[" + j + "]" + arr.get(j) + "");
    }*/
    System.out.println();

    /**
     * [0]-855 [1]-847 [2]-708 [3]-701 [4]-666 [5]-618 [6]-609 [7]-536 [8]-533 [9]-509 [10]-500
     * [11]-396 [12]-297 [13]-284 [14]-229 [15]-173 [16]-173 [17]-38 [18]-5 [19]35 [20]169
     * [21]281 [22]322 [23]358 [24]421 [25]436 [26]447 [27]478 [28]538 [29]667 [30]705
     * [31]718 [32]724 [33]726 [34]811 [35]869 [36]894 [37]895 [38]902 [39]912 [40]942
     * [41]961
     */

    int start = 0;
    int end = 1;
    while (start < arr.size() && end < arr.size()) {
      int diff = arr.get(end) - arr.get(start);
      if (diff == k && start != end) {
        return 1;
      } else if (diff < k) {
        end++;
      } else {
        start++;
      }
    }
    return 0;

   /* while (i < j) {
      int a1 = arr.get(i);
      int a2 = arr.get(j);
      int diff1 = a1-a2;
      int diff2 = a2-a1;
      if (diff1 == k) {
        found = 1;
        break;
      } else if (diff1 > k ) {
        j--;
      } else {
        i++;
      }
    }*/

    //return found;
  }

  public static int solve1(List<Integer> arr, int k) {

    int found = 0;

    for (int i = 0; i < arr.size(); i++) {
      for (int j = i; j < arr.size(); j++) {
        if (arr.get(i) - arr.get(j) == k || arr.get(j) - arr.get(i) == k) {
          found = 1;
          System.out.println(
              "Pair found at i[" + i + "]" + arr.get(i) + ", j[" + j + "]" + arr.get(j) + "");
          break;
        }
      }
    }

    return found;
  }
}