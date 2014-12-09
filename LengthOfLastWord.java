// Leetcode 058: Lenght of Last Word
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class LengthOfLastWord {
        public static void main(String[] args) {
                System.out.println("Leetcode 058: Length of Last Word!!!");
                LengthOfLastWord lolw = new LengthOfLastWord();
                System.out.println(lolw.lengthOfLastWord("This is world"));
        }

        public int lengthOfLastWord(String s) {
                if (s == null || s.length() == 0) {
                        return 0;
                }
                int count = 0;
                // trim the " " at the length of the string
                int n = s.length() - 1;
                while ( n >= 0) {
                        if (s.charAt(n) != ' ') {
                                break;
                        }
                        n--;
                }
                for (int i = n; i >= 0; i--) {
                        if (s.charAt(i) == ' ') {
                                break;
                        }
                        count++;
                }
                return count;
        }
}
