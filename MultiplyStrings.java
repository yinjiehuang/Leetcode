// Leetcode 043: Multiply Strings
// Author: Yinjie Huang
// Date: 11/12/2014
//
import java.util.*;

public class MultiplyStrings {
        public static void main(String[] args) {
                System.out.println("Leetcode 043: Multiply Strings!!!");
                MultiplyStrings ms = new MultiplyStrings();
                String s1 = "117";
                String s2 = "4";
                System.out.println(ms.multiply(s1, s2));
        }

       public String multiply(String num1, String num2) {
                int len1 = num1.length();
                int len2 = num2.length();
                // We need to create a int array to do the job
                int[] temp = new int[len1 + len2];
                for (int i = len1 - 1; i >= 0;i--) {
                        int d1 = num1.charAt(i) - '0';
                        for (int j = len2 - 1; j >= 0; j--) {
                                int d2 = num2.charAt(j) - '0';
                                temp[len1 -1 - i + len2 - 1 - j] += d1 * d2;
                        }
                }
                // Let's scan from the end of temp to deal with digit
                int carry = 0;
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < len1 + len2; i++) {
                        int tempres = temp[i] + carry;
                        int digit = tempres % 10;
                        carry = tempres / 10;
                        sb.insert(0, digit);
                }
                while (sb.length() >0 && sb.charAt(0) - '0' == 0) {
                        sb.deleteCharAt(0);
                }
                String res = sb.toString();
                if (res.length() == 0) {
                        return "0";
                } else {
                        return res;
                }
        }
}
