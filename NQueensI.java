// Leetcode 051: N-Queens I
// Author: Yinjie Huang
// Date: 11/14/2014
//
import java.util.*;

public class NQueensI {
        public static void main(String[] args) {
                System.out.println("Leetcode 051: N-Queens I!!!");
                NQueensI nqi = new NQueensI();
                ArrayList<String[]> res = new ArrayList<String[]>();
                int n = 4;
                res = nqi.solveNQueens(n);
                for(String[] sa : res) {
                        for (String s : sa) {
                                System.out.println(s);
                        }
                        System.out.println();
                        System.out.println();
                }
        }

        public ArrayList<String[]> solveNQueens(int n) {
                ArrayList<String[]> res = new ArrayList<String[]>();
                int[] v = new int[n];
                dfs(res, v, n, 0);
                return res;
        }

        public void dfs(ArrayList<String[]> res, int[] v, int n, int d) {
                if (d == n) {
                        // int[] v contains one solution
                        String[] sofar = new String[n];
                        for (int i = 0; i < n; i++) {
                                StringBuffer sb = new StringBuffer();
                                for (int j = 0; j < n; j++) {
                                        if (j == v[i]) {
                                                sb.append("Q");
                                        } else {
                                                sb.append(".");
                                        }
                                }
                                sofar[i] = sb.toString();
                        }
                        res.add(sofar);
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
