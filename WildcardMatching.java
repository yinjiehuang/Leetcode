// Leetcode 044: Wildcard Matching
// Author: Yinjie Huang
// Date: 11/18/2014
//
import java.util.*;

public class WildcardMatching {
        public static void main(String[] args) {
                System.out.println("Leetcode 044: Wildcard Matching!!!");
                WildcardMatching wm = new WildcardMatching();

                // Test case
                System.out.println(wm.isMatch("aa", "a")); // false
                System.out.println(wm.isMatch("aa", "aa")); // true
                System.out.println(wm.isMatch("aaa", "aa")); // false
                System.out.println(wm.isMatch("aa", "*")); // true
                System.out.println(wm.isMatch("aa", "a*")); // true
                System.out.println(wm.isMatch("ab", "?*")); // true
                System.out.println(wm.isMatch("aab", "c*a*b")); // false
        }

        public boolean isMatch(String s, String p) {
                int i = 0; // index of s
                int j = 0; // index of p
                int star = -1;
                int match = -1;
                while(i < s.length()) {
                        if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                                i++;
                                j++;
                        } else if (j < p.length() && p.charAt(j) == '*') {
                                star = j;
                                j++;
                                match = i;
                        } else if (star != -1) { // We have to go back start matching again
                                j = star + 1;
                                match++;
                                i = match;
                        } else {
                                return false;
                        }
                        
                }
                // This case for multiple *
                while (j < p.length() && p.charAt(j) == '*') {
                        j++;
                }
                return (j == p.length());
        }

        // The following is DP
        /*
         * public boolean isMatch(String s, String p) {
                if (p.length() == 0) {
                	return (s.length() == 0);
                }
                int m = s.length();
                int n = p.length();
                boolean[][] cache = new boolean[m + 1][n + 1];
                cache[0][0] = true;
                for (int j = 0; j < n; j++) {
                	if (p.charAt(j) != '*') {
                		for (int i = 0; i < m; i++) {
                			cache[i + 1][j + 1] = cache[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                		}
                	} else {
                		int i = 0;
                		while (i <= m && !cache[i][j]) {
                			i++;
                		}
                		for (; i <= m; i++) {
                			cache[i][j] = true;
                		}
                	}
                }
                return cache[m][n - 1];
        }*/
}
