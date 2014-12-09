// Leetcode 081: Search In Rotated Sorted Array II
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class SearchInRotatedSortedArrayII {
        public static void main(String[] args) {
                System.out.println("Leetcode 081: Search In Rotated Sorted Array II!!!");
                SearchInRotatedSortedArrayII sirsa = new SearchInRotatedSortedArrayII();
                int[] A = new int[]{3, 3, 3, 5, 1, 2};
                System.out.println(sirsa.search(A, 1));
        }

        public boolean search(int[] A, int target) {
                if (A.length == 0) {
                        return false;
                }
                return helper(A, target, 0, A.length - 1);
        }

        public boolean helper(int[] A, int t, int s, int e) {
                if (s > e) {
                        return false;
                }
                int m = (s + e) / 2;
                if (A[m] == t) {
                        return true;
                }
                if (A[s] < A[m]) {
                        if (A[s] <= t && t < A[m]) {
                                return helper(A, t, s, m - 1);
                        } else {
                                return helper(A, t, m + 1, e);
                        }
                } else if (A[m] < A[e]) {
                        if (A[m] < t && t <= A[e]) {
                                return helper(A, t, m + 1, e);
                        } else {
                                return helper(A, t, s, m - 1);
                        }
                } else { // we may have repeated element
                        return helper(A, t, s, m - 1) || helper(A, t, m + 1, e);
                }
        }
}
