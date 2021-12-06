package com.scalar.classroom.day11_intro_to_hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 *
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 *  Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem</pre>
 */
public class ValidSudoke {

  public int isValidSudoku(final List<String> A) {

    Map<Integer, Integer>[] rowMap = new HashMap[9];
    Map<Integer, Integer>[] colMap = new HashMap[9];
    Map<Integer, Integer>[] boxMap = new HashMap[9];

    for (int i = 0; i < 9; i++) {
      rowMap[i] = new HashMap<Integer, Integer>();
      colMap[i] = new HashMap<Integer, Integer>();
      boxMap[i] = new HashMap<Integer, Integer>();
    }

    if (A != null && A.size() == 9) {
      for (int i = 0; i < 9; i++) {
        String values = A.get(i);
        char[] charValues = values.toCharArray();
        for (int j = 0; j < 9; j++) {
          char num = charValues[j];
          if (num != '.') {
            int n = (int) num;
            int box_index = (i / 3) * 3 + j / 3;

            rowMap[i].put(n, rowMap[i].getOrDefault(n, 0) + 1);
            colMap[j].put(n, colMap[j].getOrDefault(n, 0) + 1);
            boxMap[box_index].put(n, boxMap[box_index].getOrDefault(n, 0) + 1);

            if (rowMap[i].get(n) > 1 || colMap[j].get(n) > 1 || boxMap[box_index].get(n) > 1) {
              return 0;
            }

          }
        }
      }
    }

    return 1;

  }

}
