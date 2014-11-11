// Leetcode 064: Minimum Path Sum
// Author: Yinjie Huang
// Date: 11/03/2014
//
import java.util.*;

public class MinimumPathSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 064: Minimum Path Sum!!!");
                MinimumPathSum mps = new MinimumPathSum();
                int[][] grid = new int[][]{{1, 2, 3, 4}, {7, 11, 3, 1}, {5, 7, 9, 10}};
                System.out.println(mps.minPathSum(grid));
        }

        public int minPathSum(int[][] grid) {
                int m = grid.length; // row
                int n = grid[0].length; //col
                int[][] cache = new int[m][n];

                cache[0][0] = grid[0][0];
                for (int i = 1; i < n; i++) {
                        cache[0][i] = cache[0][i - 1] + grid[0][i];
                }
                for (int i = 1; i < m; i++) {
                        cache[i][0] = cache[i - 1][0] + grid[i][0];
                }
                for (int i = 1; i < m; i++) {
                        for (int j = 1; j < n; j++) {
                                cache[i][j] = grid[i][j] + Math.min(cache[i - 1][j], cache[i][j - 1]);
                        }
                }
                return cache[m - 1][n - 1];
        }
}
