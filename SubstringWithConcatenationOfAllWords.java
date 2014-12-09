// Leetcode: Substring With Concatenation of All words
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class SubstringWithConcatenationOfAllWords {
        public static void main(String[] args) {
                System.out.println("Leetcode: Substring With Concatenation of All Words!!!");
                SubstringWithConcatenationOfAllWords swcaw = new SubstringWithConcatenationOfAllWords();
                String S = "barfoothefoobarman";
                String[] L = new String[]{"foo", "bar"};
                ArrayList<Integer> res = swcaw.findSubstring(S, L);
                for (Integer i : res) {
                        System.out.print(i + ", ");
                }
                System.out.println();
        }

        public ArrayList<Integer> findSubstring(String S, String[] L) {
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (S == null || S.length() == 0 || L == null || L.length == 0) {
                        return res;
                }
                //First, we need a hashmap
                HashMap<String, Integer> dict = new HashMap<String, Integer>();
                for (int i = 0; i < L.length; i++) {
                        if (dict.containsKey(L[i])) {
                                dict.put(L[i], dict.get(L[i]) + 1);
                        } else {
                                dict.put(L[i], 1);
                        }
                }
                int wordl = L[0].length();
                for (int i = 0; i < wordl; i++) {
                        int count = 0;
                        int left = i;
                        HashMap<String, Integer> cur = new HashMap<String, Integer>();
                        for (int j = i; j <= S.length() - wordl; j += wordl) {
                                String curstr = S.substring(j, j + wordl);
                                if (!dict.containsKey(curstr)) {
                                        cur.clear();
                                        count = 0;
                                        left = j + wordl;
                                } else {
                                        if (cur.containsKey(curstr)) {
                                                cur.put(curstr, cur.get(curstr) + 1);
                                        } else {
                                                cur.put(curstr, 1);
                                        }
                                        if (cur.get(curstr) <= dict.get(curstr)) {
                                                count++;
                                        } else {
                                                while (cur.get(curstr) > dict.get(curstr)) {
                                                        String temp = S.substring(left, left + wordl);
                                                        cur.put(temp, cur.get(temp) - 1);
                                                        if (cur.get(temp) < dict.get(temp)) {
                                                                count--;
                                                        }
                                                        left = left + wordl;
                                                }
                                        }
                                        if (count == L.length) {
                                                res.add(left);
                                                String temp = S.substring(left, left + wordl);
                                                cur.put(temp, cur.get(temp) - 1);
                                                count--;
                                                left = left + wordl;
                                        }
                                }
                        }
                }
                return res;
        }
}
