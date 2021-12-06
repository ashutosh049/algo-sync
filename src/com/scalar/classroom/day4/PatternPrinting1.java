package com.scalar.classroom.day4;

import java.util.Arrays;

public class PatternPrinting1 {

  public static void main(String[] args) {

    System.out.println("\n---output--------\n");
    /*int[][] solveSol = solve(4);
    for (int i = 0; i < solveSol.length; i++) {
      for (int j = 0; j < solveSol[i].length; j++) {
        System.out.print(solveSol[i][j]+" ");
      }
      System.out.println();
    }*/

    for (int k = 1; k <= 4; k++) {
      int[][] outputArray = solve(k);
      //System.out.println("size::" + "[" + outputArray.length + "][" + outputArray[0].length + "]");
      print2DArray(outputArray);
      System.out.println("-----------------");
    }

  }

  public static int[][] solve1(int Arr) {
    int n = Arr;
    /*int[][] sol = new int[n][n];

    for (int i = 1; i <= n; i++) {
      int j = 1;
      int[] s = new int[i];
      while (j <= i) {
        s[j-1] = j;
        j+=1;
      sol[i-1] = s;
      }
    }*/

    int[][] sol = new int[n][n];

    for (int i = 1; i <= n; i++) {
      int j = 1;
      int[] s = new int[i];
      while (j <= i) {
        s[j - 1] = j;
        sol[i-1] = s;
        j += 1;
      }
    }
  //[1 ] [1 ] [1 ] [1 ]
    return sol;
  }

  /*public static int[][] solve(int Arr) {
    int n = Arr;

    int[][] sol = new int[n][1];

    for (int i = 1; i <= n; i++) {
      sol[i-1] = new int[i];
      for (int j = 1; j <= i ; j++) {
        sol[i-1][j-1] = j;
      }
    }

    return sol;
  }*/

  /**
   * 1
   * 1 2
   * 1 2 3
   * 1 2 3 4
   *----[n=4]------
   * 00
   * 10 11
   * 20 21 22
   * 30 31 32 33
   * -------------
   * @param Arr
   * @return
   */
  public static int[][] solve(int Arr) {
    int size = Arr;

    int[][] solArr = new int[size][1];
    int[] rowData = new int[size];

    for (int i = 0; i < size; i++) {
      rowData[i] = i+1;
    }

    //for a size of 4, rowData: [1, 2, 3, 4]

    for (int i = 0; i < size; i++) {
      solArr[i] = Arrays.copyOf(rowData, i+1);
    }

    return solArr;
  }

  //rowData[1, 2, 3, 4]
    /*for (int i = 0; i < n; i++) {
      int[] newRowData = new int[i+1];
      System.arraycopy(rowData, 0, newRowData, 0, i+1);
      solArr[i] = newRowData;
    }*/

  private static void print2DArray(int[][] outputArray) {
    for (int i = 0; i < outputArray.length; i++) {
      for (int j = 0; j < outputArray[i].length; j++) {
        System.out.print(outputArray[i][j] + " ");
      }
      System.out.println();
    }
  }
}
