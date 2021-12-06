package com.scalar.topics.BatchShiftTest;

import java.util.ArrayList;

public class MinimumLightsToActivate {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();

    /*arr.add(1);
    arr.add(1);
    arr.add(0);
    arr.add(0);
    arr.add(1);
    arr.add(1);
    int B = 1;*/

    /*arr.add(0);
    arr.add(0);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(0);
    arr.add(0);
    arr.add(1);
    int B = 3;*/

    /*arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(1);
    arr.add(0);
    arr.add(0);
    int B = 3;*/

    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(1);
    arr.add(1);
    arr.add(0);
    arr.add(1);
    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(0);
    arr.add(1);
    arr.add(0);
    arr.add(0);
    int B = 4;

    int sol = solve(arr, B);
    System.out.println("Min light to turn on: " + sol);
  }

  public static int solve(ArrayList<Integer> A, int B) {

    int minCount = 0;

    //-----------
    if (A != null && A.size() >= 1) {
      int i = 0;
      int n = A.size();
      int range = (B * 2) - 1;
      int minLightRequired = n % range;
      int span = range - (1 + (range - 1) / 2);

      // If span is 0, i.e. Power is 1, then there should be no faulty bulb and we require to turn on all the bulb to lit the whole corridor.

      //1. If there is no working-light from 0 to B-1, corridor can not be lit
      while (i < B) {
        if (A.get(i) == 1) {
          break;
        }
        i++;
      }
      // Means there is no working light till B-1, return -1
      if (i == B) {
        return -1;
      }

      //reset i t0 start
      i = 0;

      while (i <= (n - 1 - span)) {
        int litIndx = -1;
        if (A.get(i) == 1) {
          litIndx = i;
          int low = i + 1;
          int high = i + span;

          //if this lit-index covers till the end of the corridor(n-1), return min-count
          if(litIndx+span == n-1){
            return minCount;
          }

          while (low <= high) {
            if (A.get(low) == 1) {
              litIndx++;
            }
            low++;
          }

          if (litIndx >= 0) {
            minCount++;
            i = high + 1;
          } else {
            return -1;
          }

          if (A.get(i) == 0) {
            //Backtrack
            while (i-- > litIndx) {
              if (A.get(i) == 1 && B > 1) {
                break;
              } else if (i <= litIndx) {
                //On backtrack, if we reached back to last lit-index i.e.if no 1 found, return -1
                return -1;
              }
            }


          }
        } else {
          i++;
        }

      }

    }
    return minCount;
  }

}
