// Leetcode: Majority Element
// Author: Yinjie Huang
// Date: 12/21/2014
//
import java.util.*;

public class MajorityElement {
        public static void main(String[] args) {
                System.out.println("Leetcode: Majority Element!!!");
                MajorityElement me = new MajorityElement();
                int[] num = new int[]{4, 7, 4, 1, 4, 4};
                System.out.println(me.majorityElement(num));
        }

        public int majorityElement(int[] num) {
                if (num == null || num.length == 0) {
                        return 0;
                }
                int maj = num.length / 2;
                HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
                for (int i = 0; i < num.length; i++) {
                        if (hm.containsKey(num[i])) {
                                hm.put(num[i], hm.get(num[i]) + 1);
                        } else {
                                hm.put(num[i], 1);
                        }
                        if (hm.get(num[i]) > maj) {
                                return num[i];
                        }
                }
                return 0;
        }
}
