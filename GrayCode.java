// Leetcode 089: Gray Code
// Author: Yinjie Huang
// Date: 11/27/2014
//
import java.util.*;

public class GrayCode {
        public static void main(String[] args) {
                System.out.println("Leetcode 089: Gray Code!!!");
                GrayCode cc = new GrayCode();
                ArrayList<Integer> res = cc.grayCode(2);
                for (Integer i : res) {
                        System.out.println(i);
                }
        }

        public ArrayList<Integer> grayCode(int n) {
                // This problem is so damn weird...
                //
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (n < 0) {
                        return res;
                }
                res.add(0);
                if (n == 0) {
                        return res;
                }
                res.add(1);
                for (int i = 2; i <= n; i++) {
                        for (int j = res.size() - 1; j >= 0; j--) {
                                int temp = res.get(j) + (1 << (i - 1));
                                res.add(temp);
                        }
                }
                return res;
        }
}
