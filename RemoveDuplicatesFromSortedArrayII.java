// Leetcode 080: Remove Duplicates from Sorted Array II
// Author: Yinjie Huang
// Date: 11/20/2014

import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
        public static void main(String[] args) {
                System.out.println("Leetcode 080: Remove Duplicates from Sorted Array II!!!");
                RemoveDuplicatesFromSortedArrayII rdfsa = new RemoveDuplicatesFromSortedArrayII();
                int[] A = new int[]{1, 1, 2, 2, 2, 3};
                System.out.println(rdfsa.removeDuplicates(A));
        }

        public int removeDuplicates(int[] A) {
                int len = A.length;
                if (A.length <= 2) {
                        return len;
                }
                int i = 1, j = 2;
                int count = 0;
                while (j < A.length) {
                        if(A[i] == A[j] && A[j] == A[i - 1]) {
                                j++;
                        } else {
                                i++;
                                A[i] = A[j];
                                j++;
                        }
                }
                return i + 1;
        }
}
