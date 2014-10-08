// Leetcode 070: Climbing Stairs
// Author: Yinjie Huang
// Data: 10/07/2014

public class ClimbingStairs {
        public static void main(String[] args) {
                System.out.println("Leetcode 070: Climbing Stairs!!!");
                ClimbingStairs cs = new ClimbingStairs();

                // Testcase
                int steps = 10;
                System.out.println("If we have " + steps + " steps.");
                System.out.println("There are " + cs.climbStairs(steps) + " ways to reach it.");
        }

        public int climbStairs(int n) {
                int[] memory = new int[n+1];
                memory[0] = 1;
                memory[1] = 1;
                for (int i = 2; i < memory.length; i++) {
                        memory[i] = memory[i-1] + memory[i-2];
                }
                return memory[n];
        }
}
