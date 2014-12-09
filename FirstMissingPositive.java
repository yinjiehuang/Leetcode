// Leetcode 041: First Missing Positive
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class FirstMissingPositive {
        public static void main(String[] args) {
                System.out.println("Leetcode 041: First Missing Positive!!!");
                FirstMissingPositive fmp = new FirstMissingPositive();
                int[] num = new int[]{3, 4, -1, 1};
                System.out.println(fmp.firstMissingPositive(num));
        }

        public int firstMissingPositive(int[] A) {
                // This problem likes the counting sort
                if (A == null || A.length == 0) {
                        return 1;
                }
                for (int i = 0; i < A.length; i++) {
                        if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                                int temp = A[A[i] - 1];
                                A[A[i] - 1] = A[i];
                                A[i] = temp;
                                i--;
                        }
                }
                for (int i = 0; i < A.length; i++) {
                        if (A[i] != i + 1) {
                                return i + 1;
                        }
                }
                return A.length + 1;
        }
}
