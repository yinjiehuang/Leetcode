// Leetcode: Longest Valid Parentheses
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class LongestValidParentheses {
        public static void main(String[] args) {
                System.out.println("Leetcode: Longest Valid Parentheses!!!");
                LongestValidParentheses lvp = new LongestValidParentheses();
                String s = ")()())";
                System.out.println(lvp.longestValidParentheses(s));
        }

        public int longestValidParentheses(String s) {
                if (s == null | s.length() == 0) {
                        return 0;
                }
                Stack<Integer> sta = new Stack<Integer>();// keep the position 
                int max = 0;
                int start = 0;
                for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '(') {
                                sta.push(i);
                        }
                        if (s.charAt(i) == ')') {
                                if (sta.empty()) { // this case we igore this right p
                                        start = i + 1;
                                } else {
                                        sta.pop();
                                        if (sta.empty()) {
                                                max = Math.max(max, i - start + 1);
                                        } else {
                                                max = Math.max(max, i - sta.peek());
                                        }
                                }
                        }
                }
                return max;
        }
}
