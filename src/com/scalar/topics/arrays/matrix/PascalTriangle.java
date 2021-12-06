package com.scalar.topics.arrays.matrix;

import com.util.Util;
import java.util.ArrayList;

public class PascalTriangle {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> matrix = solve(5);
    System.out.println("----solution----");
    Util.printArrayListMatrix(matrix);

  }

  public static ArrayList<ArrayList<Integer>> solve(int num) {
    ArrayList<ArrayList<Integer>> solList = new ArrayList<>();
    if (num >= 1) {

      for (int i = 0; i < num; i++) {
        ArrayList<Integer> dataList = new ArrayList<>();
        if(i-1 < 0){
          dataList.add(1);
        }else{
          ArrayList<Integer> preList = solList.get(i - 1);
          for (int j = 0; j <= i; j++) {
            int preIdx = j - 1;
            if (preIdx < 0) {
              dataList.add(j, 1);
            }else{
              int data = preList.get(preIdx) + preList.get(j);
              dataList.add(j, data);
            }
          }

        }
        solList.add(dataList);

      }

    }
    return solList;
  }
}
