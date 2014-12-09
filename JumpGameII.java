// Leetcode 045: Jump game II
// Author: Yinjie Huang
// Date: 11/26/2014
//

public class JumpGameII {
        public static void main(String[] args) {
                System.out.println("Leetcode 045: Jump Game II!!!");
                JumpGameII jgii = new JumpGameII();
                int[] A = new int[]{2, 3, 1, 1, 4};
                System.out.println(jgii.jump(A));
        }

        public int jump(int[] A) {
                if (A == null || A.length == 0) {
                        return 0;
                }
                int range = 0, lrange = 0, res = 0;
                for (int i = 0; i < A.length && i <= range; i++) {
                        if (i > lrange) {
                                res++;
                                lrange = range;
                        }
                        range = Math.max(range, A[i] + i);
                }
                if (range >= A.length - 1) {
                        return res;
                }
                return 0;
        }
}
