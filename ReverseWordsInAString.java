// Leetcode: Reverse Words in a String
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class ReverseWordsInAString {
        public static void main(String[] args) {
                System.out.println("Leetcode: Reverse Words in a String!!!");
                ReverseWordsInAString rws = new ReverseWordsInAString();
                String s = "the sky is blue";
                System.out.println(rws.reverseWords(s));
        }

        public String reverseWords(String s) {
                if (s == null || s.length() == 0) {
                        return s;
                }
                String[] strs = s.split(" ");
                if (strs == null || strs.length == 0) {
                		return "";
                }
                Stack<String> sta = new Stack<String>();
                for (int i = 0; i < strs.length; i++) {
                        if (!strs[i].isEmpty()) {
                                sta.push(strs[i]);
                        }
                }
                String res = "";
                while (!sta.isEmpty()) {
                        res += sta.pop() + " ";
                }
                return res.substring(0, res.length() - 1);
        }
}
