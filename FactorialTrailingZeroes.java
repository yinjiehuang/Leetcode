// Leetcode: Factorial Trailing Zeroes
// Author: Yinjie Huang
// Date: 12/30/2014
import java.util.*;

public class FactorialTrailingZeroes {
        public static void main(String[] args) {
                System.out.println("Leetcode: Factorial Trailing Zeroes!!!");
                FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
                System.out.println(ftz.trailingZeroes(5));
        }

        public int trailingZeroes(int n) {
                if (n < 0) {
                        return 0;
                }
                int res = 0;
                while (n != 0) {
                        res += n / 5;
                        n /= 5;
                }
                return res;
        }
}
