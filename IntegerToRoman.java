// Leetcode 012: Integer to Roman
// Author: Yinjie Huang
// Date: 10/16/2014

import java.util.*;

public class IntegerToRoman {
        public static void main(String[] args) {
                System.out.println("Leetcode 012: Integer to Roman!!!");
                IntegerToRoman itr = new IntegerToRoman();
                // Testcase 1
                int i1 = 2014;
                System.out.println(itr.intToRoman(i1));
        }

        public String intToRoman(int num) {
                // The idea is keep trying different letters;
                if (num < 1 || num > 3999) {
                        return "";
                }
                StringBuffer sb = new StringBuffer();
                String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
                int[] base = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
                for (int i = 0; i < base.length; i++) {
                        int temp = num / base[i];
                        while (temp > 0) {
                                sb.append(symbol[i]);
                                temp--;
                        }
                        num %= base[i];
                }
                return sb.toString();
        }
}
