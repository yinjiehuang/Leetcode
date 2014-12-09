// Leetcode 003: Longest Substring Without Repeating Characters
// Author: Yinjie Huang
// Date: 11/20/2014

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
        public static void main(String[] args) {
                System.out.println("Leetcode 003: Longest Substring Without Repeating Characters!!!");
                LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
                String s1 = "abcabcbb";
                String s2 = "bbbbb";
                System.out.println(lswrc.lengthOfLongestSubstring(s1));
                System.out.println(lswrc.lengthOfLongestSubstring(s2));
        }

        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if (len < 2) {
                    return len;
            }
            HashSet<Character> hs = new HashSet<Character>();
            int max = -1;
            int w = 0;
            int r = 0;
            while (r < len) {
                    char c = s.charAt(r);
                    if (!hs.contains(c)) {
                            hs.add(c);
                            r++;
                    } else {
                            max = max >= r - w ? max: r - w;
                            while (s.charAt(w) != c) {
                                    hs.remove(s.charAt(w));
                                    w++;
                            }
                            w++;
                            r++;
                    }
            }
            return Math.max(max, r - w);
        }
}
