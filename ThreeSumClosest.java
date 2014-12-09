// Leetcode: 3Sum Closest
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class ThreeSumClosest {
        public static void main(String[] args) {
                System.out.println("Leetcode: 3Sum Closest!!!");
                ThreeSumClosest tsc = new ThreeSumClosest();
                int[] num = new int[]{-1, 2, 1, -4};
                System.out.println(tsc.threeSumClosest(num, 1));
        }

        public int threeSumClosest(int[] num, int target) {
                if (num == null || num.length < 3) {
                        return 0;
                }
                Arrays.sort(num);
                int min = Integer.MAX_VALUE;
                int res = 0;
                // Similar to 3Sum
                for (int i = 0; i < num.length; i++) {
                        int start = i + 1;
                        int end = num.length - 1;

                        while (start < end) {
                                int sum = num[start] + num[end] + num[i];

                                if (sum < target) {
                                        start++;
                                } else if (sum > target) {
                                        end--;
                                } else {
                                        return sum;
                                }

                                if (Math.abs(sum - target) < min) {
                                        min = Math.abs(sum - target);
                                        res = sum;
                                }
                        }
                }
                return res;
        }
}
