package com.scalar.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>Problem Description
 *
 * You love reading books, and you also love reading books that you've already read (weird you).
 *
 * In a day, you read a total of N times, consisting of some books. Each book is represented by an index in array A.
 *
 * You write the number of each book you read in the order of reading them in the array A.
 *
 * You are supposed to find the book that you've least recently read (the book you haven't read for as long as possible) out of the books you've read that day (Books in array A).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2 x 105
 *
 * 0 <= A[i] <= 2 x 105
 *
 * You can read books more than once.
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains an integer array, A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [4, 8, 1, 3, 1]
 * Input 2:
 *
 *  A = [7, 8, 4, 2, 7]
 *
 *
 * Example Output
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 is the least recently read book.
 * Explanation 2:
 *
 *  8 is the least recently read book.</pre>
 */
public class BookLover {

  public static void main(String[] args) {
    BookLover bookLover = new BookLover();
    ArrayList<Integer> A = new ArrayList<>();

    int[] inp = new int[]{4, 8, 1, 3, 1};

    for (int i : inp) {
      A.add(i);
    }
    System.out.println("sol1:" + bookLover.solve(A));

    inp = new int[]{1, 2, 3, 2, 3, 2, 3, 1};
    A = new ArrayList<>();
    for (int i : inp) {
      A.add(i);
    }
    System.out.println("sol2:" + bookLover.solve(A));
  }

  public int solve(ArrayList<Integer> A) {
    if (A.size() == 1) {
      return A.get(0);
    } else {
      int leastRecentlyReadBook = A.get(0);
      int n = A.size();
      Map<Integer, Integer> readCountMap = new LinkedHashMap<>();

      for (int i = 0; i < n; i++) {
        readCountMap.put(A.get(i), readCountMap.getOrDefault(readCountMap.get(A.get(i)), 0) + 1);
      }

      for (int c : readCountMap.keySet()) {
        System.out.println(c + ":" + readCountMap.get(c));
      }

      for (int c : readCountMap.keySet()) {
        if (readCountMap.get(c) == 1) {
          return c;
        }
      }
      return leastRecentlyReadBook;
    }
  }

  public int solve_accepted(ArrayList<Integer> A) {
    if (A.size() == 1) {
      return A.get(0);
    } else {
      int leastRecentlyReadBook = A.get(0);
      int n = A.size();
      Map<Integer, Integer> readCountMap = new LinkedHashMap<>();

      for (int i = 0; i < n; i++) {
        readCountMap.put(A.get(i), i);
      }

      int minI = Integer.MAX_VALUE;
      for (int c : readCountMap.keySet()) {
        if (readCountMap.get(c) < minI) {
          minI = readCountMap.get(c);
          leastRecentlyReadBook = c;
        }

      }
      return leastRecentlyReadBook;
    }
  }

  int solve_editorial(int[] A) {
    int ans = 0;
    int[] b = new int[200003];
    int n = A.length;
    for (int i = n - 1; i >= 0; i--) {
      // Check for least recently used
      if (b[A[i]] == 0) {
        ans = A[i];
        b[A[i]] = 1;
      }
    }
    // return answer
    return ans;
  }
}