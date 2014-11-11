// Leetcode 091: Decode Ways
// Author: Yinjie Huang
// Date: 10/22/2014

public class DecodeWays {
        public static void main(String[] args) {
                System.out.println("Leetcode 091: Decode Ways!!!");
                DecodeWays dw = new DecodeWays();
                // Testcase 1
                String s1 = "1324511";
                System.out.println(dw.numDecodings(s1));
                
                // Testcase 2
                String s2 = "01";
                System.out.println(dw.numDecodings(s2));
        }

        public int numDecodings(String s) {
                if (s == null || s.length() == 0) {
                        return 0;
                }
                if (s.charAt(0) == '0') {
                        return 0;
                }
                // This is a typical DP problem
                int[] cache = new int[s.length() + 1];
                cache[0] = 1;
                cache[1] = 1;
                for (int i = 2; i <= s.length(); i++) {
                        char temp = s.charAt(i - 1);
                        if (temp != '0') {
                                cache[i] = cache[i - 1];
                        }
                        
                        if (s.charAt(i - 2) != '0') {
                                int t = Integer.parseInt(s.substring(i-2, i));
                                if ( t >= 1 && t <= 26) {
                                        cache[i] += cache[i - 2];
                                }
                        }
                }
                return cache[s.length()];
        }
}
