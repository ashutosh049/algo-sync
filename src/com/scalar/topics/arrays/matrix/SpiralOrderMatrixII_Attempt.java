package com.scalar.topics.arrays.matrix;

import static com.util.Util.printArrayListMatrix;

import java.util.ArrayList;

/**
 * <pre>Given an integer A, generate a square matrix filled with elements from 1 to A^2 in spiral order.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains an integer, A.
 * Output Format:
 *
 * Return a 2-d matrix of size A x A satisfying the spiral order.
 * Constraints:
 *
 * 1 <= A <= 1000
 * Examples:
 *
 * Input 1:
 *     A = 3
 *
 * Output 1:
 *     [   [ 1, 2, 3 ],
 *         [ 8, 9, 4 ],
 *         [ 7, 6, 5 ]   ]
 *
 * Input 2:
 *     4
 *
 * Output 2:
 *     [   [1, 2, 3, 4],
 *         [12, 13, 14, 5],
 *         [11, 16, 15, 6],
 *         [10, 9, 8, 7]   ]</pre>
 */
public class SpiralOrderMatrixII_Attempt {

  public static void main(String[] args) {

    int a = 3;

    ArrayList<ArrayList<Integer>> matrix = generateMatrix(a);
    System.out.println("-----Solution-------");
    printArrayListMatrix(matrix);

  }

  public static ArrayList<ArrayList<Integer>> generateMatrix(int num) {

    ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>();

    //1.Create and initialize a num x num matrix with 0's
    for (int i = 0; i < num; i++) {
      ArrayList<Integer> dataList = new ArrayList<>();
      for (int j = 0; j < num; j++) {
        dataList.add(0);
      }
      spiralMatrix.add(dataList);
    }

    int top = 0;
    int bottom = spiralMatrix.size() - 1;
    int left = 0;
    int right = spiralMatrix.get(0).size() - 1;
    int dir = 0;
    int counter = 1;

    while (top <= bottom && left <= right && counter <= num * num) {
      if (dir == 0) {
        for (int i = left; i <= right; i++) {
          spiralMatrix.get(top).set(i, counter++);
        }
        top++;
      } else if (dir == 1) {
        for (int i = top; i <= bottom; i++) {
          spiralMatrix.get(i).set(right, counter++);
        }
        right--;
      } else if (dir == 2) {
        for (int i = right; i >= left; i--) {
          spiralMatrix.get(bottom).set(i, counter++);
        }
        bottom--;
      } else if (dir == 3) {
        for (int i = bottom; i >= top; i--) {
          spiralMatrix.get(i).set(left, counter++);
        }
        left++;
      }
      dir = (dir + 1) % 4;
    }

    return spiralMatrix;
  }
}