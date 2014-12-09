// Leetcode 009: Palindrome Number
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class PalindromeNumber {
        public static void main(String[] args) {
                System.out.println("Leetcode 009: Palindrome Number!!!");
                PalindromeNumber pn = new PalindromeNumber();

                // Testcase
                System.out.println(pn.isPalindrome(232)); // true
                System.out.println(pn.isPalindrome(345)); // false
        }

        public boolean isPalindrome(int x) {
                if (x < 0) {
                        return false;
                }
                // We use a division to get out the highest number
                int div = 1;
                while (x / div >= 10) {
                        div *= 10;
                }
                while (x > 0) {
                        int r = x / div;
                        int l = x % 10;

                        if (r != l) {
                                return false;
                        }
                        x %= div; // delete first digit
                        x /= 10; // delete last digit
                        div /= 100;
                }
                return true;
        }
}
