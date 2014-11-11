// Leetcode 026: Remove Duplicates from Sorted Array
// Author: Yinjie Huang
// Date: 10/28/2014
//
import java.util.*;

public class RemoveDuplicatesFromSortedArray {
        public static void main(String[] args) {
                System.out.println("Leetcode 026: Remove Duplicates from Sorted Array!!!");
                RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
                int[] A = new int[]{1,1,2};
                System.out.println(rdfsa.removeDuplicates(A));
        }

        public int removeDuplicates(int[] A) {
                    int len = A.length;
                if (len < 2) {
                            return len;
                }
                int i = 0; 
                int j = 1;
                while (j < len) {
                            if (A[i] == A[j]) {
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
