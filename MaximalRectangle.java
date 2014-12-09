// Leetcode: Maximal Rectangle
// Author: Yinjie Huang
// Date: 12/04/2014
//
import java.util.*;

public class MaximalRectangle {
        public static void main(String[] args) {
                System.out.println("Leetcode: Maximal Rectangle!!!");
                MaximalRectangle mr = new MaximalRectangle();
        }

        public int maximalRectangle(char[][] matrix) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                        return 0;
                }
                int row = matrix.length;
                int col = matrix[0].length;
                int[] height = new int[col];
                int max = 0;
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                if (matrix[i][j] == '1') {
                                        height[j]++;
                                } else if (matrix[i][j] == '0') {
                                        height[j] = 0;
                                }
                        }
                        max = Math.max(largestRectangleArea(height), max);
                }
                return max;
        }

        public int largestRectangleArea(int[] height) {
                // This problem is so damn difficult
                if (height == null || height.length == 0) {
                        return 0;
                }
                int max = 0;
                Stack<Integer> sta = new Stack<Integer>();
                for (int i = 0; i < height.length; i++) {
                        while (!sta.isEmpty() && height[i] <= height[sta.peek()]) {
                                int index = sta.pop();
                                int cur = 0;
                                if (sta.isEmpty()) {
                                        cur = height[index] * i; // when the stack is empty, the popped one is the shortest bar
                                } else {
                                        cur = height[index] * (i - sta.peek() - 1);
                                }
                                max = Math.max(max, cur);
                        }
                        sta.push(i);
                }
                //Deal with the unempty stack
                while (!sta.isEmpty()) {
                        int index = sta.pop();
                        int cur = 0;
                        if (sta.isEmpty()) {
                                cur = height[index] * height.length;
                        } else {
                                cur = height[index] * (height.length - sta.peek() - 1);
                        }
                        max = Math.max(max, cur);
                }
                return max;
        }
}
