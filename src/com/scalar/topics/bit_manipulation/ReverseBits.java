package com.scalar.topics.bit_manipulation;

/**
 * <h2>Problem</h2>
 * <pre>
 *   Problem Description
 *
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 *
 *
 * Problem Constraints
 * 0 <= A <= 232
 *
 *
 *
 * Input Format
 * First and only argument of input contains an integer A.
 *
 *
 *
 * Output Format
 * Return a single unsigned integer denoting the decimal value of reversed bits.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  0
 * Input 2:
 *
 *  3
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  3221225472
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *         00000000000000000000000000000000
 *
 * =>      00000000000000000000000000000000
 * Explanation 2:
 *
 *         00000000000000000000000000000011
 * =>      11000000000000000000000000000000
 * </pre>
 * <h2>Soltuion</h2>
 * <pre>
 *   Reversing bits could be done by swapping the n/2 least significant bits with its most significant bits.
 *
 * The trick is to implement a function called swapBits(i, j), which swaps the ‘i’th bit with the ‘j’th bit.
 *
 * If you still remember how XOR operation works:
 *
 * 0 ^ 0 == 0,
 * 1 ^ 1 == 0,
 * 0 ^ 1 == 1, and
 * 1 ^ 0 == 1.
 * We only need to perform the swap when the ‘i’th bit and the ‘j’th bit are different.
 *
 * To test if two bits are different, we could use the XOR operation. Then, we need to toggle both ‘i’th and ‘j’th bits.
 *
 * We could apply the XOR operation again.
 *
 * By XOR-ing the ‘i’th and ‘j’th bit with 1, both bits are toggled.
 *
 * Bonus approach (The divide and conquer approach):
 *
 * Remember how merge sort works? Let us use an example of n == 8 (one byte) to see how this works:
 *
 *
 *               01101001
 *
 *              /        \
 *
 *            0110       1001
 *
 *           /   \       /   \
 *
 *          01    10    10    01
 *
 *         /\     /\    /\     /\
 *
 *        0  1   1  0  1  0   0  1
 * The first step is to swap all odd and even bits. After that swap consecutive pairs of bits, and so on …
 *
 * Therefore, only a total of log(n) operations are necessary.
 *
 * Example:
 *
 * For the first step, you would do:
 *
 *     x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
 * </pre>
 */
public class ReverseBits {

  public static void main(String[] args) {
    long original = 10;
    long reversed = reverse_fastest(original);

    System.out.println("reversed:" + reversed + "[" + Long.toBinaryString(reversed) + "]");
  }

  public static long reverse_fastest(long a) {

    long out = 0;

    for (int i = 0; i < 32; i++) {

      out = out << 1L;

      if ((a & 1L) == 1L) {
        out += 1;
      }

      a = a >>> 1L;

    }

    return out;

  }

  public long reverse_editorial(long A) {
    long rev = 0;

    for (int i = 0; i < 32; i++) {
      rev <<= 1;
      if ((A & (1 << i)) != 0) {
        rev |= 1;
      }
    }

    return rev;

  }

  public long reverse_lightweight(long A) {
    long rev = 0;

    /* start at the lowest bit shift it over by 1 and if */
    for (int i = 0; i < 32; i++) {
      rev = rev << 1;
      if ((A & (1 << i)) != 0) {
        rev |= 1;
      }
    }
    return rev;
  }
}
