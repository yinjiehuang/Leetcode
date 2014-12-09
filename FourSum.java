// Leetcode 018: 4 Sum
// Author: Yinjie Huang
// Date: 11/21/2014
//
import java.util.*;

public class FourSum {
        public static void main(String[] args) {
                System.out.println("Leetcode 018: 4 Sum!!!");
                FourSum fs = new FourSum();
                int[] num = new int[]{1, 0, -1, 0, -2, 2};
                ArrayList<ArrayList<Integer>> res = fs.fourSum(num, 0);
                for (ArrayList<Integer> al : res) {
                        System.out.println(al.toString());
                }
        }

        public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (num.length < 4) {
                    return res;
            }
            HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
            Arrays.sort(num);
            for (int i = 0; i < num.length - 3; i++) {
                    for (int j = i + 1; j < num.length - 2; j++) {
                            int low = j + 1;
                            int high = num.length - 1;
                            int t = target - num[i] - num[j];
                            while (low < high) {
                                    if (num[low] + num[high] == t) {
                                            ArrayList<Integer> al = new ArrayList<Integer>();
                                            al.add(num[i]);
                                            al.add(num[j]);
                                            al.add(num[low]);
                                            al.add(num[high]);
                                            if (!hs.contains(al)) {
                                                    hs.add(al);
                                                    res.add(al);
                                            }
                                            low++;
                                            high--;

                                    } else if (num[low] + num[high] > t) {
                                            high--;
                                    } else {
                                            low++;
                                    }
                            }
                    }
            }
            return res;
        }
}
