// Leetcode 077: Combinations
// Author: Yinjie Huang
// Date: 10/20/2014
//
import java.util.*;

public class Combinations {
        public static void main(String[] args) {
                System.out.println("Leetcode 077: Combinations!!!");
                Combinations c = new Combinations();
                ArrayList<ArrayList<Integer>> result = c.combine(4,2);
                for (ArrayList<Integer> al : result) {
                        for (Integer i : al) {
                                System.out.print(i + " ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
                if (n < k) {
                        return null;
                }
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> com = new ArrayList<Integer>();
                helper(n, k, result, com, 1);
                return result;
        }

        public void helper(int n, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> com, int depth) {
                if (com.size() == k) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(com);
                        result.add(temp);
                } else {
                        for (int i = depth; i <= n; i++) {
                                com.add(i);
                                helper(n, k, result, com, i+1);
                                com.remove(com.size() - 1);
                        }
                }
        }
}
