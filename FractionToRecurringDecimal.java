// Leetcode: Fraction to Recurring Decimal
// Author: Yinjie Huang
// Date: 12/20/2014
//
import java.util.*;

public class FractionToRecurringDecimal {
        public static void main(String[] args) {
                System.out.println("Leetcode: Fraction to Recurring Decimal!!!");
                FractionToRecurringDecimal ftrd = new FractionToRecurringDecimal();
                System.out.println(ftrd.fractionToDecimal(2, 5));
        }

        public String fractionToDecimal(int numerator, int denominator) {
                if (numerator == 0) {
                        return new String("0");
                }
                long n = (long) numerator;
                long d = (long) denominator;
                int sign = 1;
                if (n * d < 0) {
                        sign = -1;
                }
                // After getting absolute value, be careful with overflow
                n = Math.abs(n);
                d = Math.abs(d);
                StringBuffer res = new StringBuffer();
                if (sign == -1) {
                        res.append("-");
                }
                // Let's consider the decimal
                res.append(String.valueOf(n / d));
                // remainder
                long r = n % d;
                if (r == 0) {
                        return res.toString();
                }
                res.append(".");
                HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
                int i = res.length();
                while (r > 0) {
                        if (hm.get(r) != null) {
                                break;
                        }
                        hm.put(r, i);
                        res.append(String.valueOf(r * 10 / d));
                        r = (r * 10) % d;
                        i++;
                }
                if (r == 0) {
                        return res.toString();
                }
                res.insert(hm.get(r), "(");
                res.append(')');
                return res.toString();
        }
}
