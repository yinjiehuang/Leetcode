// Leetcode 027: Remove Element
// Author: Yinjie Huang
// Date: 10/11/2014
//
import java.util.*;

public class RemoveElement {
        public static void main(String[] args) {
                System.out.println("Leetcode 027: Remove Element!!!");
                RemoveElement re = new RemoveElement();
                int[] A = new int[]{4,7,5,1,3,4,6,5,1,5,4,3};
                System.out.println("Original Array " + Arrays.toString(A) + ". Element is: " + 5);
                int nlen = re.removeElement(A, 5);
                System.out.println("New length: " + nlen + ". New array: " + Arrays.toString(A));
        }

        public int removeElement(int[] A, int elem) {
                int len = A.length;
                for (int i = 0; i < len; i++) {
                        if (A[i] == elem) {
                                int j = i + 1;
                                while (j < len) {
                                        if (A[j] != elem) {
                                                int temp = A[j];
                                                A[j] = A[i];
                                                A[i] = temp;
                                                break;
                                        } else {
                                                j++;
                                        }
                                }
                        }
                }
                int count = 0;
                for (int i = 0; i < len; i++) {
                        if (A[i] == elem) {
                                break;
                        } else {
                                count++;
                        }
                }
                return count;
        }
}
