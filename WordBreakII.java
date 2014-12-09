// Leetcode: Word Break II
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class WordBreakII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Word Break II!!!");
                WordBreakII wbii = new WordBreakII();
                String s = "catsanddog";
                HashSet<String> dict = new HashSet<String>();
                dict.add("cat");
                dict.add("cats");
                dict.add("and");
                dict.add("sand");
                dict.add("dog");
                ArrayList<String> res = wbii.wordBreak(s, dict);
                for (String str : res) {
                        System.out.println(str);
                }
        }

        public ArrayList<String> wordBreak(String s, HashSet<String> dict) {
                ArrayList<String> res = new ArrayList<String>();
                if (s == null || s.length() == 0) {
                        return res;
                }
                if (wordBreakCheck(s, dict)) {
                        helper(res, s, dict, 0, "");
                }
                return res;
        }

        public void helper(ArrayList<String> res, String s, HashSet<String> dict, int depth, String str) {
                if (depth >= s.length()) {
                        res.add(str);
                        return;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = depth; i < s.length(); i++) {
                        sb.append(s.charAt(i));
                        if (dict.contains(sb.toString())) {
                                String nstr;
                                if (str.length() == 0 ) {
                                        nstr = sb.toString();
                                } else {
                                        nstr = str + " " + sb.toString();
                                }
                                helper(res, s, dict, i + 1, nstr);
                        }
                }
        }

        public boolean wordBreakCheck(String s, HashSet<String> dict) {
            if (s == null || s.length() == 0) {
                    return true;
            }
            boolean[] cache = new boolean[s.length() + 1];
            cache[0] = true;
            for (int i = 0; i < s.length(); i++) {
                    StringBuffer sb = new StringBuffer(s.substring(0, i + 1));
                    for (int j = 0; j <= i; j++) {
                            if (cache[j] && dict.contains(sb.toString())) {
                                    cache[i + 1] = true;
                                    break;
                            }
                            sb.deleteCharAt(0);
                    }
            }
            return cache[s.length()];
        }
}
