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
class AntiDiagonalTraverse {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> matrix = Util.createMatrix(3, 3);

    //------------------test-case 1-------------------------------------
    Util.printArrayListMatrix(matrix);
    matrix = antiDiagonalTraverse(matrix);
    System.out.println("----solution Anti-Diagonal Traversing----");
    Util.printArrayListMatrix(matrix);

    //------------------test-case 2-------------------------------------
    matrix = Util.createMatrix(1, 1);
    Util.printArrayListMatrix(matrix);
    matrix = antiDiagonalTraverse(matrix);
    System.out.println("----solution Anti-Diagonal Traversing----");
    Util.printArrayListMatrix(matrix);

    //------------------test-case 3-------------------------------------
    matrix = Util.createMatrix(2, 2);
    Util.printArrayListMatrix(matrix);
    matrix = antiDiagonalTraverse(matrix);
    System.out.println("----solution Anti-Diagonal Traversing----");
    Util.printArrayListMatrix(matrix);

    //------------------test-case 4-------------------------------------
    matrix = Util.createMatrix(9, 9);
    Util.printArrayListMatrix(matrix);
    matrix = antiDiagonalTraverse(matrix);
    System.out.println("----solution Anti-Diagonal Traversing----");
    Util.printArrayListMatrix(matrix);

  }

  public static ArrayList<ArrayList<Integer>> antiDiagonalTraverse(
      ArrayList<ArrayList<Integer>> matrix) {

    if (matrix == null || matrix.size() == 0) {
      return new ArrayList<>();
    }

    int N = matrix.size();
    int M = matrix.get(0).size();

    // The two arrays as explained in the algorithm
    //int[] result = new int[N * M];
    ArrayList<ArrayList<Integer>> solList = new ArrayList<>();
    int k = 0;

    // We have to go over all the elements in the first
    // row and the last column to cover all possible diagonals
    for (int d = 0; d < N + M - 1; d++) {

      ArrayList<Integer> intermediate = new ArrayList<>();
      // We need to figure out the "head" of this diagonal
      // The elements in the first row and the last column
      // are the respective heads.
      int r = d < M ? 0 : d - M + 1;
      int c = d < M ? d : M - 1;

      // Iterate until one of the indices goes out of scope
      // Take note of the index math to go down the diagonal
      while (r < N && c > -1) {
        intermediate.add(matrix.get(r).get(c));
        ++r;
        --c;
      }
      solList.add(intermediate);
      /*for (int i = 0; i < intermediate.size(); i++) {
        result[k++] = intermediate.get(i);
      }*/
    }
    return solList;
  }
}