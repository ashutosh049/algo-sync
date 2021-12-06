package com.scalar.classroom.day17_string_manipulation;

public class ReverStringWordByWord {

  public static void main(String[] args) {
    String s = "The sky is blue";

    System.out.println("Reversed: '"+solve(s)+"'");
  }

  public static String solve(String A) {
    StringBuilder sb = new StringBuilder();

    if(A!=null && A.length()>=1 ){

      String[] sArr = A.split("\\s+");
      int n = sArr.length;

      for (int i=n-1; i >=0; i--) {
        sb.append(sArr[i]+" ");
      }

    }

    return sb.toString().trim();
  }

  /*public static String solve(String A) {
    StringBuilder sb = new StringBuilder();

    if (A != null && A.length() >= 1) {
      int n = A.length();

      int i = n-1;
      int j = n-1;
      while (i > 0) {
        while (j > 0 && A.charAt(j) != ' ') {
          j--;
          continue;
        }
        sb.append(A.substring(j+1,i+1));
        i=j;
        j--;
        sb.append(A.substring(j+1,i+1));
        System.out.println(sb.toString());
      }
    }
    return sb.toString();
  }*/

}
