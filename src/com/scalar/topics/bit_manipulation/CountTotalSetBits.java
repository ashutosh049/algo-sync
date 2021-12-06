package com.scalar.topics.bit_manipulation;

/**
 * <pre>Problem Description
 *
 * Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
 *
 * Return the count modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 3
 * Input 2:
 *
 *  A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *     2          10        1
 *     3          11        2
 *  1 + 1 + 2 = 4
 *  Answer = 4 % 1000000007 = 4
 * Explanation 2:
 *
 *  A = 1
 *   DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *  Answer = 1 % 1000000007 = 1</pre>
 * <h2>MedianOf2SortedArray Appraoch</h2>
 * <pre>If we observe bits from rightmost side at distance i than bits get inverted after 2^i position in vertical sequence.
 *
 * For example A = 5;
 * 0 = 0000
 * 1 = 0001
 * 2 = 0010
 * 3 = 0011
 * 4 = 0100
 * 5 = 0101
 *
 * Observe the right most bit (i = 0) the bits get flipped after (2^0 = 1)
 * Observe the 3rd rightmost bit (i = 2) the bits get flipped after (2^2 = 4)
 *
 * So, We can count bits in vertical fashion such that at i’th right most position bits will be get flipped after 2^i iteration;
 *
 * So, we will iterate till the number of bits in the number. And we don’t have to iterate every single number in the range from 1 to A.
 * We will perform the following operations to get the desired result.
 *
 * First of all, we will add 1 to the number in order to compensate 0. As the binary number system starts from 0. So now num = num + 1.
 * We will keep the track of the number of set bits encountered till now. And we will initialise it with num/2.
 * We will keep one variable which is a power of 2, in order to keep track of bit we are computing.
 * We will iterate till the power of 2 becomes greater than A.
 * We can get the number of pairs of 0s and 1s in the current bit for all the numbers by dividing A by current power of 2.
 * Now we have to add the bits in the set bits count. We can do this by dividing the number of pairs of 0s and 1s by 2 which will give us the number of pairs of 1s only and after that, we will multiply that with the current power of 2 to get the count of ones in the groups.
 * Now there may be a chance that we get a number as number of pairs, which is somewhere in the middle of the group i.e. the number of 1s are less than the current power of 2 in that particular group. So, we will find modulus and add that to the count of set bits.
 * Time Complexity : O(logA)
 *
 *  </pre>
 */
public class CountTotalSetBits {

  public static void main(String[] args) {
    int num = 9;
    //System.out.println("totalSetBits  for A="+num+" :" + solve_scalar_editorial(num));
    num = 1;
    System.out.println("totalSetBits from 1 to "+num+": " + solve_scalar_editorial(num));
  }

  public static long solve(int num) {

    long count = 0;
    long power = 2;

    num = num + 1;

    /**
     * 0 = 0000
     * 1 = 0001
     * 2 = 0010
     * 3 = 0011
     * 4 = 0100
     * 5 = 0101
     */
    while (num / power > 0) {

      count += (num / power) * (power / 2);

      if (num % power > power / 2) {
        count += (num % power) - power / 2;
      } else {
        count += 0;
      }

      power *= 2;
    }

    if (num % power > power / 2) {
      count += (num % power) - power / 2;
    } else {
      count += 0;
    }

    return count % 1000000007;
  }

  /**
   * If we observe bits from rightmost side at distance i than bits get inverted after 2i position
   * in vertical sequence.
   * <p>
   * For example A = 5; 0 = 0000 1 = 0001 2 = 0010 3 = 0011 4 = 0100 5 = 0101
   * <p>
   * So, we will iterate till the number of bits in the number. And we don’t have to iterate every
   * single number in the range from 1 to A. We will perform the following operations to get the
   * desired result.
   * <ul>
   *
   * <li>First of all, we will add 1 to the number in order to compensate 0. As the binary number
   * system starts from 0. So now A = A + 1.
   * <li>We will keep the track of the number of set bits encountered till now. And we will
   * initialise it with A/2.
   * <li>We will keep one variable which is a power of 2, in order to keep track of bit we are
   * computing.
   * <li>We will iterate till the power of 2 becomes greater than A.
   * <li>We can get the number of pairs of 0s and 1s in the current bit for all the numbers by
   * dividing A by current power of 2.
   * <li>Now we have to add the bits in the set bits count. We can do this by dividing the
   * number of pairs of 0s and 1s by 2 which will give us the number of pairs of 1s only and after
   * that, we will multiply that with the current power of 2 to get the count of ones in the
   * groups.
   * <li>Now there may be a chance that we get a number as number of pairs, which is somewhere in
   * the middle of the group i.e. the number of 1s are less than the current power of 2 in that
   * particular group. So, we will find modulus and add that to the count of set bits.
   * </ul>
   * Time Complexity : O(logA)
   *
   * Example:
   * num= 3
   * 0: 0000
   * 1: 0001
   * 2: 0010
   * 3: 0011
   * ------------
   * num = 3+1= 4
   * -------
   * p=2,
   * while(4/2 >0){
   *   count += (4/2) * (2/2)
   *   => count += (2 * 1 = 2
   *   => count = 0+2 =2
   *   ----
   *   if(4 % 2 > 2/2){ // true
   *     count += (4 % 2) - 2 / 2
   *     =>count +=  0 - 1
   *     =>count =  2-1=1
   *   }else{
   *      count += 0
   *      => count = 2 +0=2
   *   }
   *   loop end: count = 2
   * }
   * -------
   * p=4,
   * while(4/4 >0){
   *   count += (4/4) * (4/2)
   *   => count += 1 * 2 = 2
   *   => count = 2+2 =4
   *   ----
   *   if(4 % 2 > 4/2){ // false
   *     count += (4 % 2) - 2 / 2
   *     =>count +=  0 - 1
   *     =>count =  2-1=1
   *   }else{
   *      count += 0
   *      => count = 2 +0=2
   *   }
   *   loop end: count = 2
   * }
   * @param num
   */
  public static long solve_scalar_editorial(int num) {
    long count = 0;
    long p = 2;
    num = num + 1;

    while (num / p > 0) {
      count += (num / p) * (p / 2);
      count += (num % p > p / 2) ? (num % p) - p / 2 : 0;
      p *= 2;
    }

    count += (num % p > p / 2) ? (num % p) - p / 2 : 0;

    return count % 1000000007;
  }

  /**
   * Brian Kernighan’s algorithm
   *
   * @param A
   * @return
   */
  public long solve_brian_kernighan_algo(int A) {
    long count = 0;

    for (int i = 1; i <= A; i++) {
      int n = i;
      while (n != 0) {
        n = n & (n - 1);
        count++;
      }
    }

    return count % 1000000007;
  }
}
