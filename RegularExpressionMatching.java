// Leetcode 010: Regular Expression Matching
// Author: Yinjie Huang
// Date: 11/17/2014
//
import java.util.*;

public class RegularExpressionMatching {
        public static void main(String[] args) {
                System.out.println("Leetcode 010: Regular Expression Matching!!!");
                RegularExpressionMatching rem = new RegularExpressionMatching();
                //Testcase
                //
                System.out.println(rem.isMatch("aa", "a")); //false
                System.out.println(rem.isMatch("aa", "aa")); //true
                System.out.println(rem.isMatch("aaa", "aa")); //false
                System.out.println(rem.isMatch("aa", "a*")); //false
                System.out.println(rem.isMatch("aa", ".*")); //true
                System.out.println(rem.isMatch("ab", ".*")); //true
                System.out.println(rem.isMatch("aab", "c*a*b")); //true
        }

        public boolean isMatch(String s, String p) {
                if (p.length() == 0) {
                        return (s.length() == 0);
                }
                // Test when length is 1
                if (p.length() == 1) {
                        return (s.length() == 1) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
                }

                // Here comes the complicated case, ca
                if (p.charAt(1) != '*') {
                        if (s.length() == 0) {
                                return false;
                        } else {
                                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
                        }
                } else {
                        while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                                if (isMatch(s, p.substring(2))) {
                                        return true;
                                }
                                s = s.substring(1);
                        }
                        return isMatch(s, p.substring(2));
                }
        }
}
