// Leetcode 017: Letter Combinations of a Phone Number
// Author: Yinjie Huang
// Date: 10/29/2014

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
        public static void main(String[] args) {
                System.out.println("Leetcode 017: Letter Combinations of a Phone Number!!!");
                LetterCombinationsOfAPhoneNumber lcoapn = new LetterCombinationsOfAPhoneNumber();
                ArrayList<String> result = lcoapn.letterCombinations("23");
                for(String s : result) {
                        System.out.println(s);
                }
        }

        public ArrayList<String> letterCombinations(String digits) {
                // This is a typical DFS
                ArrayList<String> result = new ArrayList<String>();
                String[] tel = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                helper(result, tel, digits, "", 0);
                return result;
        }

        public void helper(ArrayList<String> result, String[] tel, String digits, String sofar, int pos) {
                if (pos == digits.length()) {
                        result.add(sofar);
                        return;
                }
                String letters = tel[digits.charAt(pos) - '0'];
                for (int i = 0; i < letters.length(); i++) {
                        char c = letters.charAt(i);
                        sofar = sofar + c;
                        helper(result, tel, digits, sofar, pos + 1);
                        sofar = sofar.substring(0, sofar.length() - 1);
                }
        }
}
