// Leetcode 084: Largest Rectangle in Histogram
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class LargestRectangleInHistogram {
        public static void main(String[] args) {
                System.out.println("Leetcode 084: Largest Rectangle in Histogram!!!");
                LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
                int[] height = new int[]{2, 1, 5, 6, 2, 3};
                System.out.println(lrih.largestRectangleArea(height));
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
