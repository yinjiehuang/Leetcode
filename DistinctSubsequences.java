// Leetcode 115: Distinct Subsequences
// Author: Yinjie Huang
// Date: 11/29/2014
//
import java.util.*;

public class DistinctSubsequences {
        public static void main(String[] args) {
                System.out.println("Leetcode 115: Distinct Subsequences!!!");
                DistinctSubsequences ds = new DistinctSubsequences();
                String S = "rabbbit";
                String T = "rabbit";
                System.out.println(ds.numDistinct(S, T));
        }

        public int numDistinct(String S, String T) {
                int len1 = S.length(); // col
                int len2 = T.length(); // row

                int[][] cache = new int[len2 + 1][len1 + 1];
                cache[0][0] = 1;
                
                for (int i = 1; i <= len1; i++) {
                        cache[0][i] = 1;
                }
                for (int i = 1; i <= len2; i++) {
                        cache[i][0] = 0;
                }

                for (int i = 1; i <= len2; i++) {
                        for (int j = 1; j <= len1; j++) {
                                cache[i][j] = cache[i][j - 1];
                                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                                        cache[i][j] += cache[i - 1][j - 1];
                                }
                        }
                }
                return cache[len2][len1];
        }
}
