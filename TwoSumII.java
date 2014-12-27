// Leetcode: Two Sum II
// Author: Yinjie Huang
// Date: 12/20/2014
//
import java.util.*;

public class TwoSumII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Two Sum II!!!");
                TwoSumII tsii = new TwoSumII();
                int[] res = tsii.twoSum(new int[]{2, 7, 11, 15}, 9);
                System.out.println(Arrays.toString(res));
        }

        public int[] twoSum(int[] numbers, int target) {
                int l = 0, r = numbers.length - 1;
                int[] res = new int[2];
                while (l < r) {
                        if (numbers[l] + numbers[r] < target) {
                                l++;
                        } else if (numbers[l] + numbers[r] > target) {
                                r--;
                        } else {
                                res[0] = l + 1;
                                res[1] = r + 1;
                                break;
                        }
                }
                return res;
        }
}
