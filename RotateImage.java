// Leetcode 048: Rotate Image
// Author: Yinjie Huang
// Date: 11/26/2014
//
import java.util.*;

public class RotateImage {
        public static void main(String[] args) {
                System.out.println("Leetcode 048: Rotate Image!!!");
                RotateImage ri = new RotateImage();
                int[][] matrix = new int[][]{{1, 2, 3, 4},
                                        {5, 6, 7, 8},
                                        {9, 10, 11, 12},
                                        {13, 14, 15, 16}};
                for (int i = 0; i < matrix.length; i++) {
                        System.out.println(Arrays.toString(matrix[i]));
                }

                ri.rotate(matrix);
                for (int i = 0; i < matrix.length; i++) {
                        System.out.println(Arrays.toString(matrix[i]));
                }
        }

        public void rotate(int[][] matrix) {
                int n = matrix.length;
                int start = 0;
                int end = n - 1;
                while (start < end) {
                        for (int i = start; i < end; i++) {
                                // left up -> right up
                                int temp1 = matrix[i][end];
                                matrix[i][end] = matrix[start][i];
                                // right up -> right down
                                int temp2 = matrix[end][end - i + start];
                                matrix[end][end - i + start] = temp1;
                                // right down -> left down
                                int temp3 = matrix[end - i + start][start];
                                matrix[end - i + start][start] = temp2;
                                // left down -> left up
                                matrix[start][i] = temp3;
                        }
                        start++;
                        end--;
                }
        }
}
