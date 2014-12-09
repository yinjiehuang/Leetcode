// Leetcode 132: Palindrome Partition II
// Author: Yinjie Huang
// Date: 11/17/2014
//
import java.util.*;

public class PalindromePartitioningII {
        public static void main(String[] args) {
                System.out.println("Leetcode 132: Palindrome Partition II!!!");
                PalindromePartitioningII ppii = new PalindromePartitioningII();
                String s = "aab";
                System.out.println(ppii.minCut(s));
        }

        public int minCut(String s) {
                if (s == null || s.length() ==0) {
                        return 0;
                }
                int len = s.length();
                boolean[][] cache = new boolean[len][len];
                int[] cuts = new int[len];

                for (int i = len -1 ; i >= 0; i--) {
                        for (int j = i; j < len; j++) {
                                if (j - i < 2 && s.charAt(i) == s.charAt(j) || cache[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                                        cache[i][j] = true;
                                }
                        }
                }
                
                for (int i = 0; i < len; i++) {
                        int temp = len;
                        if (cache[0][i]) {
                                cuts[i] = 0;
                        } else {
                                for (int j = 0; j < i; j++) {
                                        if (cache[j + 1][i]) {
                                                temp = Math.min(temp, cuts[j] + 1);
                                        }
                                }
                                cuts[i] = temp;
                        }
                }

                return cuts[len - 1];
        }
}
