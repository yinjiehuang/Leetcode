// Leetcode: Valid Parentheses
// Author: Yinjie Huang
// Date: 10/06/2014
//
import java.util.*;

public class ValidParentheses {
        public static void main (String[] args) {
                System.out.println("Leetcode: Valid Parentheses!!!");
                ValidParentheses vp = new ValidParentheses();

                String s1 = "(([{}]))";
                System.out.println("Original String" + s1);
                System.out.println("Is valid? " + vp.isValid(s1));

                String s2 = "";
                System.out.println("Original String" + s2);
                System.out.println("Is valid? " + vp.isValid(s2));

                String s3 = "(({(}))";
                System.out.println("Original String" + s3);
                System.out.println("Is valid? " + vp.isValid(s3));
        }

        public boolean isValid(String s) {
                Stack<Character> sta = new Stack<Character>();
                if (s.length() == 0 || s.length() == 1) {
                        return false;
                }
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; i++) {
                        char c = array[i];
                        if (c == '(' || c == '[' || c == '{') {
                                sta.push(c);
                        } else {
                                if (!sta.empty()) {
                                        char temp = sta.pop();
                                        if (c == '(' && temp != ')') {
                                                return false;
                                        }
                                        if (c == '[' && temp != ']') {
                                                return false;
                                        }
                                        if (c == '{' && temp != '}') {
                                                return false;
                                        }
                                }
                        }
                }

                if (sta.empty()) {
                        return true;
                } else {
                        return false;
                }
        }
}
