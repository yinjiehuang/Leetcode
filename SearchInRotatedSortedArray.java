// Leetcode 033: Search In Rotated Sorted Array
// Author: Yinjie Huang
// Date: 11/10/2014
//
import java.util.*;

public class SearchInRotatedSortedArray {
        public static void main(String[] args) {
                System.out.println("Leetcode 033: Search In Rotated Sorted Array!!!");
                SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
                int[] A1 = new int[]{4, 5, 6, 7, 0, 1, 2};
                int[] A2 = new int[]{6, 7, 0, 1, 2, 4, 5};
                System.out.println(sirsa.search(A1, 6));
                System.out.println(sirsa.search(A2, 6));
        }

        public int search(int[] A, int target) {
                return helper(A, target, 0, A.length - 1);
        }

        public int helper(int[] A, int t, int s, int e) {
                if (s > e) {
                        return -1;
                }
                int m = (s + e) / 2;
                if (A[m] == t) {
                        return m; // we found the answer
                } 
                if (A[s] <= A[m]) {// which means the left side is sorted
                        if (t >= A[s] && t < A[m]) {
                                return helper(A, t, s, m - 1);
                        } else {
                                return helper(A, t, m + 1, e);
                        }
                } else { // which means the right side is sorted
                        if (t > A[m] && t <= A[e]) {
                                return helper(A, t, m + 1, e);
                        } else {
                                return helper(A, t, s, m - 1);
                        }
                }
        }
}
