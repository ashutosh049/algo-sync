package com.scalar.classroom.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubArrayWith0Sum {

  public int solve(ArrayList<Integer> nums) {
       
       /*int count = 0, sum = 0;
       int k=0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            if (map.containsKey(sum - k)){
                return 1;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return 0;*/

    long sum = 0;
    Set<Long> hs = new HashSet<>();

    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      if (nums.get(i) == 0 || sum == 0 || hs.contains(sum)) {
        return 1;
      }
      hs.add(sum);
    }

    return 0;
  }
}
