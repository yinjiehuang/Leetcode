// Leetcode 022: Generate Parentheses
// Author: Yinjie Huang
// Date: 10/16/2014
//
import java.util.*;

public class GenerateParentheses {
        public static void main(String[] args) {
                System.out.println("Leetcode 022: Generate Parentheses!!!");
                GenerateParentheses gp = new GenerateParentheses();
                ArrayList<String> result = gp.generateParentheses(3);
                for (String s : result) {
                        System.out.println(s);
                }
        }

        public ArrayList<String> generateParentheses(int n) {
                char[] str = new char[2 * n];
                ArrayList<String> list = new ArrayList<String>();
                helper(list, str, n, n, 0);
                return list;
        }

        public void helper(ArrayList<String> list, char[] str, int left, int right, int count) {
                if (left < 0 || right < left) {
                        return;
                }

                if (left == 0 && right == 0) {
                        String s = new String(str);
                        list.add(s);
                } else {
                        if (left > 0) {
                                str[count] = '(';
                                helper(list, str, left - 1, right, count + 1);
                        } 

                        if (right > left) {
                                str[count] = ')';
                                helper(list, str, left, right - 1, count + 1);
                        }
                }
        }
}
