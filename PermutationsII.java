// Leetcode 047: Permutations II
// Author: Yinjie Huang
// Date: 11/26/2014
//
import java.util.*;

public class PermutationsII {
        public static void main(String[] args) {
                System.out.println("Leetcode 047: Permutations II!!!");
                PermutationsII pii = new PermutationsII();
                int[] num = new int[]{1, 1, 3};
                ArrayList<ArrayList<Integer>> res = pii.permuteUnique(num);
                for (ArrayList<Integer> al : res) {
                        System.out.print("[");
                        for (Integer i : al) {
                                System.out.print(i + ",");
                        }
                        System.out.print("]");
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (num.length == 0) {
                        return res;
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                boolean[] v = new boolean[num.length];
                Arrays.sort(num);
                helper(res, al, num, v);
                return res;
        }

        public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> al, int[] num, boolean[] v) {
                if (al.size() == num.length) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(al);
                        res.add(temp);
                        return;
                }
                for (int i = 0; i < num.length; i++) {
                		if (i > 0 && num[i - 1] == num[i] && !v[i - 1]) {
                				continue;
                		}
                        if (!v[i]) {
                                al.add(num[i]);
                                v[i] = true;
                                helper(res, al, num, v);
                                al.remove(al.size() - 1);
                                v[i] = false;
                        }
                }
        }
}
