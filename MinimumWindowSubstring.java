// Leetcode 076: Minimum Window Substring
// Author: Yinjie Huang
// Date: 11/27/2014
//
import java.util.*;

public class MinimumWindowSubstring {
        public static void main(String[] args) {
                System.out.println("Leetcode 076: Minimum Window Substring!!!");
                MinimumWindowSubstring mws = new MinimumWindowSubstring();
                String S = "ADOBECODEBANC";
                String T = "ABC";
                System.out.println(mws.minWindow(S, T));
        }

        public String minWindow(String S, String T) {
                if (S == null || S.length() == 0) {
                        return "";
                }
                HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
                for (int i = 0; i < T.length(); i++) {
                        if (hm.containsKey(T.charAt(i))) {
                                hm.put(T.charAt(i), hm.get(T.charAt(i)) + 1);
                        } else {
                                hm.put(T.charAt(i), 1);
                        }
                }
                int s = 0, count = 0;
                int minlen = S.length() + 1;
                int strs = 0;
                // Here we move the window
                for (int e = 0; e < S.length(); e++) {
                        if (hm.containsKey(S.charAt(e))) {
                                hm.put(S.charAt(e), hm.get(S.charAt(e)) - 1);
                                // If we find the character, we move the right window
                                if (hm.get(S.charAt(e)) >= 0) {
                                        count++;
                                }
                                // If the count satisfies the T length, we record the length, and move the left
                                while (count == T.length()) {
                                        if (e - s + 1 < minlen) {
                                                minlen = e - s + 1;
                                                strs = s;
                                        }
                                        if (hm.containsKey(S.charAt(s))) {// ready to move the left window
                                                hm.put(S.charAt(s), hm.get(S.charAt(s)) + 1);
                                                if (hm.get(S.charAt(s)) > 0) {
                                                        count--;
                                                }
                                        }
                                        s++;
                                }
                        }
                }
                if (minlen > S.length()) {
                        return "";
                }
                return S.substring(strs, strs + minlen);
        }
}
