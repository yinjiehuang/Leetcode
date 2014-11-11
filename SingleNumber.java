// Leetcode 136: Single Number
// Author: Yinjie Huang
// Date: 10/10/2014
//

public class SingleNumber {
        public static void main(String[] args) {
                System.out.println("Leetcode 136: Single Number");
                int[] array = new int[]{5,2,3,3,2,4,4,1,5};
                SingleNumber sn = new SingleNumber();
                System.out.println(sn.singleNumber(array));
        }

        public int singleNumber(int[] A) {
                int result = 0;
                for (int i = 0; i < A.length; i++) {
                	result = result ^ A[i];
                }
                return result;
        }
}
