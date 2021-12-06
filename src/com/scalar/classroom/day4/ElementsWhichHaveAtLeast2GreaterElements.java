package com.scalar.classroom.day4;

import java.util.ArrayList;
import java.util.List;

public class ElementsWhichHaveAtLeast2GreaterElements {

  public static void main(String[] args) {
    int[] Arr = new int[]{0, 1, -1};
    //int[] Arr = new int[]{1, 2, 3, 4, 5};
    //int[] Arr = new int[]{0, 10101, -1010101};

    findfirst2Min(Arr);
    System.out.println();
    findfirst2Max(Arr);

    System.out.println("\n---output--------\n");
    for (int a : solve(Arr)) {
      System.out.print(a + ", ");
    }


  }

  /**
   *
   * @param Arr
   */
  static void findfirst2Min(int[] Arr) {
    int min1 = Arr[0];
    int min2 = Arr[1];
    for (int i = 0; i <= Arr.length - 1; i++) {
      min1 = Math.min(min1, Arr[i]);
    }

    for (int i = 0; i <= Arr.length - 1; i++) {
      if (Arr[i] > min1) {
        min2 = Math.min(min2, Arr[i]);
      }
    }
    System.out.println("min1:" + min1);
    System.out.println("min2:" + min2);
  }

  /**
   *
   * @param Arr
   */
  static void findfirst2Max(int[] Arr) {
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    for (int i = 0; i <= Arr.length - 1; i++) {
      max1 = Math.max(max1, Arr[i]);
    }

    for (int i = 0; i <= Arr.length - 1; i++) {
      if (Arr[i] < max1) {
        max2 = Math.max(max2, Arr[i]);
      }
    }

    if(max2 == Integer.MAX_VALUE){

    }
    System.out.println("max1:" + max1);
    System.out.println("max2:" + max2);
  }

  public static int[] solve(int[] Arr) {
    List<Integer> solArrList = new ArrayList<>();

    if (Arr.length > 2) {
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;

      for (int i = 0; i <= Arr.length - 1; i++) {
        max1 = Math.max(max1, Arr[i]);
      }

      for (int i = 0; i <= Arr.length - 1; i++) {
        if (Arr[i] < max1) {
          max2 = Math.max(max2, Arr[i]);
        }
      }

      for (int i = 0; i <= Arr.length - 1; i++) {
        if (Arr[i] < max1 && Arr[i] < max2) {
          solArrList.add(Arr[i]);
        }
      }
    }

    int[] solArr = new int[solArrList.size()];
    for (int i = 0; i < solArrList.size(); i++) {
      solArr[i] = solArrList.get(i);
    }

    return solArr;
  }

  static int findMin(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }

  static int findMax(int a, int b, int c) {
    return Math.max(Math.max(a, b), c);
  }

}
