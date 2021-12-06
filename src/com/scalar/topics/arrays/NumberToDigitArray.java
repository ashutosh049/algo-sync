package com.scalar.topics.arrays;

import java.math.BigInteger;
import java.util.ArrayList;

public class NumberToDigitArray {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(3);
    arr.add(2);
    arr.add(1);
    arr.add(1);
    arr.add(2);
    arr.add(5);
    arr.add(9);
    arr.add(6);
    arr.add(9);

    ArrayList<Integer> sol = plusOne(arr);

    System.out.println("sol: " + sol);

  }

  public static ArrayList<Integer> plusOne(ArrayList<Integer> Arr) {

    if (Arr != null && Arr.size() >= 1) {
      int n = Arr.size();

      BigInteger total = BigInteger.valueOf(0);

      for (int i = 0; i < n; i++) {
        int pow = n - i - 1;
        BigInteger val = BigInteger.valueOf(Arr.get(i));
        BigInteger mul = BigInteger.valueOf((long) Math.pow(10, pow));
        total = total.add(val.multiply(mul));
        //System.out.printf("power:%d, mul:%d, val:%d, total:%d", pow, mul, val, total);
      }

      total = total.add(BigInteger.ONE);

      String totalString = String.valueOf(total);

      String[] totalStringArr = totalString.split("");

      ArrayList<Integer> solArr = new ArrayList<>();

      for (int i = 0; i < totalStringArr.length; i++) {
        solArr.add(Integer.valueOf(totalStringArr[i]));
      }

      return solArr;
    }
    return new ArrayList<>();
  }
}
