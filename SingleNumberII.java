// Leetcode: Single Number II
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class SingleNumberII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Single Number II!!!");
                SingleNumberII snii = new SingleNumberII();
                int[] A = new int[]{2, 1, 2, 3, 1, 1, 2};
                System.out.println(snii.singleNumber(A));
        }

        public int singleNumber(int[] A) {
                if (A == null || A.length == 0) {
                        return 0;
                }
                int[] bits = new int[32];
                for (int i = 0; i < 32; i++) {
                        for (int j = 0; j < A.length; j++) {
                                bits[i] += A[j] >> i & 1;
                        }
                }
                int res = 0;
                for (int i = 0; i < 32; i++) {
                        res += (bits[i] % 3) << i;
                }
                return res;
        }
}
