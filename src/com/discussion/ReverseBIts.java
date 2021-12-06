package com.discussion;

public class ReverseBIts {

  public static void main(String[] args) {

    int n = 5;
    int res = reverseBits_xor(n);
    System.out.println(n + ": " + Integer.toBinaryString(n));
    System.out.println("-102: " + Integer.toBinaryString(-102));
    System.out.println(n + ": " + res);
  }

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
