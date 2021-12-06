package com.scalar.topics.arrays.matrix;

import com.util.Util;
import java.util.ArrayList;

/**
 * <pre>Anti Diagonals
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 *
 * Example:
 *
 * Input:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Return the following :
 *
 * [
 *   [1],
 *   [2, 4],
 *   [3, 5, 7],
 *   [6, 8],
 *   [9]
 * ]
 * Input :
 * 1 2
 * 3 4
 *
 * Return the following  :
 *
 * [
 *   [1],
 *   [2, 3],
 *   [4]
 * ]</pre>
 */
public class TraverseMatrixByAntiDiagonal {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> matrix = createMatrix();

    //------------------------------------------------------------------
    Util.printArrayListMatrix(matrix);
    matrix = antiDiagonalTraverse(matrix);
    System.out.println("----solution Anti-Diagonal Traversing----");
    Util.printArrayListMatrix(matrix);

  }

  private static ArrayList<ArrayList<Integer>> createMatrix() {
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    ArrayList<Integer> arr0 = new ArrayList<>();
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    arr0.add(1);
    arr0.add(2);
    arr0.add(3);
    arr1.add(4);
    arr1.add(5);
    arr1.add(6);
    arr2.add(7);
    arr2.add(8);
    arr2.add(9);
    matrix.add(arr0);
    matrix.add(arr1);
    matrix.add(arr2);
    return matrix;
  }

  private static ArrayList<ArrayList<Integer>> antiDiagonalTraverse(
      ArrayList<ArrayList<Integer>> matrix) {
    int n = matrix.size();

    int colFirst = 0;
    int colLast = matrix.get(0).size();

    ArrayList<ArrayList<Integer>> antiDiagonalList = new ArrayList<>();
    for (int i = colFirst; i < colLast; i++) {
      ArrayList<Integer> diagonalList = new ArrayList<>();
      int row = 0;
      int col = i;
      while (isValidRow(row, matrix) && isValidCol(col, matrix)) {
        int data = matrix.get(row).get(col);
        diagonalList.add(data);
        row++;
        col--;
      }
      antiDiagonalList.add(diagonalList);
    }
    return antiDiagonalList;
  }

  private static boolean isValidRow(int rowNum, ArrayList<ArrayList<Integer>> matrix) {
    return rowNum >= 0 && rowNum < matrix.size();
  }

  private static boolean isValidCol(int colNum, ArrayList<ArrayList<Integer>> matrix) {
    return colNum >= 0 && colNum < matrix.get(0).size();
  }


}
