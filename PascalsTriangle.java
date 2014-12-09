// Leetcode: Pascal's Triangle
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class PascalsTriangle {
        public static void main(String[] args) {
                System.out.println("Leetcode: Pascal's Triangle!!!");
                PascalsTriangle pt = new PascalsTriangle();
                ArrayList<ArrayList<Integer>> res = pt.generate(5);
                for (ArrayList<Integer> al : res) {
                        for (Integer i : al) {
                                System.out.print(i + "->");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<Integer>> generate(int numRows) {
                ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
                if (numRows == 0) {
                        return res;
                }
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(1);
                res.add(al);
                for (int i = 1; i < numRows; i++) {
                        ArrayList<Integer> last = new ArrayList<Integer>(res.get(i - 1));
                        ArrayList<Integer> news = new ArrayList<Integer>();
                        news.add(1);
                        for (int j = 1; j < last.size(); j++) {
                                int temp = last.get(j) + last.get(j - 1);
                                news.add(temp);
                        }
                        news.add(1);
                        res.add(news);
                }
                return res;
        }
}
