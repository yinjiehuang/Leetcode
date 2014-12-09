// Leetcode 128: Longest Consecutive Sequence
// Author: Yinjie Huang
// Date: 11/16/2014
//
import java.util.*;

public class LongestConsecutiveSequence {
        public static void main(String[] args) {
                System.out.println("Longest Consecutive Sequence!!!");
                LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
                int[] num = new int[]{100, 4, 200, 1, 3, 2};
                System.out.println(lcs.longestConsecutive(num));
        }

        public int longestConsecutive(int[] num) {
                if (num.length == 0) {
                        return 0;
                }

                HashSet<Integer> hs = new HashSet<Integer>();
                for(int i = 0; i < num.length; i++) {
                        hs.add(num[i]);
                }
                int max = 0;
                for (int i = 0; i < num.length; i++) {
                        if (hs.contains(num[i])) {
                                int count = 1;
                                hs.remove(num[i]);

                                int low = num[i] - 1;
                                while(hs.contains(low)) {
                                        count++;
                                        hs.remove(low);
                                        low--;
                                }
                                int high = num[i] + 1;
                                while(hs.contains(high)) {
                                        count++;
                                        hs.remove(high);
                                        high++;
                                }
                                max = Math.max(max, count);
                        }
                }
                return max;
        }
}
