// Leetcode 005: Longest Panlindromic Substring
// Author: Yinjie Huang
// Date: 11/24/2014
//
import java.util.*;

public class LongestPalindromicSubstring {
        public static void main(String[] args) {
                System.out.println("Leetcode 005: Longest Palindromic Substring!!!");
                LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
                String s1 = "dabcba";
                System.out.println(lps.longestPalindrome1(s1));
        }

        public String longestPalindrome(String s) {
                // Use Dynamic Programming
                if (s == null || s.length() == 0) {
                        return "";
                }
                int len = s.length();
                boolean[][] cache = new boolean[len][len];
                int max = 0;
                String res = "";
                for (int i = len - 1; i >= 0; i--) {
                        for (int j = i; j < len; j++) {
                                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || cache[i + 1][j - 1])) {
                                        cache[i][j] = true;
                                        if (max < j - i + 1) {
                                                max = j - i + 1;
                                                res = s.substring(i, j + 1);
                                        }
                                }
                        }
                }
                return res;
        }

        public String longestPalindrome1(String s) {
                // This time use the other method
                if (s == null && s.length() == 0) {
                        return "";
                }
                int len = s.length();
                int max = 0;
                String res = "";
                for (int i = 0; i < 2 * len - 1; i++) {
                        int left = i / 2;
                        int right = i / 2;

                        if (i % 2 == 1) {
                                right++;
                        }
                        String str = helper(s, left, right);
                        if (max < str.length()) {
                                max = str.length();
                                res = str;
                        }
                }
                return res;
        }

        public String helper(String s, int left, int right) {
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                }
                return s.substring(left + 1, right);
        }
}
