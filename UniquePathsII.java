// Leetcode 063: Unique Paths II
// Author: Yinjie Huang
// Date: 11/03/2014
//
import java.util.*;

public class UniquePathsII {
        public static void main(String[] args) {
                System.out.println("Leetcode 063: Unique Paths II!!!");
                UniquePathsII up = new UniquePathsII();
                int[][] m = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
                System.out.println(up.uniquePathsWithObstacles(m));
        }

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
                // Still, this is dp problem
                if (obstacleGrid[0][0] == 1) {
                        return 0;
                }
                int m = obstacleGrid.length;
                int n = obstacleGrid[0].length;

                int[][] cache = new int[m][n];
                cache[0][0] = 1;
                for (int i = 1; i < n; i++) {
                        if (obstacleGrid[0][i] == 0) {
                                cache[0][i] = 1;
                        } else {
                                break;
                        }
                }
                for (int i = 1; i < m; i++) {
                        if (obstacleGrid[i][0] == 0) {
                                cache[i][0] = 1;
                        } else {
                                break;
                        }
                }
                for (int i = 1; i < n; i++) {
                        for (int j = 1; j < m; j++) {
                                if (obstacleGrid[j][i] == 0) {
                                        cache[j][i] = cache[j - 1][i] + cache[j][i - 1];
                                }
                        }
                }
                return cache[m-1][n-1];
        }
}
