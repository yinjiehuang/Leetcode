// Leetcode 046: Permutations
// Author: Yinjie Huang
// Date: 10/19/2014
//
import java.util.*;

public class Permutations {
        public static void main(String[] args) {
                System.out.println("Leetcode 046: Permutations!!!");
                int[] num = new int[]{1, 2, 3};
                Permutations p = new Permutations();
                ArrayList<ArrayList<Integer>> result = p.permute(num);
                for (ArrayList<Integer> al : result) {
                        for (int jimo : al) {
                                System.out.print(jimo + " ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> permute(int[] num) {
                if (num.length == 0) {
                        return null;
                }
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                if (num.length == 1) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[0]);
                        result.add(temp);
                        return result;
                }
                // Now we use recursion
                int len = num.length;
                int[] newnum = Arrays.copyOf(num, len - 1);
                ArrayList<ArrayList<Integer>> pre = permute(newnum);
                for (ArrayList<Integer> al : pre) {
                        for (int i = 0; i <= al.size(); i++) {
                                ArrayList<Integer> tempal = new ArrayList<Integer>(al);
                                tempal.add(i, num[len-1]);
                                result.add(tempal);
                        }
                }
                return result;
        }
}
