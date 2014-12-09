// Leetcode: One Edit Distance
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class OneEditDistance {
        public static void main(String[] args) {
                System.out.println("Leetcode: One Edit Distance!!!");
                OneEditDistance oed = new OneEditDistance();

                System.out.println(oed.isOneEditDistance("aec", "aed"));
                System.out.println(oed.isOneEditDistance("abc", "abcd"));
                System.out.println(oed.isOneEditDistance("abc", "abed"));
                System.out.println(oed.isOneEditDistance("abce", "abed"));
        }

        public boolean isOneEditDistance(String s, String t) {
                if (s == null || t == null) {
                        return true;
                }
                int lens = s.length();
                int lent = t.length();
                if (Math.abs(lens - lent) >= 2) {
                        return false;
                }
                int i = 0;
                int j = 0;
                int count = 0;
                int flag = lens >= lent ? 1 : 0;
                while (i < lens && j < lent) {
                        if (s.charAt(i) == t.charAt(j)) {
                                i++;
                                j++;
                        } else {
                                if (count >= 1) {
                                        return false;
                                }
                                if (lens == lent && count < 1) { // When string lengths are the same
                                        count++;
                                        i++;
                                        j++;
                                }
                                if (lens != lent && count < 1) {
                                        count++;
                                        if (flag == 1) {
                                                i++;
                                        } else {
                                                j++;
                                        }
                                }
                        }
                        
                }
                if (lens == lent && count == 0) { // s and t are the same
                        return false;
                }
                int last = flag == 1 ? (lens - 1 - i) : (lent - 1 - j);
                if (lens != lent && last >= 2) {
                        return false;
                }
                if (lens != lent && count > 0 && last == 1) {
                        return false;
                }
                return true;
        }
}
