// Leetcode 006: ZigZag Conversion
// Author: Yinjie Huang
// Date: 11/12/2014
//
import java.util.*;

public class ZigZagConversion {
        public static void main(String[] args) {
                System.out.println("Leetcode 006: ZigZag Conversion!!!");
                ZigZagConversion zzc = new ZigZagConversion();
                String s1 = "PAYPALISHIRING";
                System.out.println(zzc.convert(s1, 3));
        }

        public String convert(String s, int nRows) {
                if (s.length() == 0 || s == null || nRows <= 0) {
                        return "";
                }
                if (nRows == 1) {
                        return s;
                }
                int len = s.length();
                int nlen = 2 * nRows - 2;
                StringBuffer res = new StringBuffer();
                for (int i = 0; i < nRows; i++) {
                        for (int j = i; j < len; j += nlen) {
                                res.append(s.charAt(j));
                                int temp = j + nlen - 2 * i;
                                if (i != 0 && i != nRows - 1 && temp < len) {
                                        res.append(s.charAt(temp));
                                }
                        }
                }
                return res.toString();
        }
}
