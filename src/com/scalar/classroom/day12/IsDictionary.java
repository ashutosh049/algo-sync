package com.scalar.classroom.day12;

import java.util.ArrayList;

public class IsDictionary {

  public static void main(String[] args) {

    ArrayList<String> ipList = new ArrayList<>();
    ipList.add("hello");
    ipList.add("scaler");
    ipList.add("interviewbit");
    String B = "adhbcfegskjlponmirqtxwuvzy";

    System.out.println("is lexicographically sorted: " + solve(ipList, B));

  }

  public static int solve(ArrayList<String> A, String B) {
    int map[] = new int[26];

    for (int i = 0; i < B.length(); i++) {
      map[B.charAt(i) - 'a'] = i;
    }

    //String ans = a[0];

    for (int i = 0; i < A.size() - 1; i++) {
      if (compare(A.get(i), A.get(i + 1), map) > 0) {
        //int isGreater = compare(A.get(i), A.get(i + 1), map);
        //System.out.println(A.get(i)+" & "+A.get(i+1)+" :: "+isGreater);
          return 0;
      }
    }

    /*int i = 0;
    while (compare(A.get(i), A.get(i + 1), map) < 0) {
      i++;
    }*/
    return 1;
  }

  public static int compare(String word1, String word2, int[] order) {
    int i = 0, j = 0, charcompareval = 0;

    while (i < word1.length() && j < word2.length()) {

      // Compare each char according to the order
      charcompareval = order[word1.charAt(i) - 'a'] - order[word2.charAt(i) - 'a'];

      // Find the first non-matching character in the string
      if (charcompareval != 0) {
        return charcompareval;
      }

      i++;
      j++;
    }

    // If one word is prefix of other return shortest word
    if (charcompareval == 0) {
      return (word1.length()
          - word2.length());
    } else {
      return charcompareval;
    }
  }
}
