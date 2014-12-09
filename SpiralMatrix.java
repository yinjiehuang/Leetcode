// Leetcode 054: Spiral Matrix
// Author: Yinjie Huang
// Date: 11/26/2014
//
import java.util.*;

public class SpiralMatrix {
        public static void main(String[] args) {
                System.out.println("Leetcode 054: Spiral Matrix!!!");
                SpiralMatrix sm = new SpiralMatrix();
                int[][] matrix = new int[][]{{1, 2, 3}, 
                                                {4, 5, 6},
                                                {7, 8, 9}};
                ArrayList<Integer> al = sm.spiralOrder(matrix);
                for (Integer i : al) {
                        System.out.print(i + ", ");
                }
                System.out.println();
        }

        public ArrayList<Integer> spiralOrder(int[][] matrix) {
            	ArrayList<Integer> res = new ArrayList<Integer>();
                if (matrix == null || matrix.length == 0) {
                        return res;
                }
                int m = matrix.length;
                int n = matrix[0].length;
                
                if ( m == 1) {
                        for (int i = 0; i < n; i++) {
                                res.add(matrix[0][i]);
                        }
                        return res;
                }
                if ( n == 1) {
                        for (int i = 0; i < m; i++) {
                                res.add(matrix[i][0]);
                        }
                        return res;
                }

                int rows = 0, cols = 0;
                int rowe = m - 1, cole = n - 1;
                while (rows <= rowe && cols <= cole) {
                        if (rows == rowe && cols == cole) {
                                res.add(matrix[rows][cols]);
                                break;
                        }
                        for (int i = cols; i < cole; i++) {
                                res.add(matrix[rows][i]);
                        }
                        for (int i = rows; i < rowe; i++) {
                                res.add(matrix[i][cole]);
                        }
                        for (int i = cole; i > cols; i--) {
                                res.add(matrix[rowe][i]);
                        }
                        for (int i = rowe; i > rows; i--) {
                                res.add(matrix[i][cols]);
                        }
                        rows++;
                        cols++;
                        rowe--;
                        cole--;
                }
                return res;
        }
}
