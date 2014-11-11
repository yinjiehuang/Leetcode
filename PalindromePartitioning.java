// Leetcode 131: Palindrome Partitioning
// Author: Yinjie Huang
// Date: 10/23/2014
//
import java.util.*;

public class PalindromePartitioning {
        public static void main(String[] args) {
                System.out.println("Leetcode 131: Palindrome Partitioning!!!");
                PalindromePartitioning pp = new PalindromePartitioning();
                String s = "abaca";
                ArrayList<ArrayList<String>> result = pp.partition(s);
                for (ArrayList<String> al : result) {
                        for (String ss : al) {
                                System.out.print(ss + " ");
                        }
                        System.out.println();
                }
        }

        public ArrayList<ArrayList<String>> partition(String s) {
                ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
                if (s == null || s.length() == 0) {
                        return result;
                }
                ArrayList<String> res = new ArrayList<String>();
                helper(s, result, 0, res);
                return result;
        }

        public void helper(String s, ArrayList<ArrayList<String>> result, int start, ArrayList<String> res) {
                if (start == s.length()) {
                        ArrayList<String> temp = new ArrayList<String>(res);
                        result.add(temp);
                        return;
                }
                for (int i = start + 1; i <= s.length(); i++) {
                        String temps = s.substring(start, i);
                        if (isPali(temps)) {
                                res.add(temps);
                                helper(s, result, i, res);
                                res.remove(res.size() - 1);
                        }
                }
        }

        public boolean isPali(String s) {
                if (s == null) {
                        return false;
                }
                if (s.length() == 0 || s.length() == 1) {
                        return true;
                }
                int left = 0;
                int right = s.length() - 1;
                char[] array = s.toCharArray();
                while (left <= right) {
                        if (array[left] == array[right]) {
                                left++;
                                right--;
                        } else {
                                return false;
                        }
                }
                return true;
        }
}
