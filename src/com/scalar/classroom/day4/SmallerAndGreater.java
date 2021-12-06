package com.scalar.classroom.day4;

import java.util.Arrays;

/**
 * <pre>Smaller and Greater
 * You are given an Array A of size N.
 *
 * Find for how many elements, there is a strictly smaller element and a strictly greater element.
 *
 *
 *
 * Input Format
 *
 * Given only argument A an Array of Integers.
 * Output Format
 *
 * Return an Integer X, i.e number of elements.
 * Constraints
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e6
 * For Example
 *
 * Example Input:
 *     A = [1, 2, 3]
 *
 * Example Output:
 *     1
 *
 * Explanation:
 *     only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.
 *  </pre>
 *  Sol:
 *     <pre>
 *       int VowelIt::solve(vector<int> &A) {
 *
 *     int ans = 0;
 *     // initialize the smallest and greatest element
 *     int mini = 1e9, maxi = -1e9;
 *     // find smallest and greatest element
 *     for(auto &i : A) {
 *         mini = min(mini, i);
 *         maxi = max(maxi, i);
 *     }
 *     // count the required elements
 *     for(auto &i : A) {
 *         if(mini < i and i < maxi)
 *             ans += 1;
 *     }
 *     // return the answer
 *     return ans;
 * }
 *     </pre>
 */
public class SmallerAndGreater {

  public static void main(String[] args) {
    //int[] Arr = {947, 871, 859, 471, 763, 766, 379, 746, 485, 966, 10, 350, 341, 22, 706, 702, 717, 967, 641, 712, 10, 954, 751, 250, 777, 214, 820, 276, 708, 509, 123, 73, 593, 790, 797, 678, 320, 865, 392, 428, 611, 813, 655, 195, 102, 902, 919, 171, 706, 841, 873, 98, 128, 728, 878, 701, 874, 158, 548, 214, 414, 600, 869, 936, 841, 221, 87, 255, 233, 627, 487, 53, 270, 162, 517, 576, 240, 681, 172, 148, 86, 778, 205, 741, 483, 11, 795, 188, 450};

    int[] Arr = {913, 440, 865, 72, 612, 445, 101, 994, 356, 91, 461, 930, 583, 448, 543, 170, 333, 107, 425, 73, 172, 416, 899, 826, 659, 561, 314, 25, 110};

    // int[] Arr = {1, 2, 2, 3, 4, 6, 7, 8, 9};
    //int[] Arr = {762, 683, 661, 202, 629, 447, 493};

    System.out.println("\n-------\noutput: " + solve(Arr) + "\n--------");

    //Arrays.sort(Arr);

    for (int a : Arr) {
      System.out.print(a + ", ");
    }
  }

  public static int solve(int[] Arr) {

    if (Arr.length > 2) {
      int min = Arr[0];
      int max = Arr[Arr.length - 1];
      int count = 0;

      for (int i = 0; i <= Arr.length - 1; i++) {
        if (Arr[i] < min) {
          min = Arr[i];
        } else if (Arr[i] > max) {
          max = Arr[i];
        }
      }

      for (int i = 0; i <= Arr.length - 1; i++) {
        if (Arr[i] > min && Arr[i] < max) {
          count++;
        }
      }
      return count;
    } else {
      return 0;
    }
  }

}
