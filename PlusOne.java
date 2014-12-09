// Leetcode 066: Plus One
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class PlusOne {
        public static void main(String[] args) {
                System.out.println("Leetcode 066: Plus One!!!");
                PlusOne po = new PlusOne();
                int[] num1 = new int[]{2, 3, 6};
                int[] num2 = new int[]{9, 9, 9, 9};
                System.out.println(Arrays.toString(po.plusOne(num1)));
                System.out.println(Arrays.toString(po.plusOne(num2)));
        }

        public int[] plusOne(int[] digits) {
                if (digits.length == 0) {
                        return new int[]{1};
                }
                // Or else, we count from the bottom
                int carry = 0;
                int[] A = new int[digits.length + 1];
                digits[digits.length - 1]++;
                for (int i = digits.length - 1; i >= 0; i--) {
                        int temp = digits[i] + carry;
                        digits[i] = temp % 10;
                        A[i] = temp % 10;
                        carry = temp / 10;
                }
                if (carry == 1) { // we need to increase the size of the int array
                        A[0] = 1;
                        return A;
                }
                return digits;
        }
}
