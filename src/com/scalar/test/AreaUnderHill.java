package com.scalar.test;

import java.util.ArrayList;
import java.util.List;

public class AreaUnderHill {

  public static void main(String[] args) {
    List<Integer> A = new ArrayList<>();
    /*A.add(1);
    A.add(2);
    A.add(3);
    A.add(4);
    A.add(5);
    A.add(4);*/

    Integer[] arr = new Integer[]{45938332, 56695838, 434610699, 244477852, 442706146, 332835816, 450399266, 228766405, 202638365, 306607267, 401594990, 430341756, 233848629, 75204867, 354225361, 96541963, 5672533, 212164013, 78680098, 444857169, 351541353, 122483760, 58319678, 219143217, 291884722, 55615334, 396837969, 212421501, 373743694, 346524544, 397748501, 63705888, 355166082, 434650078, 86538054, 371857968, 334862144, 411036383, 91434814, 174635581, 223951112, 348272869, 138817934, 371010249, 74313343, 432077653, 50046392, 134774168, 292535717, 432188727, 114296192, 170293994, 229709946, 426896738};

    for (int i : arr) {
      A.add(i);
    }
    //A.add(Arrays.asList(arr));

    System.out.println("Area: "+solve(A));
  }

  public static String solve(List<Integer> A) {

    double totalArea = 0;
    for (int i = 0; i < A.size(); i++) {

      if (i == 0) {
        double areTriangle = 0.5 * A.get(i) * 1;
        System.out.println("area Trinagle:"+areTriangle);
        totalArea += areTriangle;
      } else {
        double areaRect = Math.min(A.get(i), A.get(i - 1)) * 1;
        double areTriangle = 0.5 * Math.abs(A.get(i) - A.get(i - 1)) * 1;
        System.out.println("area Trinagle:"+areTriangle);
        System.out.println("area areaRect:"+areaRect);
        totalArea += (areaRect + areTriangle);
      }

      System.out.println("---------");
    }

    double areTriangle = 0.5 * A.get(A.size() - 1) * 1;
    System.out.println("area last Trinagle:"+areTriangle);

    totalArea += areTriangle;
    return String.valueOf((int) totalArea);
  }
}