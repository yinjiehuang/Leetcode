// Leetcode 040: Combination Sum II
// Author: Yinjie Huang
// Date: 11/25/2014
//
import java.util.*;

public class CombinationSumII {
        public static void main(String[] args) {
                System.out.println("Leetcode 040: Combination Sum II!!!");
                CombinationSumII csii = new CombinationSumII();
                int[] num = new int[]{10, 1, 2, 7, 6, 1, 5};
                ArrayList<ArrayList<Integer>> res = csii.combinationSum2(num, 8);
                for (ArrayList<Integer> al : res) {
                        for (Integer i : al) {
                                System.out.print(i + ",");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (num.length == 0) {
                        return res;
                }
                Arrays.sort(num);
                ArrayList<Integer> can = new ArrayList<Integer>();
                helper(res, num, can, 0, target);
                return res;
        }

        public void helper(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> can, int depth, int target) {
                if (target == 0) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(can);
                        if (!res.contains(temp)) {
                                res.add(temp);
                        }
                        return;
                }
                if (target < 0) {
                        return;
                }
                for (int i = depth; i < num.length; i++) {
                        if (num[i] <= target) {
                                can.add(num[i]);
                                helper(res, num, can, i + 1, target - num[i]);
                                can.remove(can.size() - 1);
                        } else {
                                break;
                        }
                }
        }
}
