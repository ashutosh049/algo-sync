package com.scalar.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChristmasTree {

  public static void main(String[] args) {

    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> B = new ArrayList<>();

    int[] hghtArray = new int[]{1, 6, 4, 2, 6, 9};
    int[] costArray = new int[]{2, 5, 7, 3, 2, 7};

    for (int d : hghtArray) {
      A.add(d);
    }

    for (int d : costArray) {
      B.add(d);
    }

    System.out.println("minCost 1: " + solve2(A, B));
    //----------------------
    A = new ArrayList<>();
    B = new ArrayList<>();

    hghtArray = new int[]{5, 6, 10, 4, 7, 8};
    costArray = new int[]{5, 6, 4, 7, 2, 5};

    for (int d : hghtArray) {
      A.add(d);
    }

    for (int d : costArray) {
      B.add(d);
    }
    System.out.println("minCost 2: " + solve2(A, B));
    //---------------------
    A = new ArrayList<>();
    B = new ArrayList<>();

    hghtArray = new int[]{100, 101, 100};
    costArray = new int[]{2, 4, 5};

    for (int d : hghtArray) {
      A.add(d);
    }

    for (int d : costArray) {
      B.add(d);
    }
    System.out.println("minCost 3: " + solve2(A, B));

    //---------------------
    A = new ArrayList<>();
    B = new ArrayList<>();

    hghtArray = new int[]{2, 4, 5, 4, 10};
    costArray = new int[]{40, 30, 20, 10, 40};

    for (int d : hghtArray) {
      A.add(d);
    }

    for (int d : costArray) {
      B.add(d);
    }
    System.out.println("minCost 4: " + solve2(A, B));
    //---------------------
    A = new ArrayList<>();
    B = new ArrayList<>();

    hghtArray = new int[]{ 1,  2,  3,  4,  5,  6,  7,  8,  9, 10};
    costArray = new int[]{10, 13, 11, 14, 15, 12, 13, 13, 18, 13};

    for (int d : hghtArray) {
      A.add(d);
    }

    for (int d : costArray) {
      B.add(d);
    }
    System.out.println("minCost 5: " + solve2(A, B));

  }

  public static int solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
    int minSum = Integer.MAX_VALUE;
    if (A != null && A.size() >= 1 && B != null && B.size() >= 1 && A.size() == B.size()) {
      int n = A.size();

      int mid = n / 2;

      for (int j = mid; j < n; j++) {

        int minLeft = Integer.MAX_VALUE;
        for (int i = j - 1; i >= 0; i--) {
          if (A.get(j) > A.get(i)) {
            minLeft = Math.min(minLeft, B.get(i));
          }
        }

        int minRight = Integer.MAX_VALUE;
        for (int k = j + 1; k < n; k++) {
          if (A.get(j) < A.get(k)) {
            minRight = Math.min(minRight, B.get(k));
          }
        }

        if (minLeft != Integer.MAX_VALUE && minRight != Integer.MAX_VALUE) {
          minSum = Math.min(minSum, (B.get(j) + minLeft + minRight));
        }

      }
    }

    if (minSum == Integer.MAX_VALUE) {
      minSum = -1;
    }

    return minSum;
  }

  public static int solve1(ArrayList<Integer> A, ArrayList<Integer> B) {
    int minSum = Integer.MAX_VALUE;
    if (A != null && A.size() >= 1 && B != null && B.size() >= 1 && A.size() == B.size()) {
      int n = A.size();
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          int curSum = 0;
          if (A.get(i) < A.get(j)) {
            for (int l = j + 1; l < n; l++) {
              curSum = B.get(i) + B.get(j) + B.get(l);
              if (A.get(j) < A.get(l)) {
                minSum = Math.min(minSum, curSum);
              }
            }
          }

        }
      }
    }

    if (minSum == Integer.MAX_VALUE) {
      minSum = -1;
    }

    return minSum;
  }

  public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int minCost = -1;

    if (A != null && A.size() >= 1 && B != null && B.size() >= 1 && A.size() == B.size()) {
      Map<Integer, Integer> heightValueMap = new TreeMap<>();

      int n = A.size();

      for (int i = 0; i < n; i++) {
        heightValueMap.put(A.get(i), B.get(i));
      }

      //Since we need to return the sum of cost of trees in strictly in increasing order of height,
      // we need to sort the trees per height and also need not change the pair
      // 1. We can either use TreeMap which provides guaranteed log(n) time
      // 2. use Arraylist to store keys and then sort he list and again put the keys in map

      // To find the min cont
      //Iterate over the cost array, i.e values of the map
      List<Integer> costList = new ArrayList(heightValueMap.values());
      int minSum = -1;

      int firstMin = Integer.MAX_VALUE;
      int firstMinIndx = 0;
      for (int i = 0; i < costList.size(); i++) {
        if (firstMin > costList.get(i)) {
          firstMin = costList.get(i);
          firstMinIndx = i;
        }
      }

      int secondMin = Integer.MAX_VALUE;
      int secondMinIndx = 0;
      for (int i = 0; i < costList.size(); i++) {
        if (secondMin > costList.get(i) && i != firstMinIndx) {
          secondMin = costList.get(i);
          secondMinIndx = i;
        }
      }

      int thirdMin = Integer.MAX_VALUE;
      int thirdMinIndx = 0;
      for (int i = 0; i < costList.size(); i++) {
        if (thirdMin > costList.get(i) && i != firstMinIndx && i != secondMinIndx) {
          thirdMin = costList.get(i);
          thirdMinIndx = i;
        }
      }

      if (firstMin != Integer.MAX_VALUE) {
      }
      minSum = firstMin + secondMin + thirdMin;

      return minSum;

    }

    return minCost;
  }

  public static int solve_slidingwindow(ArrayList<Integer> A, ArrayList<Integer> B) {
    int minSum = Integer.MAX_VALUE;
    int n = A.size();
    int curSum = 0;
    int k = 3;

    for (int i = 0; i < k; i++) {
      curSum += B.get(i);
    }

    for (int i = k; i < n; i++) {
      minSum = Math.min(minSum, curSum);
      System.out.println("1st: " + (i - k) + ", 2nd: " + i);
      curSum -= B.get(i - k);
      curSum += B.get(i);
    }

    return minSum;
  }

  public static int solve_kMinimumElements(ArrayList<Integer> A, ArrayList<Integer> B) {
    int minSum = -1;

    int firstMin = Integer.MAX_VALUE;
    int firstMinIndx = 0;
    for (int i = 0; i < B.size(); i++) {
      if (firstMin > B.get(i)) {
        firstMin = B.get(i);
        firstMinIndx = i;
      }
    }

    int secondMin = Integer.MAX_VALUE;
    int secondMinIndx = 0;
    for (int i = 0; i < B.size(); i++) {
      if (secondMin > B.get(i) && i != firstMinIndx) {
        secondMin = B.get(i);
        secondMinIndx = i;
      }
    }

    int thirdMin = Integer.MAX_VALUE;
    int thirdMinIndx = 0;
    for (int i = 0; i < B.size(); i++) {
      if (thirdMin > B.get(i) && i != firstMinIndx && i != secondMinIndx) {
        thirdMin = B.get(i);
        thirdMinIndx = i;
      }
    }

    if (firstMin != Integer.MAX_VALUE) {
    }
    minSum = firstMin + secondMin + thirdMin;

    return minSum;
  }

  public static int sumSubarraysOfLengthK(ArrayList<Integer> nums, int k) {
    int n = nums.size();
    int globalSum = 0;

    for (int i = 0; i < n; i++) {
      int curSum = 0;
      for (int j = i; j < n; j++) {
        curSum += nums.get(j);
        if ((j - i) % 2 == 0) {
          globalSum += curSum;
        }
      }
    }

    return globalSum;

  }
}
