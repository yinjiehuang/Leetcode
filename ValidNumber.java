// Leetcode 065: Valid Number
// Author: Yinjie Huang
// Date: 10/07/2014
//
import java.util.*;

public class ValidNumber {
        public static void main(String[] args) {
                System.out.println("Leetcode: Valid Number");
                ValidNumber vn = new ValidNumber();

                // Testcase 1
                String s1 = "e";
                System.out.println("Is Valid? " + vn.isNumber(s1));
                // Testcase 2
                String s2 = " 0.1";
                System.out.println("Is Valid? " + vn.isNumber(s2));
                // Testcase 3
                String s3 = "2e-10";
                System.out.println("Is Valid? " + vn.isNumber(s3));
                // Testcase 4
                String s4 = "e9";
                System.out.println("Is Valid? " + vn.isNumber(s4));
                // Testcase 5
                String s5 = "2e1e0";
                System.out.println("Is Valid? " + vn.isNumber(s5));
        }

        public boolean isNumber(String s) {
                if (s.length() == 0) {
                        return false;
                }
                String str = s.trim();
                char[] array = str.toCharArray();
                boolean hasNum = false;
                boolean canSign = true;
                boolean canDot = true;
                boolean canE = false;
                boolean hasE = false;

                for (int i = 0; i < array.length; i++) {
                        char temp = array[i];
                        if (temp == '+' || temp == '-') {
                                if (!canSign) {
                                        return false;
                                }
                                canSign = false;
                        } else if (temp == '.') {
                                if (!canDot) {
                                        return false;
                                }
                                canSign = false;
                                canDot = false;
                        } else if (temp == 'e') {
                                if (!canE || hasE) {
                                        return false;
                                }
                                canE = false;
                                hasE = true;
                                hasNum = false;
                                canDot = false;
                                canSign = true;
                        } else if (temp >= '0' && temp <= '9') {
                                hasNum = true;
                                if (!canE && !hasE) {
                                        canE = true;
                                }
                                canSign = false;
                        } else {
                                return false;
                        }
                }
                return hasNum;
        }
}
