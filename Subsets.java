// Leetcode 078: Subsets
// Author: Yinjie Huang
// Date: 10/20/2014
//
import java.util.*;

public class Subsets {
        public static void main(String[] args) {
                System.out.println("Leetcode 078: Subsets!!!");
                Subsets s = new Subsets();
                ArrayList<ArrayList<Integer>> result = s.subsets(new int[]{1,2,3});
                for (ArrayList<Integer> al : result) {
                        for (Integer i : al) {
                                System.out.print(i + " ");
                        }
                        System.out.println();
                }
                ArrayList<ArrayList<Integer>> result_dfs = s.subsets_dfs(new int[]{1,2,3});
                for (ArrayList<Integer> al : result_dfs) {
                        for (Integer i : al) {
                                System.out.print(i + " ");
                        }
                        System.out.println();
                }
        }

        // My method, recursion
        public ArrayList<ArrayList<Integer>> subsets(int[] S) {
                if (S.length == 0) {
                        return null;
                }
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                if (S.length == 1) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(S[0]);
                        result.add(temp);
                        result.add(new ArrayList<Integer>());
                        return result;
                }
                Arrays.sort(S);
                int[] preS = Arrays.copyOfRange(S, 0, S.length - 1);
                ArrayList<ArrayList<Integer>> pre = subsets(preS);
                int tail = S[S.length - 1];
                for (ArrayList<Integer> al : pre) {
                		result.add(new ArrayList<Integer>(al));
                        al.add(tail);
                        result.add(new ArrayList<Integer>(al));
                }
                return result;
        }

        // Method II, DFS
        public ArrayList<ArrayList<Integer>> subsets_dfs(int[] S) {
                if (S.length == 0) {
                        return null;
                }
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> sub = new ArrayList<Integer>();
                Arrays.sort(S);
                result.add(sub);
                helper(S, result, sub, 0);
                return result;
        }

        public void helper(int[] S, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub, int depth) {
                for (int i = depth; i < S.length; i++) {
                        sub.add(S[i]);
                        result.add(new ArrayList<Integer>(sub));
                        helper(S, result, sub, i + 1);
                        sub.remove(sub.size() - 1);
                }
        }
}
