package com.scalar.classroom.day11_intro_to_hashing;

import com.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

  public static void main(String[] args) {

    //[ "cat", "dog", "god", "tca" ]

    ArrayList<ArrayList<Integer>> solList = anagrams(
        Arrays.asList(new String[]{"cat", "dog", "god", "tca"}));

    System.out.println("-----solList-----");
    Util.printArrayListMatrix(solList);

    solList = anagrams(
        Arrays.asList(new String[]{
            "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
            "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
            "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
            "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
            "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
            "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
            "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
            "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"}));

    System.out.println("-----solList-----");
    Util.printArrayListMatrix(solList);

  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    ArrayList<ArrayList<Integer>> solList = new ArrayList<>();

    if (A != null && A.size() >= 1) {

      for (int i = 0; i < A.size(); i++) {
        ArrayList<Integer> groupList = new ArrayList<>();
        groupList.add(i + 1);
        for (int j = i + 1; j < A.size(); j++) {
          if (isAnagram(A.get(i), A.get(j))) {

            /*if (!groupList.contains(i + 1)) {
              groupList.add(i + 1);
            }*/
            groupList.add(j + 1);
          }
        }
                /*if(anagramFound){
                    groupList.add(i+1);
                }*/
        if (groupList.size() >= 1) {
          solList.add(groupList);
        }

      }

    }

    return solList;
  }
    
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }*/

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char charArrayS[] = s.toCharArray();
    Arrays.sort(charArrayS);
    String s1 = new String(charArrayS);

    char charArrayT[] = t.toCharArray();
    Arrays.sort(charArrayT);
    String t1 = new String(charArrayT);

    //System.out.println("s1=" + s1 + ", t1=" + t1 + ", equals = " + (s1.equals(t1)));

    return s1.equals(t1);
  }

  public ArrayList<ArrayList<Integer>> anagramsMap(final List<String> inputStringList) {
    ArrayList<ArrayList<Integer>> solList = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> anagramMap = new HashMap<>();
    int n = inputStringList.size();


    for (int i = 0; i < n; i++) {
      char[] arr = inputStringList.get(i).toCharArray();
      Arrays.sort(arr);
      String str = new String(arr);
      if (anagramMap.get(str) != null) {
        anagramMap.get(str).add(i + 1);
      } else {
        ArrayList<Integer> g = new ArrayList<>();
        g.add(i + 1);
        anagramMap.put(str, g);
      }
    }

    for (ArrayList<Integer> l : anagramMap.values()) {
      solList.add(l);
    }

    return solList;
  }
}
