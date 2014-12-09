// Leetcode 059: Spiral Matrix II
// Author: Yinjie Huang
// Date: 11/23/2014
//
import java.util.*;

public class SpiralMatrixII {
        public static void main(String[] args) {
                System.out.println("Leetcode 059: Spiral Matrix II!!!");
                SpiralMatrixII sm = new SpiralMatrixII();
                int[][] res = sm.generateMatrix(4);
                for (int[] array : res) {
                        System.out.println(Arrays.toString(array));
                }
        }

        public int[][] generateMatrix(int n) {
                int nsquare = (int) Math.pow(n, 2);
                int[][] res = new int[n][n];
                int start = 0, end = n - 2;
                int value = 1;
                while (value <= nsquare) {
                        int i = start;
                        int j = start;
                        
                        if (n % 2 == 1 && start > end) {
                                res[start][start] = value;
                                break;
                        }
                        while (j <= end) {
                                res[i][j] = value;
                                j++;
                                value++;
                        }

                        while (i <= end) {
                                res[i][j] = value;
                                i++;
                                value++;
                        }

                        while (j > start) {
                                res[i][j] = value;
                                j--;
                                value++;
                        }

                        while (i > start) {
                                res[i][j] = value;
                                i--;
                                value++;
                        }
                        start++;
                        end--;
                }
                return res;
        }
}
