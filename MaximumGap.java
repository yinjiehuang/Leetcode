// Leetcode: Maximum Gap
// Author: Yinjie Huang
// Date: 12/14/2014
//
import java.util.*;

public class MaximumGap {
        public static void main(String[] args) {
                System.out.println("Leetcode: Maximum Gap!!!");
                MaximumGap mg = new MaximumGap();
                int[] num = new int[]{18, 7, 1, 23, 8};
                System.out.println(mg.maximumGap(num));
        }

        public int maximumGap(int[] num) {
                if (num.length < 2) {
                        return 0;
                }
                int len = num.length;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < len; i++) {
                        max = Math.max(num[i], max);
                        min = Math.min(num[i], min);
                }
                double delta = (double) (max - min + 1)/(len + 1);
                boolean[] nempty = new boolean[len + 1];
                int[] maxarray = new int[len + 1];
                int[] minarray = new int[len + 1];
                // Let's put each value into corresponding bucket
                for (int i = 0; i < len; i++) {
                        int pos = (int) Math.floor((num[i] - min)/delta);
                        if (!nempty[pos]) {
                             nempty[pos] = true;
                             maxarray[pos] = num[i];
                             minarray[pos] = num[i];
                        } else {
                                maxarray[pos] = Math.max(maxarray[pos], num[i]);
                                minarray[pos] = Math.min(minarray[pos], num[i]);
                        }
                }
                int pre = -1, res = 0;
                for (int i = 0; i < len + 1; i++) {
                        if (nempty[i]) {
                                if (pre < 0) {
                                        pre = maxarray[i];
                                } else {
                                        res = Math.max(res, minarray[i] - pre);
                                        pre = maxarray[i];
                                }
                        }
                }
                return res;
        }
}
