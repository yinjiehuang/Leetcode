// Leetcode: Find Peak Element
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class FindPeakElement {
        public static void main(String[] args) {
                System.out.println("Leetcode: Find Peak Element!!!");
                FindPeakElement fpe = new FindPeakElement();
                int[] num = new int[]{1, 2, 3, 1};
                int[] num2 = new int[]{4, 5, 6, 7, 4, 1};
                System.out.println(fpe.findPeakElement(num));
                System.out.println(fpe.findPeakElement(num2));
        }

        public int findPeakElement(int[] num) {
                if (num == null || num.length <= 1) {
                        return 0;
                }
                
                int l = 0;
                int r = num.length - 1;
                while (l <= r) {
                        int m = (l + r) / 2;
                        if (m == 0 || num[m] >= num[m - 1]) {
                                if (m == num.length - 1 || num[m] >= num[m + 1]) {
                                        return m;
                                } else {
                                        l = m + 1;
                                }
                        } else {
                                r = m - 1;
                        }
                }
                return -1;
        }
}
