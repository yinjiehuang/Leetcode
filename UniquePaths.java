// Leetcode 069: Unique Paths
// Author: Yinjie Huang
// Date: 10/29/2014
//
import java.util.*;

public class UniquePaths {
        public static void main(String[] args) {
                System.out.println("Leetcode 069: Unique Paths!!!");
                UniquePaths up = new UniquePaths();
                System.out.println(up.uniquePaths(5,5));
        }

        public int uniquePaths(int m, int n) {
                // A very typical DP
                int[][] cache = new int[m][n];
                for (int i = 1; i < m; i++) {
                        cache[i][0] = 1;
                }
                for (int i = 1; i < n; i++) {
                        cache[0][i] = 1;
                }
                for (int i = 1; i < m; i++) {
                        for (int j = 1; j < n; j++) {
                                cache[i][j] = cache[i-1][j] + cache[i][j-1];
                        }
                }
                return cache[m-1][n-1];
        }
}
