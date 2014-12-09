// Leetcode 052: N-Queens II
// Author: Yinjie Huang
// Date: 11/14/2014
//
import java.util.*;

public class NQueensII {
        public static void main(String[] args) {
                System.out.println("Leetcode 052: N-Queens II!!!");
                NQueensII nqii = new NQueensII();
                int n = 4;
                System.out.println(nqii.totalNQueens(n));
        }

        public int totalNQueens(int n) {
                int[] res = new int[]{0};
                int[] v = new int[n];
                dfs(res, v, n, 0);
                return res[0];
        }

        public void dfs(int[] res, int[] v, int n, int d) {
                if (d == n) {
                        // int[] v contains one solution
                        res[0]++;
                        return;
                }
                // We scan line by line
                for (int i = 0; i < n; i++) {
                        v[d] = i;
                        if (isValid(d, v)) {
                                dfs(res, v, n ,d + 1);
                        }
                }
        }

        public boolean isValid(int d, int[] v) {
                for (int i = 0; i < d; i++) {
                        if (v[i] == v[d] || Math.abs(v[d] - v[i]) == d - i) {
                                return false;
                        }
                }
                return true;
        }
}
