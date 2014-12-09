// Leetcode: Word Break
// Author: Yinjie Huang
// Date: 12/05/2014
//
import java.util.*;

public class WordBreak {
        public static void main(String[] args) {
                System.out.println("Leetcode: Word Break!!!");
                WordBreak wb = new WordBreak();
                String s = "leetcode";
                HashSet<String> dict = new HashSet<String>();
                dict.add("leet");
                dict.add("code");
                System.out.println(wb.wordBreak(s, dict));
        }

        public boolean wordBreak(String s, HashSet<String> dict) {
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
