// Leetcode: Excel Sheet Column Title
// Author: Yinjie Huang
// Date: 12/20/2014
//
import java.util.*;

public class ExcelSheetColumnTitle {
        public static void main(String[] args) {
                System.out.println("Leetcode: Excel Sheet Column Title!!!");
                ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
                System.out.println(esct.convertToTitle(2));
        }

        public String convertToTitle(int n) {
                if (n <= 0) {
                        return "";
                }
                StringBuffer res = new StringBuffer();
                while (n > 0) {
                        int d = n % 26;
                        char c = '.';
                        if (d != 0) {
                                c = (char) ('A' + d - 1);
                        } else {
                                c = 'Z';
                        }
                        res.insert(0, "" + c);
                        n /= 26;
                        if (d == 0) {
                                n--;
                        }
                }
                return res.toString();
        }
}
