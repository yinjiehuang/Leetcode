// Leetcode 007: Reverse Integer
// Author: Yinjie Huang
// Date: 10/28/2014
//
import java.util.*;

public class ReverseInteger {
        public static void main(String[] args) {
                System.out.println("Leetcode 007: Reverse Integer!!!");
                ReverseInteger ri = new ReverseInteger();
                System.out.println(ri.reverse(124));
        }

        public int reverse(int x) {
                int sign = x >= 0 ? 1 : -1;
                int num = Math.abs(x);
                int res = 0;
                while (num > 0) {
                        int temp = num % 10;
                        num /= 10;
                        res = res * 10 + temp;
                }
                return sign * res;
        }
}
