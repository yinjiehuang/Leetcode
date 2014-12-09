// Leetcode: Permutation Sequence
// Author: Yinjie Huang
// Date: 12/04/2014
//
import java.util.*;

public class PermutationSequence {
        public static void main(String[] args) {
                System.out.println("Leetcode: Permutation Sequence!!!");
                PermutationSequence ps = new PermutationSequence();
                System.out.println(ps.getPermutation(4, 5));
        }

        public String getPermutation(int n, int k) {
        		k--;
                // Compute factorial
                int fac = 1;
                for (int i = 1; i < n; i++) {
                        fac *= i;
                }
                // Let's see the first digit
                LinkedList<Integer> str = new LinkedList<Integer>();
                StringBuffer res = new StringBuffer();
                for (int i = 1; i <= n; i++) {
                        str.add(i);
                }
                int t = n - 1;
                while (t > 0) {
                        int index = k / fac;
                        res.append(str.get(index));
                        str.remove(index);
                        
                        k %= fac;
                        fac /= t;
                        t--;
                }
                res.append(str.poll());
                return res.toString();
        }
        
}
