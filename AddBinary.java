// Leetcode 067: Add Binary
// Author: Yinjie Huang
// Date: 10/15/2014
//
import java.util.*;

public class AddBinary {
        public static void main(String[] args) {
                System.out.println("Leetcode 067: Add Binary!!!");
                AddBinary ab = new AddBinary();

                // Testcase 1
                String s1 = "11";
                String s2 = "11";
                System.out.println(ab.addBinary(s1,s2));
        }

        public String addBinary(String a, String b) {
                if (a == null || a.length() == 0) {
                        return b;
                }
                if (b == null || b.length() == 0) {
                        return a;
                }
                if ( a.length() < b.length()) {
                        String temp = a;
                        a = b;
                        b = temp;
                }
                // a is always longer than b
                int lena = a.length();
                int lenb = b.length();
                char[] arraya = a.toCharArray();
                char[] arrayb = b.toCharArray();
                int indexa = lena - 1;
                int indexb = lenb - 1;
                int carry = 0;
                char[] result = new char[lena];
                while (indexb >= 0) {
                        int atA = arraya[indexa] - '0';
                        int atB = arrayb[indexb] - '0';
                        int tempsum = atA + atB + carry;
                        if (tempsum >= 2) {
                                tempsum -= 2;
                                carry = 1;
                        } else {
                                carry = 0;
                        }
                        result[indexa] = (char) (tempsum + '0');
                        indexa--;
                        indexb--;
                }
                // Now we continue filling a
                while (indexa >= 0) {
                        int atA = arraya[indexa] - '0';
                        int tempsum = atA + carry;
                        if (tempsum >= 2) {
                                tempsum -= 2;
                                carry = 1;
                        } else {
                                carry = 0;
                        }
                        result[indexa] = (char) (tempsum + '0');
                        indexa--;
                }
                if (carry == 0) {
                        return new String(result);
                } else {
                        return "1" + (new String(result));
                }
        }
}
