package com.scalar.topics.arrays.matrix;

import com.util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example:
 *
 * Given the following matrix:
 *
 * [
 *     [ 1, 2, 3 ],
 *     [ 4, 5, 6 ],
 *     [ 7, 8, 9 ]
 * ]
 * You should return
 *
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * Problem Approach :
 *
 * Complete solution in the hints.</pre>
 */
public class SpiralOrderMatrixI {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>();
    ArrayList<Integer> arr0 = new ArrayList<>();
    arr0.add(1);
    arr0.add(2);
    arr0.add(3);
    ArrayList<Integer> arr1 = new ArrayList<>();
    arr1.add(4);
    arr1.add(5);
    arr1.add(6);
    ArrayList<Integer> arr2 = new ArrayList<>();
    arr2.add(7);
    arr2.add(8);
    arr2.add(9);
    spiralMatrix.add(arr0);
    spiralMatrix.add(arr1);
    spiralMatrix.add(arr2);

    Util.printArrayListMatrix(spiralMatrix);

    ArrayList<Integer> spiralList = readSpiralOrder(spiralMatrix);

    System.out.println("----solution----");
    Util.printArrayList(spiralList);

  }

  /**
   * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
   * <p>
   * You should return:  [1, 2, 3, 6, 9, 8, 7, 4, 5]
   *
   * @param spiralMatrix
   * @return
   */
  public static ArrayList<Integer> readSpiralOrder(final List<ArrayList<Integer>> spiralMatrix) {
    ArrayList<Integer> solList = new ArrayList<>();

    int top, bottom, left, right;
    top = 0;
    bottom = spiralMatrix.size() - 1;
    left = 0;
    right = spiralMatrix.get(0).size() - 1;
    int dir = 0;

    while (top <= bottom && left <= right) {
      if (dir == 0) {
        for (int i = left; i <= right; i++) {
          solList.add(spiralMatrix.get(top).get(i));
        }
        top++;
      } else if (dir == 1) {
        for (int i = top; i <= bottom; i++) {
          solList.add(spiralMatrix.get(i).get(right));
        }
        right--;
      } else if (dir == 2) {
        for (int i = right; i >= left; i--) {
          solList.add(spiralMatrix.get(bottom).get(i));
        }
        bottom--;
      } else if (dir == 3) {
        for (int i = bottom; i >= top; i--) {
          solList.add(spiralMatrix.get(i).get(left));
        }
        left++;
      }
      dir = (dir + 1) % 4;
    }

    return solList;

  }

}