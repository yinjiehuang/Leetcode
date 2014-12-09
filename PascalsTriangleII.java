// Leetcode: Pascal's Triangle II
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class PascalsTriangleII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Pascal's Triangle II!!!!");
                PascalsTriangleII ptii = new PascalsTriangleII();
                ArrayList<Integer> res = ptii.getRow(3);
                for (Integer i : res) {
                        System.out.print(i + "->");
                }
                System.out.println();
        }

        public ArrayList<Integer> getRow(int rowIndex) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                int[] cache = new int[rowIndex + 1];
                for (int i = 0; i < rowIndex + 1; i++) {
                        cache[i] = 1;
                        int add = 1;
                        for (int j = 1; j < i; j++) {
                        		int temp = cache[j];
                                cache[j] = cache[j] + add;
                                add = temp;
                        }
                }
                for (int i = 0; i < cache.length; i++) {
                        res.add(cache[i]);
                }
                return res;
        }
}
