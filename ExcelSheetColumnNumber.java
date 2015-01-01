// Leetcode: Excel Sheet Column Number
// Author: Yinjie Huang
// Date: 12/30/2014
//
import java.util.*;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
            System.out.println("Leetcode: Excel Sheet Column Number!!!!");
            ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
            System.out.println(escn.titleToNumber("AB"));
    }

    public int titleToNumber(String s) {
            // Here return 0 means wrong input
            if (s == null || s.length() == 0) {
                    return 0;
            }
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    res = 26 * res + (int) (c - 'A') + 1;
            }
            return res;
    }
}
