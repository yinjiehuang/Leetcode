// Leetcode 042: Trapping Rain Water
// Author: Yinjie Huang
// Date: 11/25/2014
//
import java.util.*;

public class TrappingRainWater {
        public static void main(String[] args) {
                System.out.println("Leetcode 042: Trapping Rain Water!!!");
                TrappingRainWater trw = new TrappingRainWater();
                int[] A = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
                System.out.println(A);
        }
        
        public int trap(int[] A) {
                if (A == null || A.length < 2) {
                        return 0;
                }

                // This problem use dp
                int len = A.length;
                int[] left = new int[len];
                int[] right = new int[len];
                int max = 0;
                for (int i = 0; i < len; i++) {
                        left[i] = max;
                        max = Math.max(max, A[i]);
                }
                max = 0;
                for (int i = len - 1; i >= 0; i--) {
                        right[i] = max;
                        max = Math.max(max, A[i]);
                }
                int res = 0;
                for (int i = 0; i < len; i++) {
                        int temp = Math.min(left[i], right[i]) - A[i];
                        if (temp > 0) {
                                res += temp;
                        }
                }
                return res;
        }
}
