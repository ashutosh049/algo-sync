package com.scalar.topics.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays ( The median of the array formed by merging both the
 * arrays ).
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOf2SortedArray {

  public static void main(String[] args) {

    List<Integer> a = Arrays.asList(new Integer[]{-50, -41, -40, -19, 5, 21, 28});
    List<Integer> b = Arrays.asList(new Integer[]{-50, -21, -10});

    double median = findMedianSortedArrays(a, b);

    System.out.println("median : " + median);

  }

  public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

    if (a.size() == 0 && b.size() == 0) {
      return 0;
    } else if (a.size() <= 0) {
      return getMedian(b);
    } else if (b.size() <= 0) {
      return getMedian(a);
    } else {
      int i = 0, j = 0;
      List<Integer> mergedList = new ArrayList<>();

      while (i < a.size() && j < b.size()) {
        if (a.get(i) < b.get(j)) {
          mergedList.add(a.get(i));
          i++;
        } else {
          mergedList.add(b.get(j));
          j++;
        }
      }

      while (i < a.size()) {
        mergedList.add(a.get(i));
        i++;
      }

      while (j < b.size()) {
        mergedList.add(b.get(j));
        j++;
      }

      for (int k = 0; k < mergedList.size(); k++) {
        System.out.print("["+mergedList.get(k) + "] ");
      }
      System.out.println();
      return getMedian(mergedList);
    }
  }

  private static double getMedian(final List<Integer> a) {
    int n = a.size();
    if (a.size() % 2 == 0) {
      return (double) (a.get((n - 1) / 2) + a.get(n / 2)) / 2.0;
    } else {
      return (double) (a.get(n / 2));
    }

  }
}
