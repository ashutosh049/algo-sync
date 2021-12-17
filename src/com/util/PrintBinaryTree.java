package com.util;

public class PrintBinaryTree {

  public static void main(String[] args) {
    testPrintMatrix();
  }

  private static void testPrintMatrix() {
    String[][] matrix = new String[3][4];
    String[][] doubleMatrix = new String[6][8];

    //matrix[0][0] = "*";
    matrix[0][1] = "1";
    //matrix[0][2] = "*";

    matrix[1][0] = "2";
    //matrix[1][1] = "*";
    matrix[1][2] = "3";
    //matrix[2][0] = "*";
    //matrix[2][1] = "*";
    //matrix[2][2] = "*";

    matrix[2][3] = "4";

    int row = matrix.length;
    int col = matrix[0].length;

    int dRow = doubleMatrix.length;
    int dCol = doubleMatrix[0].length;

    System.out.println("------- node matrix--------");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == null) {
          System.out.print("* ");
        } else {
          System.out.print(matrix[i][j] + " ");
        }
      }
      System.out.println();
    }

    // create double matrix
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        String curr = matrix[i][j];
        if (curr != null) {
          doubleMatrix[i * 2][j * 2] = curr;
        }
      }
    }
    System.out.println("------- double matrix--------");
    for (int i = 0; i < dRow; i++) {
      for (int j = 0; j < dCol; j++) {
        if (doubleMatrix[i][j] == null) {
          System.out.print("* ");
        } else {
          System.out.print(doubleMatrix[i][j] + " ");
        }
      }
      System.out.println();
    }

    // populate arrows double matrix
    System.out.println("populate arrows in double matrix");
    for (int i = 0; i < dRow; i++) {
      StringBuilder valueLine = new StringBuilder();
      for (int j = 0; j < dCol; j++) {
        String curr = doubleMatrix[i][j];
        if (curr == null) {
          valueLine.append(" ");
        } else {
          valueLine.append(curr);

          System.out.println("curr slot: [" + i + "][" + j + "]");

          if (!isSlotEmpty(i + 2, j - 2, dRow, dCol, doubleMatrix)) {
            System.out.println("\t Left child : [" + (i + 2) + "][" + (j - 2) + "] is not empty");
            doubleMatrix[i + 1][j - 1] = "/";
          }

          if (!isSlotEmpty(i + 2, j + 2, dRow, dCol, doubleMatrix)) {
            System.out.println("\t Right child : [" + (i + 2) + "][" + (j + 2) + "] is not empty");
            doubleMatrix[i + 1][j + 1] = "\\";
          }
        }

      }
      System.out.println(valueLine);
      //System.out.println(pointersLine);
    }
    //--------------------------------

    System.out.println("------- double matrix with dir--------");
    for (int i = 0; i < dRow; i++) {
      for (int j = 0; j < dCol; j++) {
        if (doubleMatrix[i][j] != null) {
          System.out.print(" ");
        } else {
          System.out.print(doubleMatrix[i][j] + "");
        }
      }
      System.out.println();
    }

  }

  private static boolean isSlotEmpty(int i, int j, int totalRow, int totalCol, String[][] matrix) {
    return isValidSlot(i, j, totalRow, totalCol) && matrix[i][j] == null;
  }

  private static boolean isValidSlot(int i, int j, int totalRow, int totalCol) {
    return i >= 0 && i < totalRow && j >= 0 && j < totalCol;
  }

}
