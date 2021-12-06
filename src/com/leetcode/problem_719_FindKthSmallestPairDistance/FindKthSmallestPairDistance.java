package com.leetcode.problem_719_FindKthSmallestPairDistance;

import com.util.Util;
import java.util.Arrays;

class FindKthSmallestPairDistance {

  public static void main(String[] args) {
    int[] nums = new int[]{15, 2, 7, 3, 4, 9, 11, 19};
    int k = 6;
    System.out.println("sol(" + k + "): " + smallestDistancePair(nums, k));
  }

  public static int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int WIDTH = 2 * nums[nums.length - 1];

    System.out.println("Windth: " + WIDTH);

    System.out.println("sorted array::");
    Util.printArray(nums);

    //multiplicity[i] = number of nums[j] == nums[i] (j < i)
    int[] multiplicity = new int[nums.length];
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1]) {
        multiplicity[i] = 1 + multiplicity[i - 1];
      }
    }

    System.out.println("multiplicity array::");
    Util.printArray(multiplicity);

    //prefix[v] = number of values <= v
    int[] prefix = new int[WIDTH];
    int left = 0;
    for (int i = 0; i < WIDTH; ++i) {
      while (left < nums.length && nums[left] == i) {
        left++;
      }
      prefix[i] = left;
    }
    System.out.println("Prefix array::");
    Util.printArrayWithIndices(prefix);

    int lo = 0;
    int hi = nums[nums.length - 1] - nums[0];
    while (lo < hi) {
      int mi = (lo + hi) / 2;
      int count = 0;
      for (int i = 0; i < nums.length; ++i) {
        count += prefix[nums[i] + mi] - prefix[nums[i]] + multiplicity[i];
      }
      //count = number of pairs with distance <= mi
      if (count >= k) {
        hi = mi;
      } else {
        lo = mi + 1;
      }
    }
    return lo;
  }

  static int smallestDistancePair_1(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];

    while (left < right) {
      int mid = left + (right - left) / 2;
      int cnt = 0;
      int start = 0;

      for (int i = 0; i < n; ++i) {
        while (start < n && nums[i] - nums[start] > mid) {
          ++start;
        }
        cnt += i - start;
      }

      if (cnt < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return right;
  }

  public int smallestDistancePair_2(int[] nums, int k) {

    Arrays.sort(nums);

    int left = 0;
    int right = nums[nums.length-1]-nums[0];  //max distance
    //so we will find the range of differences that can be present in this array

    while(left <= right){
      int mid = left + (right-left)/2;

      int count = findPair(nums,mid);

      if(count >= k){
        right = mid-1;
      }else{
        left = mid+1;
      }
    }

    return left;
  }

  private int findPair(int[]nums,int currDist){
    int left = 0;
    int right = 0;
    int count = 0;
    int n = nums.length;

    for( left = 0; left < n;left++){
      while(nums[left] - nums[right] > currDist && right < left){
        right++;
        count += n-left;
      }
    }

    return n * (n - 1) / 2 - count;

  }

}