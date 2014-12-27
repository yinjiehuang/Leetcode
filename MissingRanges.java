// Leetcode: Missing Ranges
// Author: Yinjie Huang
// Date: 12/11/2014
//
import java.util.*;

public class MissingRanges {
        public static void main(String[] args) {
                System.out.println("Leetcode: Missing Ranges!!!");
                MissingRanges mr = new MissingRanges();
                int[] A = new int[]{0, 1, 3, 50, 75};
                ArrayList<String> res = mr.findMissingRanges(A, 0, 99);
                for (String s : res) {
                        System.out.println(s);
                }
        }

        public ArrayList<String> findMissingRanges(int[] A,int lower, int upper) {
                ArrayList<String> res = new ArrayList<String>();
                int pre = lower - 1; // previous position
                for (int i = 0; i <= A.length; i++) {
                        int cur = 0;
                        if (i == A.length) {
                                cur = upper + 1;
                        } else {
                                cur = A[i];
                        }
                        if (cur - pre >= 2) {
                                res.add(getRange(pre + 1, cur - 1));
                        }
                        pre = cur;
                }
                return res;
        }

        public String getRange(int from, int to) {
                return (from == to) ? Integer.toString(from) : Integer.toString(from) + "->" + Integer.toString(to);
        }
}
