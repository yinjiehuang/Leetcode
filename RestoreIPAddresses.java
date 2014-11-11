// Leetcode 093: Restore IP Addresses
// Author: Yinjie Huang
// Date: 11/04/2014
//
import java.util.*;

public class RestoreIPAddresses {
        public static void main(String[] args) {
                System.out.println("Leetcode 093: Restore IP Addresses!!!");
                RestoreIPAddresses ria = new RestoreIPAddresses();
                String s = "25525511135";
                ArrayList<String> result = ria.restoreIpAddresses(s);
                for (String str : result) {
                        System.out.println(str);
                }
        }

        public ArrayList<String> restoreIpAddresses(String s) {
                ArrayList<String> result = new ArrayList<String>();
                if (s.length() < 4 || s.length() > 12) {
                        return result;
                }
                helper(result, "", s, 1);
                return result;
        }

        public void helper(ArrayList<String> result, String sofar, String s, int depth) {
                if (depth == 4 && isValid(s)) {
                        result.add(sofar + s);
                        return;
                }
                for (int i = 1; i < 4 && i < s.length(); i++) {
                        String temp = s.substring(0, i);
                        if (isValid(temp)) {
                                helper(result, sofar + temp + ".", s.substring(i), depth + 1);
                        }
                }
        }

        public boolean isValid(String s) {
                char first = s.charAt(0);
                if (first == '0') {
                        return s.equals("0");
                }
                int temp = Integer.parseInt(s);
                return temp <= 255 && temp > 0;
        }
}
