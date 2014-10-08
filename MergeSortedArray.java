// Leetcode 088: Merge Sorted Array
// Author: Yinjie Huang
// Data: 10/07/2014

import java.util.*;

public class MergeSortedArray {
        public static void main(String[] args) {
                System.out.println("Leetcode 088: Merge Sorted Array!!!");
                MergeSortedArray msa = new MergeSortedArray();

                int[] A = new int[]{2,3,7,0,0,0,0,0,0};
                int[] B = new int[]{1,5,9,10,11,16};
                System.out.println("Now let's merge the following two arrays:");
                System.out.println("Array A " + Arrays.toString(A));
                System.out.println("Array B " + Arrays.toString(B));
                msa.merge(A,3,B,6);
                System.out.println("Array merged " + Arrays.toString(A));
        }

        public void merge(int[] A, int m, int B[], int n) {
                // We start from the end of the array A
                int l = n + m - 1;
                int i = m - 1;
                int j = n - 1;
                while (i >=0 && j >= 0) {
                        if (A[i] >= B[j]) {
                                A[l] = A[i];
                                i--;
                                l--;
                        } else {
                                A[l] = B[j];
                                j--;
                                l--;
                        }
                }

                //if B is non-empty
                while (j >= 0) {
                        A[l] = B[j];
                        j--;
                        l--;
                }
        }
}
