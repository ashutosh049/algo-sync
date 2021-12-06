package com.scalar.classroom.day18_problem_solving;

import com.util.Util;

/**
 * <h3>Beggars Outside Temple</h3>
 * <pre>There are N (N > 0) beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to his faith and ability) to some K beggars sitting next to each other.
 *
 * Given the amount donated by each devotee to the beggars ranging from i to j index, where 1 <= i <= j <= N, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 *
 * Example:
 *
 * Input:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 *
 * Return: [10, 55, 45, 25, 25]
 *
 * Explanation:
 * => First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 *
 * => Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 *
 * => Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]</pre>
 * <h3>Solution Approach</h3>
 * <pre>Instead of updating each beggars ranging from i to j, we could just update index i with +S and index j + 1 with -S, where S is donation made by some devotee. So if you want to know number of coins taken by kth beggar, you just need to find prefix sum of all the values(coins) from 1 to k(Try to prove it by yourself that values between i to j contains +S as you are doing prefix sum).
 *
 * Example:
 * N = 5, D = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
 * Initial array: [0, 0, 0, 0, 0]
 *
 * After first devotee, if we update i = 1 with +10 and j + 1 = 3 with -10, we get [10, 0, -10, 0, 0]. Now note that if you add 10 to 1st index and subtract 10 with 3rd index and do a prefix sum at every array element, you will get +10 at 1st and 2nd.
 * After second devotee, if we update i = 2 with +20 and j + 1 = 4 with -20, we get [10, 20, -10, -20, 0].
 * Similarly, after third devotee, if we update i = 2 with +25 and j + 1 = 6 with -25, we get [10, 45, -10, -20, 0].
 * Now if we calculate the prefix sum at every index, we get [10, 55, 45, 25, 25].</pre>
 */
public class BeggarsInTemple {

  public static void main(String[] args) {
    int[][] D = new int[][]{{1, 3, 10},
        {6, 9, 2},
        {3, 5, 3},
        {2, 8, 4},
        {6, 7, 5}};

    int A = 10;

    int[] beggarsPot = solve(A, D);

    System.out.println("-----beggarsPot-------");
    Util.printArray(beggarsPot);

  }

  public static int[] solve(int A, int[][] D) {

    int[] beggersPot = new int[A];
    int devotees = D.length;

    for (int i = 0; i < devotees; i++) {
      int[] data = D[i];
      int start = data[0];
      int end = data[1];
      int amount = data[2];

      for (int j = start - 1; j < end; j++) {
        beggersPot[j] += amount;
      }
    }

    return beggersPot;

  }

}
