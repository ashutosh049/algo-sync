package com.scalar.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>Nearest Minimum Of Minimums
 *
 * Given an integer array A of size N, return the shortest distance between the the minimum element that appread atleast twice.
 *
 * Example 1
 * A[2, 1, 1, 2, 3, 4]
 * output: 1
 * elements appearing twice are: 2 and 1, minimum element among this is 1, and shortest distance is index 2-1=1
 *
 * Example 2
 * A[10000, 10000, 1, 2, 3, 4, 5, 6, 7, 1]
 * output: 7
 * elements appearing twice are: 10000 and 1, minimum element among this is 1, and shortest distance is index 9-2=7
 *
 * Example 3
 * A[1,1]
 * output: 1
 * elements appearing twice is: 1, minimum element among this is 1, and shortest distance is index 1-0=1
 *
 * Example 4
 * A[10, 10, 1, 20, 20, 1]
 * output: 3
 * elements appearing twice are: 10,1,20, minimum element among this is 1, and shortest distance is index 5-2=3</pre>
 */
public class MinDistance {

  public static void main(String[] args) {
    MinDistance obj = new MinDistance();

    System.out.println("min dis: " + obj.solve_2(new int[]{2, 1, 1, 2, 3, 4}));
    System.out.println("min dis: " + obj.solve_2(new int[]{10000, 10000, 1, 2, 3, 4, 5, 6, 7, 1}));
    System.out.println("min dis: " + obj.solve_2(new int[]{10, 10, 1, 20, 20, 1}));
    System.out.println("min dis: " + obj.solve_2(new int[]{10, 10, 1, 20, 20, 1, 1}));
    System.out.println("min dis: " + obj.solve_2(new int[]{1, 1}));

    System.out.println("min dis: " + obj.solve_editorial(new int[]{2, 1, 1, 2, 3, 4}));
    System.out.println("min dis: " + obj.solve_editorial(new int[]{10000, 10000, 1, 2, 3, 4, 5, 6, 7, 1}));
    System.out.println("min dis: " + obj.solve_editorial(new int[]{10, 10, 1, 20, 20, 1}));
    System.out.println("min dis: " + obj.solve_editorial(new int[]{10, 10, 1, 20, 20, 1, 1}));
    System.out.println("min dis: " + obj.solve_editorial(new int[]{1, 1}));

  }

  public int solve_2(int[] A) {

    // Map with key as element and value as last occurance index
    Map<Integer, Integer> freqMap = new HashMap<>();
    int minElement = Integer.MAX_VALUE;
    int minDis = Integer.MAX_VALUE;

    for (int i = 0; i < A.length; i++) {
      //we only need take care of elements that occured at-least twice
      if (freqMap.containsKey(A[i])) {
        //If a new minimum arrives, discard previous min-distance.
        if (minElement > A[i]) {
          minDis = Integer.MAX_VALUE;
          minElement = A[i];
          int lastIndx = freqMap.get(A[i]);
          int curDis = i - lastIndx;
          if (curDis < minDis) {
            minDis = curDis;
          }
        }
        //If a minimum arrives at different location
        else if (minElement == A[i]) {
          minElement = A[i];
          int lastIndx = freqMap.get(A[i]);
          int curDis = i - lastIndx;
          if (curDis < minDis) {
            minDis = curDis;
          }
        }
      }
      freqMap.put(A[i], i);
    }

    return minDis;
  }

  public int solve(int[] A) {

    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      int count_ = 0;
      if (freqMap.containsKey(A[i])) {
        count_ += freqMap.get(A[i]);
      }
      freqMap.put(A[i], count_ + 1);
    }

    List<Integer> duplicateList = new ArrayList<>();
    for (int i : freqMap.keySet()) {
      if (freqMap.get(i) >= 2) {
        duplicateList.add(i);
      }
    }

    Map<Integer, Distance> distanceMap = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      if (duplicateList.contains(A[i])) {
        Distance dis = distanceMap.get(A[i]);
        if (dis == null) {
          dis = new Distance(i, i, Integer.MAX_VALUE);
        } else {
          int preDistance = dis.getDis();
          int newDistance = calDistance(dis.getJ(), i);
          if (preDistance > newDistance) {
            dis = new Distance(dis.getJ(), i, newDistance);
          }
        }
        distanceMap.put(A[i], dis);
      }

    }

    Map<Integer, Distance> distanceMapWithSmallest = new HashMap<>();
    int minElm = Integer.MAX_VALUE;

    for (int i : distanceMap.keySet()) {
      if (minElm > i) {
        distanceMapWithSmallest.remove(minElm);
        minElm = i;
        distanceMapWithSmallest.put(i, distanceMap.get(i));
      }
    }

    int minDis = Integer.MAX_VALUE;

    for (int i : distanceMapWithSmallest.keySet()) {
      if (distanceMapWithSmallest.get(i).getDis() < minDis) {
        minDis = distanceMapWithSmallest.get(i).getDis();
      }
    }
    return minDis;
  }

  private int calDistance(int i, int j) {
    return Math.abs(i - j);
  }

  int solve_editorial(int[] A) {
    int n = A.length;
    long minn = Long.MAX_VALUE;
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (A[i] < minn) {
        minn = A[i];
      }
    }
    int flag = 0;
    for (int i = 0; i < n; i++) {
      if (A[i] == minn) {
        flag = i;
        break;
      }
    }
    for (int i = flag + 1; i < n; i++) {
      if (A[i] == minn) {
        ans = Math.min(i - flag, ans);
        flag = i;
      }
    }
    return ans;
  }

  class Distance {

    int i;
    int j;
    int dis;

    public Distance(int i, int j, int dis) {
      this.i = i;
      this.j = j;
      this.dis = dis;
    }

    public int getDis() {
      return this.dis;
    }

    public int getI() {
      return this.i;
    }

    public int getJ() {
      return this.i;
    }
  }
}
