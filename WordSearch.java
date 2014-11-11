// Leetcode 079: Word Search
// Author: Yinjie Huang
// Date: 10/21/2014
//
public class WordSearch {
        public static void main(String[] args) {
                System.out.println("Leetcode 079: Word Search!!!");
                WordSearch ws = new WordSearch();
                char[][] board = new char[][]{{'A','B','C','E'},
                        {'S','F','E','S'},
                        {'A','D','E','E'}};
                String word = "ABCESEEEFS";
                System.out.println(ws.exist(board, word));

        }

        public boolean exist(char[][] board, String word) {  
                int rows = board.length;  
                int cols = board[0].length;  
                boolean[][] visited = new boolean[rows][cols];  
                for (int i = 0; i < rows; i++) {  
                        for (int j = 0; j < cols; j++) {  
                                if (dfs(board, word, 0, i, j, visited)) {
                                        return true;
                                }
                        }  
                }  
                return false;  
        }  
      
        private boolean dfs(char[][] board, String word, int depth, int i, int j, boolean[][] visited) {  
                if (depth == word.length()) {
                        return true;
                }
                if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length) {
                        return false;
                }
                if (visited[i][j]) {  
                        return false;
                }
                if (board[i][j] != word.charAt(depth)) {
                        return false;
                }
                visited[i][j] = true;  
                boolean res = dfs(board, word, depth + 1, i - 1, j, visited)  
                        || dfs(board, word, depth + 1, i + 1, j, visited)  
                        || dfs(board, word, depth + 1, i, j + 1, visited)  
                        || dfs(board, word, depth + 1, i, j - 1, visited);  
                visited[i][j] = false;  
                return res;  
        }
}
