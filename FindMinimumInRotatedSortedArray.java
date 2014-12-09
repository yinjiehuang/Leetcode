// Leetcode: Find Minimum in Rotated Sorted Array
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class FindMinimumInRotatedSortedArray {
        public static void main(String[] args) {
                System.out.println("Leetcode: Find Minimum in Rotated Sorted Array!!!");
                FindMinimumInRotatedSortedArray fmrsa = new FindMinimumInRotatedSortedArray();
                int[] num = new int[]{4, 5, 6, 7, 0, 1, 2};
                System.out.println(fmrsa.findMin(num));
        }

        public int findMin(int[] num) {
                if (num == null || num.length == 0) {
                        return -1;
                }
                int left = 0;
                int right = num.length - 1;
                int min = Integer.MAX_VALUE;
                while (left <= right) {
                        int m = (left + right) / 2;
                        if (num[m] >= num[left]) { // left side is sorted
                                min = Math.min(num[left], min);
                                left = m + 1;
                        } else if (num[m] < num[left]) {
                                min = Math.min(num[m], min);
                                right = m - 1;
                        }
                }
                return min;
        }
}
