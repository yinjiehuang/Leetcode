// Leetcode: Longest Substring With At Most Two Distinct Characters
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
        public static void main(String[] args) {
                System.out.println("Leetcode: Longest Substring With At Most Two Distinct Characters!!!");
                LongestSubstringWithAtMostTwoDistinctCharacters ls = new LongestSubstringWithAtMostTwoDistinctCharacters();
                String s = "eceba";
                System.out.println(ls.lengthOfLongestSubstringTwoDistinct(s));
        }

        public int lengthOfLongestSubstringTwoDistinct(String s) {
                if (s == null || s.length() == 0) {
                        return 0;
                }
                if (s.length() <= 2) {
                        return s.length();
                }
                HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
                int max = 0;
                int l = 0;
                for (int r = 0; r < s.length(); r++) {
                        char c = s.charAt(r);
                        if (hm.containsKey(c)) {
                                hm.put(c, hm.get(c) + 1);
                        } else {
                                hm.put(c, 1);
                        }
                        // Check if we have more than two characters
                        if (hm.size() > 2) {// moving left window
                                while (true) {
                                        char cl = s.charAt(l);
                                        if (hm.get(cl) == 1) {
                                                hm.remove(cl);
                                                l++;
                                                break;
                                        } else {
                                                hm.put(cl, hm.get(cl) - 1);
                                                l++;
                                        }
                                }
                        }
                        max = Math.max(max, r - l + 1);
                }
                return max;
        }
}
