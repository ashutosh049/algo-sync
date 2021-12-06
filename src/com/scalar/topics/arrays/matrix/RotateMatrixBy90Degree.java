package com.scalar.topics.arrays.matrix;

import com.util.Util;
import java.util.ArrayList;

/**
 * <pre>Rotate Matrix
 * Problem Description
 *
 * You are given a n x n 2D matrix A representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note: If you end up using an additional array, you will only receive partial score.
 *
 *
 *
 * Problem Constraints
 * 1 <= n <= 1000
 *
 *
 *
 * Input Format
 * First argument is a 2D matrix A of integers
 *
 *
 *
 * Output Format
 * Return the 2D rotated matrix.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  [
 *     [1, 2],
 *     [3, 4]
 *  ]
 * Input 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [3, 1],
 *     [4, 2]
 *  ]
 * Output 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  After rotating the matrix by 90 degree:
 *  1 goes to 2, 2 goes to 4
 *  4 goes to 3, 3 goes to 1
 * Explanation 2:
 *
 *  2D array remains the ssame as there is only element.</pre>
 */
public class RotateMatrixBy90Degree {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> matrix = createMatrix();

    //------------------------------------------------------------------
    Util.printArrayListMatrix(matrix);
    solve(matrix);
    System.out.println("----solution arraylist----");
    Util.printArrayListMatrix(matrix);
    //------------------------------------------------------------------
    int[][] matrixArray = new int[3][3];
    int count = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrixArray[i][j] = count++;
      }
    }
    System.out.println("----Solution :: 2D Integer Array----");
    transpose(matrixArray);
    System.out.println("----Solution :: Transpose 2D Integer Array----");
    Util.printMatrixArray(matrixArray);
    System.out.println("----Solution :: Reverse 2D Integer Array----");
    reverse(matrixArray);
    Util.printMatrixArray(matrixArray);
    //------------------------------------------------------------------
    matrix = createMatrix();
    transpose(matrix);
    reverse(matrix);
    System.out.println("----solution arraylist transpose/reverse----");
    Util.printArrayListMatrix(matrix);
  }

  public static void solve(ArrayList<ArrayList<Integer>> list) {

    int n = list.size();

    for (int level = 0; level < n / 2; level++) {

      for (int y = level; y < n - level - 1; y++) {

        int temp = list.get(level).get(y);

        list.get(level).set(y, list.get(n - 1 - y).get(level));

        list.get(n - 1 - y).set(level, list.get(n - 1 - level).get(n - 1 - y));

        list.get(n - 1 - level).set(n - 1 - y, list.get(y).get(n - 1 - level));

        list.get(y).set(n - 1 - level, temp);

      }
    }
  }

  private static void transpose(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
  }

  private static void reverse(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = tmp;
      }
    }
  }

  private static void transpose(ArrayList<ArrayList<Integer>> matrix) {
    int n = matrix.size();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix.get(j).get(i);
        matrix.get(j).set(i, matrix.get(i).get(j));
        matrix.get(i).set(j, tmp);
      }
    }
  }

  private static void reverse(ArrayList<ArrayList<Integer>> matrix) {
    int n = matrix.size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix.get(i).get(j);
        matrix.get(i).set(j, matrix.get(i).get(n - j - 1));
        matrix.get(i).set(n - j - 1, tmp);
      }
    }
  }

  private static ArrayList<ArrayList<Integer>> createMatrix(){
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
}
