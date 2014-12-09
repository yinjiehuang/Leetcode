// Leetcode: Longest Common Prefix
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class LongestCommonPrefix {
        public static void main(String[] args) {
                System.out.println("Leetcode: Longest Common Prefix!!!");
                LongestCommonPrefix lcp = new LongestCommonPrefix();
                String[] strs = new String[]{"aat", "aa4", "aa1", "aa"};
                System.out.println(lcp.longestCommonPrefix(strs));
        }

        public String longestCommonPrefix(String[] strs) {
                StringBuffer sb = new StringBuffer();
                if (strs == null || strs.length == 0) {
                        return sb.toString();
                }
                for (int i = 0; i < strs[0].length(); i++) {
                        char c = strs[0].charAt(i);
                        // let's search over all the strings in the array
                        for (int j = 1; j < strs.length; j++) {
                                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                                        return strs[0].substring(0, i);
                                }
                        }
                }
                return strs[0];
        }
}
