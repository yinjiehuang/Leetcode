// Leetcode 055: Jump Game
// Author: Yinjie Huang
// Date: 11/21/2014
//
import java.util.*;

public class JumpGame {
        public static void main(String[] args) {
                System.out.println("Leetcode 055: Jump Game!!!");
                JumpGame jg = new JumpGame();
                int[] A = new int[]{2, 3, 1, 1, 4};
                System.out.println(jg.canJump(A));
        }

        public boolean canJump(int[] A) {
                if (A.length == 0) {
                        return false;
                }
                int range = 0;
                for (int i = 0; i <= range && i < A.length; i++) {
                        range = Math.max(range, i + A[i]);
                }
                if (range >= A.length - 1) {
                        return true;
                }
                return false;
        }
}
