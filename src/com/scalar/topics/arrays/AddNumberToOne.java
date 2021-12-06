package com.scalar.topics.arrays;

import java.util.ArrayList;

public class AddNumberToOne {

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

    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(1);
    sol = plusOne(arr);
    System.out.println("sol: " + sol);

    arr = new ArrayList<>();
    arr.add(0);
    arr.add(0);
    arr.add(0);
    sol = plusOne(arr);
    System.out.println("sol: " + sol);

    arr = new ArrayList<>();
    arr.add(1);
    arr.add(0);
    arr.add(0);
    sol = plusOne(arr);
    System.out.println("sol: " + sol);

    arr = new ArrayList<>();
    arr.add(0);
    arr.add(9);
    arr.add(9);
    sol = plusOne(arr);
    System.out.println("sol: " + sol);

  }

  public static ArrayList<Integer> plusOne(ArrayList<Integer> Arr) {

    ArrayList<Integer> solArr = new ArrayList<>();

    // If List is not empty
    if (Arr != null && Arr.size() >= 1) {

      StringBuilder strValueBldr = new StringBuilder();
      int n = Arr.size();

      int carry = 0;
      int low = 0; // MSB
      int high = n - 1; // LSB
      int i = 0;

      // Remove starting 0's
      while (Arr.get(i++) == 0) {
        low++;
        // If the list has all zeroes, return 1
        if (low > n - 1) {
          strValueBldr.insert(0, "1");
          break;
        }
      }

      //reset high to MSB index
      if (high >= low) {

        for (; high >= low; high--) {

          int value = Arr.get(high) + carry;

          //Add 1 to number
          if (high == n - 1) {
            value++;
          }

          int curr = value % 10;
          carry = value / 10;
          strValueBldr.insert(0, curr);
        }

      }

      if (carry >= 1) {
        strValueBldr.insert(0, carry);
      }

      String strValue = strValueBldr.toString();

      for (i = 0; i < strValue.length(); i++) {
        solArr.add(Integer.valueOf(strValue.substring(i, i + 1)));
      }

    }

    return solArr;
  }
}
