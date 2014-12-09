// Leetcode: Maximum Product Subarray
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class MaximumProductSubarray {
        public static void main(String[] args) {
                System.out.println("Leetcode: Maximum Product Subarray!!!");
                MaximumProductSubarray mps = new MaximumProductSubarray();
                int[] A = new int[]{2, 3, -2, 4};
                System.out.println(mps.maxProduct(A));
        }

        public int maxProduct(int[] A) {
                if (A == null || A.length == 0) {
                        return 0;
                }
                if (A.length == 1) {
                        return A[0];
                }
                int global = A[0];
                int maxlocal = A[0];
                int minlocal = A[0];
                for (int i = 1; i < A.length; i++) {
                        int temp = maxlocal;
                        maxlocal = Math.max(Math.max(A[i] * maxlocal, A[i]), A[i] * minlocal);
                        minlocal = Math.min(Math.min(A[i] * temp, A[i]), A[i] * minlocal);
                        global = Math.max(maxlocal, global);
                }
                return global;
        }
}
