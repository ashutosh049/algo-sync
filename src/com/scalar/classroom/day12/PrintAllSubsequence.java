package com.scalar.classroom.day12;

import com.util.Util;
import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {

  public static void main(String[] args) {

    String input1 = "abc";
    List<String> subsequenceList1 = genSubsequence_string(input1);
    System.out.println("------sub-sequence list----");
    Util.printArrayListString(subsequenceList1);

    int input2 = 263;
    List<Integer> subsequenceList2 = genSubsequence_number(input2);
    System.out.println("------sub-sequence list----");
    Util.printArrayList(subsequenceList2);

  }

  private static List<String> genSubsequence_string(String input) {
    return genSubsequence_string(input, "", new ArrayList<>());
  }

  private static List<Integer> genSubsequence_number(int input) {
    return genSubsequence_number(String.valueOf(input), "", new ArrayList<>());
  }

  private static List<String> genSubsequence_string(String input, String output,
      List<String> subseqList) {

    if (input.length() == 0) {
      //for non-empty sub-sequence, we check if output is not empty before adding to solution list
      if (output.length() >= 1) {
        subseqList.add(output);
      }
      return subseqList;
    }

    genSubsequence_string(input.substring(1), output, subseqList);
    genSubsequence_string(input.substring(1), output + input.charAt(0), subseqList);

    return subseqList;
  }

  private static List<Integer> genSubsequence_number(String input, String output,
      List<Integer> subseqList) {

    if (input.length() == 0) {
      //for non-empty sub-sequence, we check if output is not empty before adding to solution list
      if (output.length() >= 1) {
        subseqList.add(Integer.valueOf(output));
      }
      return subseqList;
    }

    genSubsequence_number(input.substring(1), output, subseqList);
    genSubsequence_number(input.substring(1), output + input.charAt(0), subseqList);

    return subseqList;
  }
}
