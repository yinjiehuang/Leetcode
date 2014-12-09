// Leetcode 075: Sort Colors
// Author: Yinjie Huang
// Date: 11/27/2014
//
import java.util.*;

public class SortColors {
        public static void main(String[] args) {
                System.out.println("Leetcode 075: Sort Colors!!!");
                SortColors sc = new SortColors();
                int[] A = new int[]{1, 0, 2, 1, 1, 0, 2};
                sc.sortColors(A);
                int[] A1 = new int[]{1, 0, 2, 1, 1, 0, 2};
                sc.sortColors1(A1);
                System.out.println(Arrays.toString(A));
                System.out.println(Arrays.toString(A1));
        }

        public void sortColors(int[] A) {
                // We can use counting sort
                int[] res = new int[A.length];
                int[] count = new int[3];

                for (int i = 0; i < A.length; i++) {
                        count[A[i]]++;
                }
                for (int i = 1; i < 3; i++) {
                        count[i] += count[i - 1];
                }
                for (int i = 0; i < A.length; i++) {
                        res[count[A[i]] - 1] = A[i];
                        count[A[i]]--;
                }
                for (int i = 0; i < A.length; i++) {
                        A[i] = res[i];
                }
        }

        public void sortColors1(int[] A) {
                if (A == null || A.length == 0) {
                        return;
                }
                int p0 = 0;
                int p1 = 0;
                for (int i = 0; i < A.length; i++) {
                        if (A[i] == 0) {
                                A[i] = 2;
                                A[p0++] = 0;
                                A[p1++] = 1;
                        } else if (A[i] == 1) {
                                A[i] = 2;
                                A[p1++] = 1;
                        }
                }
        }
}
