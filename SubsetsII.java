// Leetcode 090: Subsets II
// Author: Yinjie Huang
// Date: 11/27/2014
//
import java.util.*;

public class SubsetsII {
        public static void main(String[] args) {
                System.out.println("Leetcode 090: Subsets II!!!");
                SubsetsII sii = new SubsetsII();
                int[] num = new int[]{1, 2, 2};
                ArrayList<ArrayList<Integer>> res = sii.subsetsWithDup(num);
                for (ArrayList<Integer> al : res) {
                        for (Integer i : al) {
                                System.out.print(i + ", ");
                        }
                        System.out.println();
                }
        }
        
        public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (num == null) {
                        return res;
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                Arrays.sort(num);
                res.add(new ArrayList<Integer>());
                helper(res, al, 0, num);
                return res;
        }

        public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> al, int depth, int[] num) {
                for (int i = depth; i < num.length; i++) {
                        al.add(num[i]);
                        res.add(new ArrayList<Integer>(al));
                        helper(res, al, i + 1, num);
                        al.remove(al.size() - 1);
                        while ( i < num.length - 1 && num[i] == num[i + 1]) { // Skip the repeated values
                        		i++;
                        }
                }
        }
}
