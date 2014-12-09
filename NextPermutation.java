// Leetcode 031: Next Permutation
// Author: Yinjie Huang
// Date: 12/01/2014
//
import java.util.*;

public class NextPermutation {
        public static void main(String[] args) {
                System.out.println("Leetcode 031: Next Permutation!!!");
                NextPermutation np = new NextPermutation();
                int[] num = new int[]{2, 3, 6, 5, 4, 1};
                np.nextPermutation(num);
                System.out.println(Arrays.toString(num));
        }

        public void nextPermutation(int[] num) {
                if (num == null || num.length <= 1) {
                        return;
                }
                // Set one pointer, starting from the tail
                int i = num.length - 2;
                while (i >= 0) {
                        if (num[i] < num[i + 1]) {
                                break;
                        }
                        i--;
                }
                // if i < 0, then we know this a reverse order array
                if (i < 0) {
                        reverse(num, 0, num.length - 1);
                } else {
                        // we scan back to find the place
                        int j = i + 1;
                        while ( j < num.length) {
                                if (num[j] <= num[i]) {
                                        break;
                                }
                                j++;
                        }
                        j--;
                        swap(num, i, j);
                        reverse(num, i + 1, num.length - 1);
                }
        }

        public void swap(int[] num, int i, int j) { // swap postion i and j
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
        }

        public void reverse(int[] num, int i, int j) { // reverse from i to j
                while (i <= j) {
                        swap(num, i, j);
                        i++;
                        j--;
                }
        }
}
