// Leetcode 004: Median of Two Sorted Arrays
// Author: Yinjie Huang
// Date: 11/17/2014
//
import java.util.*;

public class MedianOfTwoSortedArrays {
        public static void main(String[] args) {
                System.out.println("Leetcode 004: Median of Two Sorted Arrays!!!");
                MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
                int[] num1 = new int[]{1, 5, 6, 11};
                int[] num2 = new int[]{4, 7, 8, 9, 10};
                System.out.println(motsa.findMedianSortedArrays(num1, num2));
        }

        public double findMedianSortedArrays(int A[], int B[]) {
                int m = A.length;
                int n = B.length;
                int total = m + n;
                if (total % 2 == 1) {
                        return findKth(A, 0, m - 1, B, 0, n - 1, total/2 + 1);
                } else {
                        return (findKth(A, 0, m - 1, B, 0, n - 1, total/2) + 
                                        findKth(A, 0, m - 1, B, 0, n - 1, total/2 + 1)) / 2;
                }
        }

        public double findKth(int A[], int sa, int ea, int[] B, int sb, int eb, int k) {
                // Suppose m is equal or smaller than n
                int m = ea - sa + 1;
                int n = eb - sb + 1;
                if (m > n) {
                        return findKth(B, sb, eb, A, sa, ea, k);
                }
                if (m ==0) {
                        return B[k - 1];
                }
                if (k == 1) {
                        return Math.min(A[sa], B[sb]);
                }
                int pa = Math.min(k / 2, m);
                int pb = k - pa;
                if (A[sa + pa - 1] < B[sb + pb - 1]) {
                        return findKth(A, sa + pa, ea, B, sb, eb, k - pa);
                } else if (A[sa + pa - 1] > B[sb + pb - 1]) {
                        return findKth(A, sa, ea, B, sb + pb, eb, k - pb);
                } else {
                        return A[sa + pa - 1];
                }
        }
}
