// Leetcode: Triangle
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class Triangle {
        public static void main(String[] args) {
                System.out.println("Leetcode: Triangle!!!");
                Triangle t = new Triangle();
                ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(2);
                triangle.add(new ArrayList<Integer>(al));
                al.clear();
                al.add(3);
                al.add(4);
                triangle.add(new ArrayList<Integer>(al));
                al.clear();
                al.add(5);
                al.add(6);
                al.add(7);
                triangle.add(new ArrayList<Integer>(al));
                al.clear();
                al.add(4);
                al.add(1);
                al.add(8);
                al.add(3);
                triangle.add(new ArrayList<Integer>(al));
                System.out.println(t.minimumTotal(triangle));
        }

        public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
                if (triangle == null || triangle.size() == 0) {
                        return 0;
                }
                int len = triangle.size();
                if (len == 1) {
                        return triangle.get(0).get(0);
                }
                int lastlen = triangle.get(len - 1).size();
                int[] cache = new int[lastlen];
                
                for (int i = 0; i < lastlen; i++) {
                        cache[i] = triangle.get(len - 1).get(i);
                }

                for (int i = len - 2; i >= 0; i--) {
                        for (int j = 0; j < triangle.get(i).size(); j++) {
                                cache[j] = Math.min(cache[j], cache[j + 1]) + triangle.get(i).get(j);
                        }
                }

                return cache[0];
        }
}
