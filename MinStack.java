// Leetcode: Min Stack
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class MinStack {
        public static void main(String[] args) {
                System.out.println("Leetcode: Min Stack!!!");
                MinStack ms = new MinStack();
                ms.push(-2);
                ms.push(0);
                ms.push(1);
                System.out.println(ms.getMin());
        }

        Stack<Integer> sta = new Stack<Integer>();
        Stack<Integer> minsta = new Stack<Integer>();

        public void push(int x) {
                sta.push(x);
                if (minsta.isEmpty() || x <= minsta.peek()) {
                        minsta.push(x);
                }
        }

        public void pop() {
                if (sta.isEmpty()) {
                        return;
                }
                int temp = sta.pop();
                if (!minsta.isEmpty() && temp == minsta.peek()) {
                        minsta.pop();
                }
        }

        public int top() {
                return sta.peek();
        }

        public int getMin() {
                return minsta.pop();
        }
}
