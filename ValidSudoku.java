// Leetcode 036: Valid Sudoku
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class ValidSudoku {
        public static void main(String[] args) {
                System.out.println("Leetcode 036: Valid Sudoku!!!");
                ValidSudoku vs = new ValidSudoku();
                char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.','.'},
                                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                                {'8', '.', '.' ,'.', '6', '.', '.', '.' ,'3'},
                                                {'4', '.', '.' ,'8', '.', '3', '.', '.', '1'},
                                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
                System.out.println(vs.isValidSudoku(board));
        }

        public boolean isValidSudoku(char[][] board) {
                // should be a matrix of 9 X 9
                HashMap<Integer, String> hm = new HashMap<Integer, String>();
                for (int i = 0; i < 9; i++) {
                        if (!hm.containsKey(i)) {
                                hm.put(i, "");
                        }
                        for (int j = 0; j < 9; j++) {
                                if (!hm.containsKey(9 + j)) {
                                        hm.put(9 + j, "");
                                }
                                if (board[i][j] != '.') {
                                        String s1 = hm.get(i);
                                        String s2 = hm.get(j + 9);
                                        int code = 3 * (int) (i / 3) + (int) (j / 3) + 19;
                                        
                                        if (!hm.containsKey(code)) {
                                                hm.put(code, "");
                                        }
                                        String s3 = hm.get(code);
                                        String str = "" + board[i][j];
                                        if (s1.contains(str) || s2.contains(str) || s3.contains(str)) {
                                                return false;
                                        }
                                        hm.put(i, s1 + str);
                                        hm.put(j + 9, s2 + str);
                                        hm.put(code, s3 + str);
                                }
                        }
                }
                return true;
        }
}
