// Leetcode 074: Search a 2D Matrix
// Author: Yinjie Huang
// Date: 11/03/2014
//
import java.util.*;

public class SearchA2DMatrix {
        public static void main(String[] args) {
                System.out.println("Leetcode 074: Search a 2D Matrix");
                SearchA2DMatrix sdm = new SearchA2DMatrix();
                int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
                System.out.println(sdm.searchMatrix(matrix, 3));
        }

        public boolean searchMatrix(int[][] matrix, int target) {
                // This is simple, we start from the upper right corner
                int row = matrix.length;
                int col = matrix[0].length;

                if (row == 0 && col == 0) {
                        return false;
                }
                
                int i = 0;
                int j = col - 1;
                while (i < row && j >= 0) {
                        if (matrix[i][j] == target) {
                                return true;
                        } else if (matrix[i][j] > target) {
                                j--;
                        } else {
                                i++;
                        }
                }
                return false;
        }
}
