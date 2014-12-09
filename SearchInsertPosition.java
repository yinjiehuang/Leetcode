// Leetcode 035: Search Insert Position
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class SearchInsertPosition {
        public static void main(String[] args) {
                System.out.println("Leetcode 035: Search Insert Position!!!");
                SearchInsertPosition sip = new SearchInsertPosition();
                int[] num = new int[]{1, 3, 5, 6};
                System.out.println(sip.searchInsert(num, 5));
        }

        public int searchInsert(int[] A, int target) {
                if (A.length == 0) {
                        return 0;
                }
                int s = 0;
                int e = A.length - 1;
                while (s <= e) {
                        int m = (s + e) / 2;
                        if (A[m] == target) {
                                return m;
                        } else if (A[m] < target) {
                                s = m + 1;
                        } else {
                                e = m - 1;
                        }
                }
                return s;        
        }
}
