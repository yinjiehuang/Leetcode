// Leetcode 125: Valid Palindrome
// Author: Yinjie Huang
// Data: 10/07/2014
//
import java.util.*;

public class ValidPalindrome {
        public static void main(String[] args) {
                System.out.println("Leetcode 125: Valid Palindrome!!!");
                ValidPalindrome vp = new ValidPalindrome();

                // Testcase 1
                String s1 = "A man, a plan, a canal: Panama";
                System.out.println(vp.isPalindrome(s1));
        }

        public boolean isPalindrome(String s) {
                if (s == null) {
                        return false;
                }
                if (s.length() == 0) {
                        return true;
                }
                s = s.toLowerCase();
                char[] array = s.toCharArray();
                int i = 0;
                int j = array.length - 1;
                while (i < j) {
                        while (i < j && !isValid(array[i])) {
                                i++;
                        }
                        while (i < j && !isValid(array[j])) {
                                j--;
                        }
                        if (array[i] != array[j]) {
                                return false;
                        }
                        i++;
                        j--;
                }
                return true;
        }

        public boolean isValid(char c) {
                if (c >= 'a' && c <= 'z') {
                        return true;
                } else if (c >= '0' && c <= '9') {
                        return true;
                } else {
                        return false;
                }
        }
}
