package com.scalar.topics.arrays;

import static com.util.Util.printArrayList;
import static com.util.Util.printArrayListMatrix;

import java.util.ArrayList;

/**
 * <pre>Multiple left rotations of the array
 * Given an array of integers A and multiple values in B which represents the indices of the array A around which left rotation of the array A needs to be performed.
 *
 * Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 *
 * Return the resultant matrix.
 * Constraints
 *
 * 1 <= length of both arrays <= 2000
 * -10^9 <= A[i] <= 10^9
 * 0 <= B[i] <= 2000
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 *     B = [2, 3]
 * Output 1:
 *     [ [3, 4, 5, 1, 2]
 *       [4, 5, 1, 2, 3] ]
 *
 * Input 2:
 *     A = [5, 17, 100, 11]
 *     B = [1]
 * Output 2:
 *     [ [17, 100, 11, 5] ]</pre>
 */
public class MultipleLeftRotationsOfTheArray {

  public static void main(String[] args) {

    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> B = new ArrayList<>();

    A.add(1);
    A.add(2);
    A.add(3);
    A.add(4);
    A.add(5);

    B.add(2);
    B.add(3);

    ArrayList<ArrayList<Integer>> rotated = rotate(A, B);

    System.out.println("Rotated matrix::");
    printArrayListMatrix(rotated);

  }

  public static ArrayList<ArrayList<Integer>> rotate(final ArrayList<Integer> A,
      final ArrayList<Integer> B) {

    ArrayList<ArrayList<Integer>> solListMatrix = new ArrayList<>();
    for (int i = 0; i < B.size(); i++) {

      ArrayList<Integer> sourceList = new ArrayList<>();

      A.stream().forEach(item -> sourceList.add(item));

      int n = sourceList.size();
      int k = B.get(i) % n;

      reverse2Pointer(sourceList, 0, n);
      reverse2Pointer(sourceList, 0, (n - k));
      reverse2Pointer(sourceList, (n - k), n);

      solListMatrix.add(sourceList);
      //printArrayList(sourceList);
    }
    return solListMatrix;
  }

  public static void reverse2Pointer(ArrayList<Integer> A, int low, int high) {
    int i = low;
    int j = high - 1;
    while (i < j) {
      int tmp = A.get(j);
      A.remove(j);
      A.add(j, A.get(i));
      A.remove(i);
      A.add(i, tmp);
      i++;
      j--;
    }
  }

}
