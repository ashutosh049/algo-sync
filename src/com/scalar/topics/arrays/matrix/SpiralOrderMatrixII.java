package com.scalar.topics.arrays.matrix;

import static com.util.Util.printArrayListMatrix;

import com.util.Util;
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
public class SpiralOrderMatrixII {

  public static void main(String[] args) {

    int a = 4;

    ArrayList<ArrayList<Integer>> matrix = generateMatrix(a);
    System.out.println("-----Solution-------");
    printArrayListMatrix(matrix);

  }

  public static ArrayList<ArrayList<Integer>> generateMatrix(int num) {

    ArrayList<ArrayList<Integer>> a = new ArrayList<>();

    int i, j;

    for (i = 0; i < num; i++) {
      a.add(new ArrayList<Integer>());
    }
    printArrayListMatrix(a);

    for (i = 0; i < num; i++) {
      for (j = 0; j < num; j++) {
        a.get(i).add(0);
      }
    }

    printArrayListMatrix(a);

    a.get(0).set(0, 1);

    printArrayListMatrix(a);

    int row = 0, col = 0, layer = 0, dir = 0;

    System.out.println("---iterating---");
    for (i = 1; i < num * num; i++) {
      switch (dir) {
        case 0:
          if (col == num - layer - 1) {
            row++;
            dir = 1;
          } else {
            col++;
          }
          printArrayListMatrix(a);
          break;
        case 1:
          if (row == num - layer - 1) {
            col--;
            dir = 2;
          } else {
            row++;
          }
          printArrayListMatrix(a);
          break;
        case 2:
          if (col == layer) {
            row--;
            dir = 3;
          } else {
            col--;
          }
          printArrayListMatrix(a);
          break;
        case 3:
          if (row == layer + 1) {
            layer++;
            dir = 0;
            col++;
          } else {
            row--;
          }
          printArrayListMatrix(a);
          break;
      }

      a.get(row).set(col, i + 1);

    }

    return a;
  }
}