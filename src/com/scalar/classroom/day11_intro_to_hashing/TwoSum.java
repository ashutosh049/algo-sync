package com.scalar.classroom.day11_intro_to_hashing;

import com.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(
        new Integer[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3,
            -5, 4, -7, 7, 9, -4, 4, -8});

    ArrayList<Integer> solList = twoSum(list, -3);
    System.out.println("solList 1::");
    Util.printArrayList(solList);


    solList = twoSum_1(list, -3);
    System.out.println("solList 2::");
    Util.printArrayList(solList);


  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

    ArrayList<Integer> solList = new ArrayList<>();

    Map<Integer, IndexHolder> indxHolderMap = new HashMap<>();

    if (A != null && A.size() >= 1) {
      int n = A.size();
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (ifFound(A, i, j, B)) {
            System.out.println("Found :: [" + (i + 1) + "][" + (j + 1) + "]");

            IndexHolder holderObj = indxHolderMap.get(j + 1);
            if (holderObj == null) {
              holderObj = new IndexHolder(i + 1, j + 1);
            } else {
              if (i < holderObj.getI()) {
                holderObj = new IndexHolder(i + 1, j + 1);
              }
            }
            indxHolderMap.put(j + 1, holderObj);
            //break;
          }
        }
      }

      System.out.println("holder obj map::");
      for (Map.Entry<Integer, IndexHolder> entry : indxHolderMap.entrySet()) {
        IndexHolder entryValue = (IndexHolder) entry.getValue();
        System.out.println("i = " + entry.getKey() +
            ", Value = [" + entryValue.getI() + "," + entryValue.j + "]");
      }

      int minIndexI = Integer.MAX_VALUE;
      if (indxHolderMap.size() >= 1) {
        for (Map.Entry<Integer, IndexHolder> entry : indxHolderMap.entrySet()) {
          if (entry.getKey() < minIndexI) {
            minIndexI = entry.getKey();
          }
        }
      }

      if (minIndexI != Integer.MAX_VALUE) {
        IndexHolder minHolderObj = indxHolderMap.get(minIndexI);
        solList.add(minHolderObj.getI());
        solList.add(minHolderObj.getJ());
      }

    }
    return solList;
  }

  private static boolean ifFound(final List<Integer> A, int i, int j, int B) {
    int n = A.size();
    return (A.get(i) + A.get(j)) == B;
  }

  public static ArrayList<Integer> twoSum_1(final List<Integer> A, int B) {

    ArrayList<Integer> solList = new ArrayList<>();

    IndexHolder minHolderObj = new IndexHolder(Integer.MAX_VALUE, Integer.MAX_VALUE);

    if (A != null && A.size() >= 1) {
      int n = A.size();
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (ifFound(A, i, j, B)) {
            if (minHolderObj.getJ() > (j + 1)) {
              minHolderObj = new IndexHolder(i + 1, j + 1);
            } else if (minHolderObj.getJ() == (j + 1) && minHolderObj.getI() > (i + 1)) {
              minHolderObj = new IndexHolder(i + 1, j + 1);
            }
          }
        }
      }

    }

    solList.add(minHolderObj.getI());
    solList.add(minHolderObj.getJ());
    return solList;
  }

  private static class IndexHolder {

    private int i;
    private int j;

    public IndexHolder(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public IndexHolder() {
    }

    public int getI() {
      return this.i;
    }

    public int getJ() {
      return this.j;
    }

  }
}
