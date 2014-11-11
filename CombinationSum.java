// Leetcode 039: Combination Sum
// Author: Yinjie Huang
// Date: 10/30/2014
//
import java.util.*;

public class CombinationSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 039: Combination Sum!!!");
                CombinationSum cs = new CombinationSum();
                int[] candidates = new int[]{2, 3, 6, 7};
                ArrayList<ArrayList<Integer>> result = cs.combinationSum(candidates, 7);
                for(ArrayList<Integer> al : result) {
                        for (int i : al) {
                                System.out.print(i + ", ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
                // This is another very obvious DFS
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> sofar = new ArrayList<Integer>();
                Arrays.sort(candidates);
                helper(result, sofar, candidates, target, 0);
                return result;
        }

        public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sofar, int[] candidates, int target, int depth) {
                if (target == 0) {
                        ArrayList<Integer> tempres = new ArrayList<Integer>(sofar);
                        // We may have duplicate results, wo sort the tempres
                        if (!result.contains(tempres)) {
                        		result.add(tempres);
                        }
                        return;
                }
                for (int i = depth; i < candidates.length; i++) {
                        int temp = candidates[i];
                        if (target >= temp) {
                                sofar.add(temp);
                                helper(result, sofar, candidates, target - temp, i);
                                sofar.remove(sofar.size() - 1);
                        } else {
                                break; // Since candidates is non-decreasing
                        }
                }
        }
}
