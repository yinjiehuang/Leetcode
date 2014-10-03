// Leetcode 001: Two Sum
// Author: Yinjie Huang
// Data: 10/02/2014
//
import java.util.*;

public class TwoSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 001:Two Sum!!!");
                TwoSum ts = new TwoSum();
                // Test Case 1
                int[] array1 = new int[]{2, 7, 11, 15};
                System.out.println(Arrays.toString(ts.twoSumHash(array1, 9)));
                System.out.println(Arrays.toString(ts.twoSumRegu(array1, 9)));

                // Test Case 2
                int[] array2 = new int[]{2, 4, 7, 4};
                System.out.println(Arrays.toString(ts.twoSumHash(array2, 8)));
                System.out.println(Arrays.toString(ts.twoSumRegu(array2, 8)));

                // Test Case 3
                int[] array3 = new int[]{0, 3, 4, 0};
                System.out.println(Arrays.toString(ts.twoSumHash(array3, 0)));
                System.out.println(Arrays.toString(ts.twoSumRegu(array3, 0)));
        } 

        // Method one, kinda like cheating, we use hashtable, the time complexity is O(n)
        public int[] twoSumHash(int[] array, int sum) {
                Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
                int[] index = new int[2];
                for (int i = 0; i < array.length; i++) {
                        int temp = sum - array[i];
                        if (!ht.containsKey(temp)) {
                                ht.put(array[i], i);
                        } else {
                                int index1 = i;
                                int index2 = ht.get(temp);
                                index[0] = Math.min(index1, index2) + 1;
                                index[1] = Math.max(index1, index2) + 1;
                        }
                }
                return index;
        }

        // Method two, we first sort the arrays, then we use two pointers, O(nlogn)
        public int[] twoSumRegu(int[] array, int sum) {
                int length = array.length;
                int[] array2 = new int[length];
                System.arraycopy(array, 0, array2, 0, length);
                int start = 0, end = length - 1;
                Arrays.sort(array2);
                while (start < end) {
                        if (array2[start] + array2[end] > sum) {
                                end--;
                        } else if (array2[start] + array2[end] < sum) {
                                start++;
                        } else {
                                break;
                        }
                }
                // Let's search the found value in the original array
                int[] result = new int[]{-1,-1};
                for (int i = 0; i < length; i++) {
                        if (array[i] == array2[start] || array[i] == array2[end]) {
                                if (result[0] == -1) {
                                        result[0] = i + 1;
                                } else {
                                        result[1] = i + 1;
                                }
                        }
                }
                Arrays.sort(result);
                return result;
        }
}
