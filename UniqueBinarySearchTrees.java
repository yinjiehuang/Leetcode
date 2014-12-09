// Leetcode: Unique Binary Search Trees
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class UniqueBinarySearchTrees {
        public static void main(String[] args) {
                System.out.println("Leetcode: Unique Binary Search Trees!!!");
                UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
                System.out.println(ubst.numTrees(3));
        }

        public int numTrees(int n) {
                if ( n < 0) {
                        return 0;
                }
                int[] cache = new int[n + 1];
                cache[0] = 1;
                cache[1] = 1;
                for (int i = 2; i <= n; i++) {
                        for (int j = 0; j < i; j++) {
                                cache[i] += cache[j]*cache[i - 1 - j];
                        }
                }
                return cache[n];
        }
}
