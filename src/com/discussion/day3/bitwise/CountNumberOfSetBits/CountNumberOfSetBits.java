package com.discussion.day3.bitwise.CountNumberOfSetBits;

public class CountNumberOfSetBits {

  public static void main(String[] args) {
    //
    String binaryString1 = "00000000000000000000000000001011"; // expected op=3
    String binaryString2 = "00000000000000000000000010000000"; // expected op=1
    String binaryString3 = "11111111111111111111111111111101"; // expected op=31

    int testCase1 = Integer.parseInt(binaryString1, 2);
    int testCase2 = Integer.parseInt(binaryString2, 2);
    // Number format exception if converted to int for binaryString3
    long testCase3 = Long.parseLong(binaryString3, 2);

    System.out.println("Binary:" + binaryString1 + ", int: " + testCase1);
    System.out.println("Binary:" + binaryString2 + ", int: " + testCase2);
    System.out.println("Binary:" + binaryString3 + ", long: " + testCase3);
    System.out.println("\n");
    System.out.println(binaryString1 + ", set bits=" + bitwiseOp(testCase1));
    System.out.println(binaryString2 + ", set bits=" + bitwiseOp(testCase2));
    // can not run 3rd test case, requires int
    // System.out.println(binaryString3+", set bits="+bitwiseOp(testCase3));
  }

  private static int bruteForce(int n) {
    String binaryStr = Integer.toBinaryString(n);
    int count = 0;

    for (int i = 0; i < binaryStr.length(); i++) {
      if (binaryStr.charAt(i) == '1') {
        count++;
      }
    }

    return count;
  }

  private static int divisionMethod(int n) {

    int count = 0;

    // n > 0 will not work in case of negetive binary numbers
    // Use i: 0 to 31
    while (n > 0) {
      int rem = n % 2;

      if (rem == 1) {
        count++;
      }

      n = n / 2;
    }

    return count;
  }

  private static int bitwiseOp(int n) {
    int count = 0;
    int len = 32;
    while (len-- >= 1) {
      if ((n & 1) != 0) {
        count++;
      }

      n = n >> 1;
    }

    return count;
  }
}
