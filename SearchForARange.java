// Leetcode 034: Search For A Range
// Author: Yinjie Huang
// Date: 11/12/2014
//

import java.util.*;

public class SearchForARange {
        public static void main(String[] args) {
                System.out.println("Leetcode 034: Search For A Range!!!");
                SearchForARange sfar = new SearchForARange();
                int[] A = new int[]{5, 8, 8, 8, 10, 12};
                System.out.println(Arrays.toString(sfar.searchRange(A, 8)));
        }

        public int[] searchRange(int[] A, int target) {
                int s = 0;
                int e = A.length - 1;
                int[] res = new int[]{-1,-1};
                int m = 0;
                while ( s <= e) {
                        m = (s + e) / 2;
                        if (target > A[m]) {
                                s = m + 1;
                        } else if (target < A[m]) {
                                e = m - 1;
                        } else { // when equality bulids, we found part of the range
                                res[0] = m;
                                res[1] = m;
                                break;
                        }
                }
                if (A[m] != target) {
                        return res;
                }
                // Second pass, find the right most value
                int rs = m + 1;
                int re = A.length - 1;
                while (rs <= re) {
                        m = (rs + rs) / 2;
                        if (A[m] == target) {
                                rs = m + 1;
                        } else {
                                re = m - 1;
                        }
                }
                res[1] = re;
                int ls = 0;
                int le = m - 1;
                while (ls <= le) {
                        m = (le + le) / 2;
                        if (A[m] == target) {
                                le = m - 1;
                        } else {
                                ls = m + 1;
                        }
                }
                res[0] = ls;
                return res;
        }
}
