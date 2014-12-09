// Leetcode 038: Count and Say
// Author: Yinjie Huang
// Date: 11/19/2014
//
import java.util.*;

public class CountAndSay {
        public static void main(String[] args) {
                System.out.println("Leetcode 038: Count and Say!!!");
                CountAndSay cas = new CountAndSay();
                System.out.println(cas.countAndSay(4));
        }

        public String countAndSay(int n) {
                if (n == 0) {
                        return "1";
                }
                String base = "1";
                for (int i = 1; i < n; i++) {
                        // Read the pre case and generate
                        StringBuffer sb = new StringBuffer();
                        int count = 0;
                        char tempc = base.charAt(0);
                        for (int j = 0; j < base.length(); j++) {
                                if (base.charAt(j) == tempc) {
                                        count++;
                                } else {
                                        sb.append((char) (count + '0'));
                                        sb.append(tempc);
                                        count = 1;
                                        tempc = base.charAt(j);
                                }
                        }
                        sb.append((char) (count + '0'));
                        sb.append(tempc);
                        base = new String(sb);
                }
                return base;
        }
}
