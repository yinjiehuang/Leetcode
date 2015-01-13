// Leetcode: Largest Number
// Author: Yinjie Huang
// Date: 1/12/2015
//
import java.util.*;

public class LargestNumber {
        public static void main(String[] args) {
                System.out.println("Leetcode: Largest Number!!!");
                LargestNumber ln = new LargestNumber();
                int[] num = new int[]{3, 30, 34, 5, 9};
                System.out.println(ln.largestNumber(num));
        }

        public String largestNumber(int[] num) {
                if (num == null || num.length == 0) {
                        return "";
                }
                int len = num.length;
                String[] str = new String[len];
                for (int i = 0; i < len; i++) {
                        str[i] = String.valueOf(num[i]);
                }
                Arrays.sort(str, new Comp());
                StringBuffer res = new StringBuffer();
                for (int i = 0; i < len; i++) {
                        res.append(str[i]);
                }
                while (res.length() > 1 && res.charAt(0) == '0') {
                        res.deleteCharAt(0);
                }
                return res.toString();
        }
}

class Comp implements Comparator<String> {
        public int compare(String a, String b) {
                int vala = Integer.parseInt(a + b);
                int valb = Integer.parseInt(b + a);
                return valb - vala;
        }
}
