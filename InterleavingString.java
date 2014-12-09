// Leetcode 097: Interleaving String
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class InterleavingString {
        public static void main(String[] args) {
                System.out.println("Leetcode 097: Interleaving String!!!");
                InterleavingString is = new InterleavingString();
                String s1 = "aabcc";
                String s2 = "dbbca";
                String s3 = "aadbbcbcac";
                String s4 = "aadbbbaccc";
                System.out.println(is.isInterleave(s1, s2, s3));
                System.out.println(is.isInterleave(s1, s2, s4));
        }

        public boolean isInterleave(String s1, String s2, String s3) {
                if (s1 == null || s2 == null || s3 == null) {
                        return false;
                }
                if (s1.length() + s2.length() != s3.length()) {
                        return false;
                }
                boolean[][] cache = new boolean[s1.length() + 1][s2.length() + 1];
                cache[0][0] = true;
                for (int i = 1; i <= s1.length(); i++) {
                        if (s1.charAt(i - 1) == s3.charAt(i - 1) && cache[i - 1][0]) {
                                cache[i][0] = true;
                        }
                }

                for (int j = 1; j <= s2.length(); j++) {
                        if (s2.charAt(j - 1) == s3.charAt(j - 1) && cache[0][j - 1]) {
                                cache[0][j] = true;
                        }
                }

                for (int i = 1; i <= s1.length(); i++) {
                        for (int j = 1; j <= s2.length(); j++) {
                                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && cache[i - 1][j]) {
                                        cache[i][j] = true;
                                }
                                if (s2.charAt(j - 1) == s3.charAt(i + j -1) && cache[i][j - 1]) {
                                        cache[i][j] = true;
                                }
                        }
                }

                return cache[s1.length()][s2.length()];
        }
}
