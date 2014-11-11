// Leetcode 053: Maximum Subarray
// Author: Yinjie Huang
// Date: 10/30/2014
//
import java.util.*;

public class MaximumSubarray {
        public static void main(String[] args) {
                System.out.println("Leetcode 053: Maximum Subarray!!!");
                MaximumSubarray ms = new MaximumSubarray();
                int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
                System.out.println(ms.maxSubArray(array));
        }

        public int maxSubArray(int[] A) {
                int max = A[0];
                int[] sum = new int[A.length];
                sum[0] = A[0];

                for (int i = 1; i < A.length; i++) {
                        sum[i] = Math.max(A[i], sum[i-1] + A[i]);
                        max = Math.max(max, sum[i]);
                }

                return max;
        }
}
