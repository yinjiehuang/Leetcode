// Leetcode 73: Set Matrix Zeroes
// Author: Yinjie Huang
// Date: 10/09/2014
//
import java.util.*;

public class SetMatrixZeroes {
        public static void main(String[] args) {
                System.out.println("Leetcode 073: Set Matrix Zeroes!!!");
                SetMatrixZeroes smz = new SetMatrixZeroes();
                int[][] matrix = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
                for (int[] jimo : matrix) {
                        System.out.println(Arrays.toString(jimo));
                }
                System.out.println("Set Zeros!!");
                smz.setZeroes(matrix);
                for (int[] hehe : matrix) {
                        System.out.println(Arrays.toString(hehe));
                }
        }

        public void setZeroes(int[][] matrix) {
                int N = matrix.length; // Row
                int M = matrix[0].length; // Column
                boolean firstrow = false;
                boolean firstcolumn = false;
                // Check if the first row has zero
                for (int i = 0; i < M; i++) {
                        if (matrix[0][i] == 0) {
                                firstrow = true;
                                break;
                        }
                }
                for (int i = 0; i < N; i++) {
                        if (matrix[i][0] == 0) {
                                firstcolumn = true;
                                break;
                        }
                }

                for (int i = 1; i < N; i++) {
                        for (int j = 1; j < M; j++) {
                                if (matrix[i][j] == 0) {
                                        matrix[0][j] = 0;
                                        matrix[i][0] = 0;
                                } 
                        }
                }
                // Now let's clear the zeros
                for (int i = 1; i < N ; i++) {
                        if (matrix[i][0] == 0) {
                                for (int j = 1; j < M; j++) {
                                        matrix[i][j] = 0;
                                }
                        }
                }
                for (int j = 1; j < M; j++) {
                        if (matrix[0][j] == 0) {
                                for (int i = 1; i < N; i++) {
                                        matrix[i][j] = 0;
                                }
                        }
                }
                if (firstrow) {
                        for (int j = 0; j < M; j++) {
                                matrix[0][j] = 0;
                        }
                }
                if (firstcolumn) {
                        for (int i = 0; i < N; i++) {
                                matrix[i][0] = 0;
                        }
                }
        }
}
