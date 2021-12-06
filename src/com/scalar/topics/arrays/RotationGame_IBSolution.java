package com.scalar.topics.arrays;

import java.util.Scanner;

public class RotationGame_IBSolution {

  public static void main(String[] args) {
    // YOUR CODE GOES HERE
    // Please take input and print output to standard input/output (stdin/stdout)
    // DO NOT USE ARGUMENTS FOR INPUTS
    // E.g. 'Scanner' for input & 'System.out' for output
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T-- > 0) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) {
        A[i] = sc.nextInt();
      }
      int B;
      B = sc.nextInt();
      B = B % N;

      int[] ans = new int[N];

      for (int i = 0; i < N; ++i) {
        ans[i] = A[(i - B + N) % N];
      }

      for (int i = 0; i < N; i++) {
        System.out.print(ans[i] + " ");
      }
      System.out.println();
    }
  }
}