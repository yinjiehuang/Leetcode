// Leetcode 028: Implement strStr()
// Author: Yinjie Huang
// Date: 10/12/2014

import java.util.*;

public class ImplementstrStr {
        public static void main(String[] args) {
                System.out.println("Leetcode 028: Implement strStr()!!!");

                // Testcase 1
                String haystack = "abacde";
                String needle = "bacde";
                ImplementstrStr iss = new ImplementstrStr();
                System.out.println("Naive method!!!");
                System.out.println(iss.strStr_naive(haystack,needle));
                System.out.println("Rolling Hashing!!!");
                System.out.println(iss.strStr_rollingHash(haystack,needle));
        }
        
        // This is the naive solution, easy to understand and implement
        public String strStr_naive(String haystack, String needle) {
                int len1 = haystack.length();
                int len2 = needle.length();
                // These damn boundary conditions are sick
                if (len2 == 0 || haystack == null || needle == null) {
                        return haystack;
                }
                if (len2 > len1) {
                        return null;
                }
                char[] hayarray = haystack.toCharArray();
                char[] narray = needle.toCharArray();
                for (int i = 0; i < len1 - len2 + 1; i++) {
                        if (hayarray[i] == narray[0]) {
                                boolean flag = true;
                                for (int j = 1; j < len2; j++) {
                                        if (hayarray[i + j] != narray[j]) {
                                                flag = false;
                                                break;
                                        }
                                }
                                if (flag == true) {// Which means we have found the answer
                                        return haystack.substring(i);
                                }
                        }
                }
                return null;
        }

       // This is the rolling hash method, easy to understand
        public String strStr_rollingHash(String haystack, String needle) {
                int len1 = haystack.length();
                int len2 = needle.length();
                if (len2 == 0 || haystack == null || needle == null) {
                        return haystack;
                }
                if (len2 > len1) {
                        return null;
                }
                // In order to make the hash unique, we have to choose the base a little bit larger than 26
                int base = 29;
                long tempbase = 1;
                long needlehash = 0;
                for (int i = 0; i < len2; i++) {
                        needlehash += (int)(needle.charAt(i) - 'a' + 1) * tempbase;
                        tempbase *= base;
                }
                tempbase = 1;
                long hayhash = 0;
                for (int i = 0; i < len2; i++) {
                        hayhash += (int)(haystack.charAt(i)-'a' + 1) * tempbase;
                        tempbase *= base;
                }

                if (needlehash == hayhash) {
                        return needle;
                }
                tempbase /= base;
                for (int i = len2; i < len1; i++) {
                        hayhash = hayhash / base + (int)(haystack.charAt(i) - 'a' + 1) * tempbase;
                        if (needlehash == hayhash) {
                                return haystack.substring(i - len2 + 1);
                        }
                }
                return null;
        }
}
