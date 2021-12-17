package com.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Util {

  public static void printArrayWithIndices(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print("[" + i + "]" + arr[i] + " ");
    }
    System.out.println();
  }

  public static void printArrayWithIndices(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print("[" + i + "]" + arr[i] + " ");
    }
    System.out.println();
  }

  public static void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("]");
  }

  public static void printArray(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void printMatrixArray(int[][] matrixArray) {
    System.out.println("[");
    for (int i = 0; i < matrixArray.length; i++) {
      System.out.print("\t[");
      int[] innerArray = matrixArray[i];
      for (int j = 0; j < innerArray.length; j++) {
        System.out.print(innerArray[j]);
        if (j < innerArray.length - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < matrixArray.length - 1) {
        System.out.println(",");
      }
    }
    System.out.println("\n]");
  }

  public static void printArrayList(ArrayList<Integer> list) {
    System.out.print("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i < list.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void printArrayList(List<Integer> list) {
    System.out.print("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i < list.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void printArrayListString(List<String> list) {
    System.out.print("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i < list.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public static void printArrayListMatrix(ArrayList<ArrayList<Integer>> list) {
    System.out.println("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print("\t[");
      ArrayList<Integer> innerList = list.get(i);
      for (int j = 0; j < innerList.size(); j++) {
        System.out.print(innerList.get(j));
        if (j < innerList.size() - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < list.size() - 1) {
        System.out.println(",");
      }
    }
    System.out.println("\n]");
  }

  public static void printArrayListMatrix(List<List<Integer>> list) {
    System.out.println("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print("\t[");
      List<Integer> innerList = list.get(i);
      for (int j = 0; j < innerList.size(); j++) {
        System.out.print(innerList.get(j));
        if (j < innerList.size() - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < list.size() - 1) {
        System.out.println(",");
      }
    }
    System.out.println("\n]");
  }

  public static void printArrayListOfIntArray(List<int[]> list) {
    System.out.println("[");
    for (int i = 0; i < list.size(); i++) {
      System.out.print("\t[");
      int[] arr = list.get(i);
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[j]);
        if (j < arr.length - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < list.size() - 1) {
        System.out.println(",");
      }
    }
    System.out.println("\n]");
  }

  public static ArrayList<ArrayList<Integer>> createMatrix(int row, int col) {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    int counter = 0;
    for (int i = 0; i < row; i++) {
      ArrayList<Integer> dataList = new ArrayList<>();
      for (int j = 0; j < col; j++) {
        dataList.add(++counter);
      }
      matrix.add(dataList);
    }
    return matrix;
  }

  public static void printMap(Map<Integer, Integer> map) {
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      Integer entryValue = entry.getValue();
      System.out.println("[" + entry.getKey() + ", " + entryValue + "]");
    }
  }

  void test() {

    List<Integer> a = new ArrayList<>();
    List<Integer> b = new LinkedList<>();
    List<Integer> c = new Stack<>();

  }

}
