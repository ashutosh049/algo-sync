package com.codeforces.edu.round_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Longest_k_Good_Segment {
  public static void main(String[] args) throws IOException {
    //
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().trim().split(" ");
    int n = Integer.valueOf(inputs[0]);
    int k = Integer.valueOf(inputs[1]);

    String[] arrElements = br.readLine().trim().split(" ");

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.valueOf(arrElements[i]);
    }

    findKGoodLengthSegmentIndices(arr, k);
  }

  /**
   * k different elements
   *
   * @param arr
   * @param k
   */
  private static void findKGoodLengthSegmentIndices(int[] arr, int k) {

    int n = arr.length;
    int maxKGoodLength = Integer.MIN_VALUE;
    int start = 0;
    int end = 0;

    for (int i = 0; i < n; i++) {
      Map<Integer, ArrayPairIndex> pairIndexMap = new HashMap<>();

      int j = i;

      while (j < n && pairIndexMap.size() <= k) {
        if (pairIndexMap.containsKey(arr[j]) || pairIndexMap.size() < k) {
          pairIndexMap.put(arr[j], new ArrayPairIndex(i + 1, j + 1));

          ArrayPairIndex arrayPairIndex = pairIndexMap.get(arr[j]);

          int curGoodLength = arrayPairIndex.getEnd() - arrayPairIndex.getStart() + 1;

          if (curGoodLength > maxKGoodLength) {
            start = arrayPairIndex.getStart();
            end = arrayPairIndex.getEnd();
            maxKGoodLength = curGoodLength;
          }
          j++;
        } else {
          j++;
          break;
        }
      }
    }
    System.out.print(start + " " + end);
  }

    /**
     * k different elements
     *
     * @param arr
     * @param k
     */
    private static void findKGoodLengthSegmentIndices2(int[] arr, int k) {

        int n = arr.length;
        int maxKGoodLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        Map<Integer, ArrayPairIndex> pairIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            /*if (pairIndexMap.containsKey(arr[i]) || pairIndexMap.size() < k) {
                pairIndexMap.put(arr[i], new ArrayPairIndex(i + 1, j + 1));
            }*/
        }

        System.out.print(start + " " + end);
    }
}

class ArrayPairIndex {
  private int start;
  private int end;

  public ArrayPairIndex(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }
}
