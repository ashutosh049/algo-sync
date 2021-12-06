package com.scalar.classroom.day21_mathss_basics;

import com.util.Util;
import java.util.ArrayList;

/**
 * <h3>Rearrange Array</h3>
 * <pre>
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 *  Lets say N = size of the array. Then, following holds true :
 *
 * 1.All elements in the array are in the range [0, N-1]
 * 2.N * N does not overflow for a signed integer</pre>
 */
public class RearrangeTheArray {

  public static void main(String[] args) {
    int[] arr = new int[]{3, 2, 0, 1};
    ArrayList<Integer> A = new ArrayList<>();

    for (int d : arr) {
      A.add(d);
    }

    arrange(A);
    System.out.println("After reaaranging::");
    Util.printArrayList(A);
  }

  public static void arrange(ArrayList<Integer> a) {

    int n = a.size();

    if (n > 1) {

      for (int i = 0; i < n; i++) {
        int curVal = a.get(i);
        int newVal = (a.get(curVal) % n) * n;
        a.set(i, curVal + newVal);
      }

      for (int i = 0; i < n; i++) {
        int newVal = a.get(i) / n;
        a.set(i, newVal);
      }
    }

  }

  public void solve(ArrayList<Integer> A) {
    int n = A.size();
    for (int i = 0; i < n; i++) {
      A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n);
    }
    for (int i = 0; i < n; i++) {
      A.set(i, A.get(i) / n);
    }
  }
}
