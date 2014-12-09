// Leetcode 130: Surrounded Regions
// Author: Yinjie Huang
// Date: 11/16/2014
//
import java.util.*;

public class SurroundedRegions {
        public static void main(String[] args) {
                System.out.println("Leetcode 130: Surrounded Regions!!!");
                SurroundedRegions sr = new SurroundedRegions();
                char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, 
                                                {'X', 'O', 'O', 'X'},
                                                {'X', 'X', 'O', 'X'},
                                                {'X', 'O', 'X', 'X'}};
                int row = board.length;
                int col = board[0].length;
                for(int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                System.out.print(board[i][j] + ", ");
                        }
                        System.out.println();
                }
                sr.solve(board);
                System.out.println();
                for(int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                System.out.print(board[i][j] + ", ");
                        }
                        System.out.println();
                }
        }

        public void solve(char[][] board) {
                if (board == null || board.length <= 1 || board[0].length <= 1) {
                        return;
                }
                int row = board.length;
                int col = board[0].length;
                
                for (int i = 0; i < col; i++) {
                        fill(board, 0, i);
                        fill(board, row - 1, i);
                }

                for (int i = 0; i < row; i++) {
                        fill(board, i, 0);
                        fill(board, i, col - 1);
                }

                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                if (board[i][j] == 'O') {
                                        board[i][j] = 'X';
                                } else if(board[i][j] == 'Y') {
                                        board[i][j] ='O';
                                }
                        }
                }
        }

        public void fill(char[][] board, int i, int j) {
                if (board[i][j] == 'X') {
                        return;
                }
                board[i][j] = 'Y';
                int row = board.length;
                int col = board[0].length;
                LinkedList<Integer> queue = new LinkedList<Integer>();
                int code = i * col + j;
                queue.add(code);
                while (!queue.isEmpty()) {
                        int temp = queue.poll();
                        int indexi = temp / col;
                        int indexj = temp % col;

                        if (indexi > 0 && board[indexi - 1][indexj] == 'O') {
                                queue.add(col * (indexi - 1) + indexj);
                                board[indexi - 1][indexj] = 'Y';
                        }

                        if (indexi < row - 1 && board[indexi + 1][indexj] == 'O') {
                                queue.add(col * (indexi + 1) + indexj);
                                board[indexi + 1][indexj] = 'Y';
                        }

                        if (indexj > 0 && board[indexi][indexj - 1] == 'O') {
                                queue.add(col * indexi + indexj - 1);
                                board[indexi][indexj - 1] = 'Y';
                        }

                        if (indexj < col - 1 && board[indexi][indexj + 1] == 'O') {
                                queue.add(col * indexi + indexj + 1);
                                board[indexi][indexj + 1] = 'Y';
                        }
                }
        }
}
