//Leetcode 015: Three Sum
//Author: Yinjie Huang
//Data: 10/08/2014
//
import java.util.*;

public class ThreeSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 015: Three Sum!!!");
                // Testcase 1
                int[] num = new int[]{-1,0,1,2,-1,-4};
                ThreeSum ts = new ThreeSum();
                ArrayList<ArrayList<Integer>> result = ts.threeSum(num);
                for (ArrayList<Integer> jimo : result) {
                        System.out.println("The result: " + jimo);
                }
        }

        public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

                if (num.length <= 2) {
                        return result;
                }
                
                Arrays.sort(num);
                Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();

                int len = num.length;
                for (int i = 0 ; i < len - 2 ; i++) {
                        int left = i + 1;
                        int right = len - 1;
                        while (left < right) {
                                if (num[left] + num[right] == - num[i]) {
                                        ArrayList<Integer> temp = new ArrayList<Integer>();
                                        temp.add(num[i]);
                                        temp.add(num[left]);
                                        temp.add(num[right]);
                                        if (s.add(temp)) {
                                                result.add(temp);
                                        }
                                        left++;
                                        right--;
                                } else if (num[left] + num[right] > - num[i]) {
                                        right--;
                                } else {
                                        left++;
                                }
                        }
                }
                return result;
        }
}
