// Leetcode 087: Scramble String
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class ScrambleString {
        public static void main(String[] args) {
                System.out.println("Leetcode 087: Scramble String!!!");
                ScrambleString ss = new ScrambleString();
                System.out.println(ss.isScramble("aa", "aa"));
        }

        public boolean isScramble(String s1, String s2) {
                if (s1.length() != s2.length()) {
                        return false;
                }
                if (s1.length() == 1 && s2.length() == 1) {
                        return s1.charAt(0) == s2.charAt(0);
                }
                // This part is used to cut out recursion to make this algorithm efficient
                char[] t1 = s1.toCharArray();
                char[] t2 = s2.toCharArray();
                Arrays.sort(t1);
                Arrays.sort(t2);
                if (!new String(t1).equals(new String(t2))) {
                        return false;
                }


                if (s1.equals(s2)) {
                        return true;
                }
                for (int i = 1; i < s1.length(); i++) {
                        // case 1
                        String s1seg1 = s1.substring(0, i);
                        String s1seg2 = s1.substring(i);

                        String s2seg1 = s2.substring(0, i);
                        String s2seg2 = s2.substring(i);

                        if (isScramble(s1seg1, s2seg1) && isScramble(s1seg2, s2seg2)) {
                                return true;
                        }

                        s2seg1 = s2.substring(0, s2.length() - i);
                        s2seg2 = s2.substring(s2.length() - i);

                        if (isScramble(s1seg1, s2seg2) && isScramble(s1seg2, s2seg1)) {
                                return true;
                        }
                }

                return false;
        }
}
