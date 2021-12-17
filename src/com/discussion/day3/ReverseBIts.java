package com.discussion.day3;

public class ReverseBIts {

  public static void main(String[] args) {

    int n = 5;
    int res = reverseBits_xor(n);
    System.out.println(n + ": " + Integer.toBinaryString(n));
    System.out.println("-102: " + Integer.toBinaryString(-102));
    System.out.println(n + ": " + res);
  }

  /**
   * Iterative path sum. Intuition: Proceed in a classic post-order iterative fashion, with 2 things
   * in mind:
   * <p>
   * 1. Keep a currSum variable which will have the total sum up to curr node
   * <p>
   * 2. On each pop-operation/climb-up (processing of a node), and since we know that we have
   * already checked if this node  was a leaf node and if the sum till this node is equal to target,
   * we reduce it's value from `currSum` which we added while traversing downwards.
   * <p>
   * Time: O(n)
   * <p>
   * Space: O(n)
   */
  public static int reverseBits_xor(int n) {

    int binaryN = Integer.valueOf(Integer.toBinaryString(n));

    int mask = 1;
    for (int i = 0; i < 32; i++) {
      binaryN = binaryN ^ mask;
      mask = mask << 1;
    }
    return binaryN;
  }
}
