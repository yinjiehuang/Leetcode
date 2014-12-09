// Leetcode 068: Text Justification
// Author: Yinjie Huang
// Date: 11/27/2014
//
import java.util.*;

public class TextJustification {
        public static void main(String[] args) {
                System.out.println("Leetcode 068: Text Justification!!!");
                TextJustification tj = new TextJustification();
                String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
                ArrayList<String> res = tj.fullJustify(words, 16);
                for (String str : res) {
                        System.out.println(str);
                }
        }

        public ArrayList<String> fullJustify(String[] words, int L) {
                ArrayList<String> res = new ArrayList<String>();
                if (words == null || words.length == 0) {
                        return res;
                }
                int count = 0; // used to count the so far word length + space
                int lword = 0; // index of the last word
                int spacenum = 0;
                for (int i = 0; i < words.length; i++) {
                        if (count + spacenum + words[i].length() > L) {
                                spacenum--;
                                int each = 0;  // the number of adding spaces for each space
                                int extra = 0; // the number of extrac space
                                if (spacenum > 0) {
                                        each = (L - count) / spacenum;
                                        extra = (L - count) % spacenum;
                                }
                                StringBuffer sb = new StringBuffer();
                                for (int j = lword; j < i; j++) {
                                        sb.append(words[j]);
                                        if (j < i - 1) {
                                                for (int k = 0; k < each; k++) {
                                                        sb.append(" ");
                                                }
                                                if (extra > 0) {
                                                        sb.append(" ");
                                                        extra--;
                                                }
                                        }
                                }
                                for (int j = sb.length(); j < L; j++) {
                                        sb.append(" ");
                                }
                                res.add(new String(sb));
                                count = 0;
                                spacenum = 0;
                                lword = i;
                        }
                        spacenum++;
                        count += words[i].length();
                }
                // This is for the last line
                StringBuffer sb = new StringBuffer();
                for (int i = lword; i < words.length; i++) {
                        sb.append(words[i]);
                        if (sb.length() < L) {
                                sb.append(" ");
                        }
                }
                for (int i = sb.length(); i < L; i++) {
                        sb.append(" ");
                }
                res.add(new String(sb));
                return res;
        }
}
