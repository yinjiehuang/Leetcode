// Leetcode 029: Divide Two Integers
// Author: Yinjie Huang
// Date: 11/06/2014

import java.util.*;

public class DivideTwoIntegers {
        public static void main(String[] args) {
                System.out.println("Leetcode 029: Divide Two Integers!!!");
                DivideTwoIntegers dti = new DivideTwoIntegers();
                System.out.println(dti.divide(43,8));
        }

        public int divide(int dividend, int divisor) {
                long bcu = Math.abs((long)dividend);
                long cu = Math.abs((long)divisor);
                int res = 0;
                while (bcu >= cu) {
                        int i = 0;;
                        long temp = cu;
                        while (bcu >= temp) {
                                temp = temp << 1;
                                i++;
                        }
                        res += 1 << (i - 1);
                        bcu -= temp >> 1;
                }
                if (divisor > 0 && dividend < 0 || divisor < 0 && dividend > 0) {
                        res = - res;
                }
                return (int) res;
        }
}
