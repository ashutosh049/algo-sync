package com.scalar.topics.bit_manipulation;

public class IntegerToBinary {

  public static void main(String[] args) {

    int a = 32;

    getBinaryRepresentation(a);
  }

  private static void getBinaryRepresentation(int a) {
    for (int i = 0; i <= a; i++) {
      StringBuffer sb = new StringBuffer();
      for (int j = i; j >= 1; j = j / 2) {
        sb.insert(0, j % 2);
      }
      while (sb.length() < 6) {
        sb.insert(0, "0");
      }

      String bitRepresentation = sb.toString();
      if(i<10){
        System.out.println("0"+i + "= [" + bitRepresentation + "]");
      }else{
        System.out.println(i + "= [" + bitRepresentation + "]");
      }

    }
  }

}
