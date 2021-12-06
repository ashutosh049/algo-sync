package com.scalar.topics.arrays;

import java.util.Scanner;

/**
 * <pre>Problem Description
 *
 * You are given an integer T (Number of test cases). For each test case, you are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.
 *
 * NOTE: You can use extra memory.
 *
 *
 *
 * Problem Constraints
 * 1 <= T <= 10
 *
 * 1 <= |A| <= 106
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * First line of the input contains a single integer T.
 *
 * Next, each of the test case consists of 2 lines:
 *
 * First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
 * Second line contains a single integer B
 *
 *
 * Output Format
 * For each test case, print an array of integers which is the Bth right rotation of input array A, on a separate line.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  2
 *  4 1 2 3 4
 *  2
 *  3 1 2 4
 *  1
 * Input 2:
 *
 *  1
 *  3 1 2 2
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  3 4 1 2
 *  4 1 2
 * Output 2:
 *
 *  1 2 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For Test Case 1:
 *  [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
 *  For Test Case 2:
 *  [1,2,4] => [4,1,2]
 * Explanation 2:
 *
 *  For Test Case 1:
 *  [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]</pre>
 */
public class RotationGame {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCases = Integer.valueOf(sc.nextLine().trim());

    for (int t = 0; t < testCases; t++) {

      String arrLine = sc.nextLine().trim();

      String[] arrLineArr = arrLine.split(" ");

      int[] arr = new int[Integer.valueOf(arrLineArr[0])];

      for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.valueOf(arrLineArr[i + 1]);
      }
      int roatetBy = Integer.valueOf(sc.nextLine().trim());

      rotate(arr, (roatetBy % arr.length));
    }
    sc.close();

  }

  private static void rotate(int[] arr, int k) {
    int n = arr.length;

    //Step-2: Reverse All
    reverse2Pointer(arr, 0, n);

    //Step-2: Reverse left part
    reverse2Pointer(arr, 0, k);

    //Step-3: Reverse right part
    reverse2Pointer(arr, k, n);

    printArray(arr);

  }

  public static void reverse2Pointer(int[] arr, int low, int high) {
    int i = low;
    int j = high - 1;
    while (i < j) {
      int tmp = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
      i++;
      j--;
    }
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}