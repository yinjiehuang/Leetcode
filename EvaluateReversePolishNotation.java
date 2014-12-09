// Leetcode: Evaluate Reverse Polish Notation
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class EvaluateReversePolishNotation {
        public static void main(String[] args) {
                System.out.println("Leetcode: Evaluate Reverse Polish Notation!!!");
                EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
                String[] str1 = new String[]{"2", "1", "+", "3", "*"};
                String[] str2 = new String[]{"4", "13", "5", "/", "+"};
                System.out.println(erpn.evalRPN(str1));
                System.out.println(erpn.evalRPN(str2));
        }
        
        public int evalRPN(String[] tokens) {
                // Typical Stack
                if (tokens == null || tokens.length == 0) {
                        return 0;
                }
                Stack<Integer> sta = new Stack<Integer>();
                for (int i = 0; i < tokens.length; i++) {
                        int res = 0;
                        if (tokens[i].equals("+")) {
                                int a = sta.pop();
                                int b = sta.pop();
                                res += b + a;
                                sta.push(res);
                        } else if (tokens[i].equals("-")) {
                                int a = sta.pop();
                                int b = sta.pop();
                                res += b - a;
                                sta.push(res);
                        } else if (tokens[i].equals("*")) {
                                int a = sta.pop();
                                int b = sta.pop();
                                res += b * a;
                                sta.push(res);
                        } else if (tokens[i].equals("/")) {
                                int a = sta.pop();
                                int b = sta.pop();
                                res += b / a;
                                sta.push(res);
                        } else {
                                int value = Integer.parseInt(tokens[i]);
                                sta.push(value);
                        }
                }
                return sta.pop();
        }
}
