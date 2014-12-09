// Leetcode 037: Sudoku Solver
// Author: Yinjie Huang
// Date: 11/25/2014
//
import java.util.*;

public class SudokuSolver {
        public static void main(String[] args) {
                System.out.println("Leetcode 037: Sudoku Sovler!!!");
                SudokuSolver ss = new SudokuSolver();
                 char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.','.'},
                                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                                {'8', '.', '.' ,'.', '6', '.', '.', '.' ,'3'},
                                                {'4', '.', '.' ,'8', '.', '3', '.', '.', '1'},
                                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
                ss.solveSudoku(board);
                for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                                System.out.print(board[i][j] + ",");
                        }
                        System.out.println();
                }
        }

        public void solveSudoku(char[][] board) {
                ArrayList<HashSet<Character>> al = new ArrayList<HashSet<Character>>();
                for (int i = 0; i < 27; i++) {
                        al.add(new HashSet<Character>());
                }
                // Fill in the HashSet
                for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                                if (board[i][j] != '.') {
                                        // when we have a character, we need to put in three different hashset
                                        int code = 3 * (int) (i / 3) + (int) (j / 3) + 18;
                                        al.get(i).add(board[i][j]);
                                        al.get(j + 9).add(board[i][j]);
                                        al.get(code).add(board[i][j]);
                                }
                        }
                }
                helper(board, al);
        }

        public boolean helper(char[][] board, ArrayList<HashSet<Character>> al) {
                for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                                if (board[i][j] == '.') {
                                        int code = 3 * (int) (i /3) + (int) (j / 3) + 18;
                                        for (char c = '1'; c <= '9'; c++) {
                                                if (!al.get(i).contains(c) && !al.get(j + 9).contains(c) && !al.get(code).contains(c)) {
                                                        board[i][j] = c;
                                                        
                                                        al.get(i).add(c);
                                                        al.get(j + 9).add(c);
                                                        al.get(code).add(c);
                                                        if (helper(board, al)) {
                                                                return true;
                                                        } else {
                                                                board[i][j] = '.';
                                                                al.get(i).remove(c);
                                                                al.get(j + 9).remove(c);
                                                                al.get(code).remove(c);
                                                        }
                                                }
                                        }
                                        return false;
                                }
                        }
                }
                return true;
        }
}
