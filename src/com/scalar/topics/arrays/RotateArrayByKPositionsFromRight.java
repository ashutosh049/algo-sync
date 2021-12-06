package com.scalar.topics.arrays;

import static com.util.Util.printArray;

public class RotateArrayByKPositionsFromRight {

  public static void main(String[] args) {

    int[] arr0 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int k = 3;

    System.out.println("Original : ");
    printArray(arr0);

    //rotate(arr0, k);
    rotate(arr0, k % arr0.length);
    System.out.println("\nRotated by " + k + " positions : ");
    System.out.println(k + " % " + (arr0.length) + "= " + (k % arr0.length));
    printArray(arr0);

    int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    k = 11;
    rotate(arr1, k % arr1.length);
    System.out.println("\nRotated by " + k + " positions : ");
    System.out.println(k + " % " + (arr1.length) + "= " + (k % arr1.length));
    printArray(arr1);

  }

  /*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCases = Integer.valueOf(sc.nextLine().trim());

    for(int t=0; t<testCases; t++){
      int arrLength = Integer.valueOf(sc.next().trim());
      int[] arr = new int[arrLength];

      for(int i=0; i<arrLength; i++){
        String val = sc.next().trim();
        arr[i] = Integer.valueOf(val);
      }
      sc.nextLine();
      int roatetBy = Integer.valueOf(sc.nextLine().trim());

      rotate(arr, roatetBy);
    }

  }*/

  /*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCases = Integer.valueOf(sc.nextLine().trim());

    for (int t = 0; t < testCases; t++) {

      String arrLine = sc.nextLine().trim();

      String[] arrLineArr = arrLine.split(" ");

      int[] arr = new int[Integer.valueOf(arrLineArr[0])];

      for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.valueOf(arrLineArr[i+1]);
      }
      int roatetBy = Integer.valueOf(sc.nextLine().trim());

      rotate(arr, roatetBy);
    }
    sc.close();

  }*/

  public static void rotate(int[] arr, int k) {

    int n = arr.length;

    //Step-2: Reverse All
    reverse2Pointer(arr, 0, n);

    //Step-2: Reverse left part
    reverse2Pointer(arr, 0, k);

    //Step-3: Reverse right part
    reverse2Pointer(arr, k, n);
    //printArray(arr);
  }

  public static void reverse2Pointer(int[] arr, int low, int high) {
    int i = low;
    int j = high - 1;
    while (i < j) {
      int tmp = arr[j];
      arr[j] = arr[i];
      arr[i] = tmp;
      i++;
      j--;
    }
  }
}
