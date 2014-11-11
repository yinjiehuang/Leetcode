// Leetcode 013: Roman To Integer
// Author: Yinjie Huang
// Date: 10/11/2014
//
public class RomanToInteger {
        public static void main(String[] args) {
                System.out.println("Leetcode 013: Roman To Integer!!!");
                RomanToInteger rti = new RomanToInteger();
                // Testcase 1
                String s1 = "XIII";
                System.out.println("Original: " + s1 + ". The integer: " + rti.romanToInt(s1));
                // Testcase 2
                String s2 = "CCVII";
                System.out.println("Original: " + s2 + ". The integer: " + rti.romanToInt(s2));
                // Testcase 3
                String s3 = "MCMLIV";
                System.out.println("Original: " + s3 + ". The integer: " + rti.romanToInt(s3));
                // Testcase 4
                String s4 = "MCMXC";
                System.out.println("Original: " + s4 + ". The integer: " + rti.romanToInt(s4));
        }

        public int romanToInt(String s) {
                int result = 0;
                // We scan the string, keep adding the corresponding values to the final result
                char[] array = s.toCharArray();
                int len = array.length;
                for (int i = 0; i < len; i++) {
                        if (array[i] == 'I') {
                                if (i < len - 1 && array[i + 1] == 'V') {
                                        result += 4;
                                        i++;
                                } else if (i < len - 1 && array[i + 1] == 'X') {
                                        result += 9;
                                        i++;
                                } else {
                                        result += 1;
                                }
                        } else if (array[i] == 'V') {
                                result += 5;
                        } else if (array[i] == 'X') {
                                if (i < len - 1 && array[i + 1] == 'L') {
                                        result += 40;
                                        i++;
                                } else if (i < len - 1 && array[i + 1] == 'C') {
                                        result += 90;
                                        i++;
                                } else {
                                        result += 10;
                                }
                        } else if (array[i] == 'L') {
                                result += 50;
                        } else if (array[i] == 'C') {
                                if (i < len - 1 && array[i + 1] == 'D') {
                                        result += 400;
                                        i++;
                                } else if (i < len - 1 && array[i + 1] == 'M') {
                                        result += 900;
                                        i++;
                                } else {
                                        result += 100;
                                }
                        } else if (array[i] == 'D') {
                                result += 500;
                        } else if (array[i] == 'M') {
                                result += 1000;
                        }
                }
                return result;
        }
}
