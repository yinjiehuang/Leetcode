// Leetcode 072: Edit Distance
// Author: Yinjie Huang
// Date: 11/16/2014
//
import java.util.*;

public class EditDistance {
        public static void main(String[] args) {
                System.out.println("Leetcode 072: Edit Distance!!!");
                EditDistance ed = new EditDistance();
                String word1 = "abc";
                String word2 = "acde";
                System.out.println(ed.minDistance(word1, word2));
        }

        public int minDistance(String word1, String word2) {
                int len1 = word1.length();
                int len2 = word2.length();

                int[][] cache = new int[len1 + 1][len2 + 1];
                for (int i = 0; i <= len2; i++) {
                        cache[0][i] = i;
                }
                for (int j = 0; j <= len1; j++) {
                        cache[j][0] = j;
                }
                for (int i = 1; i <= len1; i++) {
                        for (int j = 1; j <= len2; j++) {
                                char c1 = word1.charAt(i - 1);
                                char c2 = word2.charAt(j - 1);
                                if (c1 == c2) {
                                        cache[i][j] = cache[i - 1][j - 1];
                                } else {
                                        cache[i][j] = Math.min(cache[i - 1][j - 1] + 1, Math.min(cache[i - 1][j] + 1, cache[i][j - 1] + 1));
                                }
                        }
                }
                return cache[len1][len2];
        }
}
