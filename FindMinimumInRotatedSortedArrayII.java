// Leetcode: Find Minimum in Rotated Sorted Array II
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class FindMinimumInRotatedSortedArrayII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Find Minimum In Rotated Sorted Array II!!!");
                FindMinimumInRotatedSortedArrayII fmosa = new FindMinimumInRotatedSortedArrayII();
                int[] num = new int[]{2, 2, 2, 2, 0, 2};
                System.out.println(fmosa.findMin(num));
        }
        
        public int findMin(int[] num) {
                if (num == null || num.length == 0) {
                        return -1;
                }
                if (num.length == 1) {
                        return num[0];
                }
                int min = Integer.MAX_VALUE;
                int left = 0;
                int right = num.length - 1;
                while (left <= right) {
                        int m = (left + right) / 2;
                        if (num[left] < num[m]) {
                                min = Math.min(num[left], min);
                                left = m + 1;
                        } else if (num[left] > num[m]) {
                                min = Math.min(num[m], min);
                                right = m - 1;
                        } else {
                                min = Math.min(num[left], min);
                                left++;
                        }
                }
                return min;
        }
}
