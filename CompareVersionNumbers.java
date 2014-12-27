// Leetcode: Compare Version Numbers
// Author: Yinjie Huang
// Date: 12/20/2014
//
import java.util.*;

public class CompareVersionNumbers {
        public static void main(String[] args) {
                System.out.println("Leetcode: Compare Version Numbers!!!");
                CompareVersionNumbers cvn = new CompareVersionNumbers();
                System.out.println(cvn.compareVersion("0.1", "1.1"));
                System.out.println(cvn.compareVersion("1.1", "1.2"));
                System.out.println(cvn.compareVersion("1.2", "13.37"));
                System.out.println(cvn.compareVersion("5.1", "1.1"));
        }

        public int compareVersion(String version1, String version2) {
                if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
                        return 0;
                }
                String[] ver1 = version1.split("\\.");
                String[] ver2 = version2.split("\\.");
                int i = 0, j = 0;
                while (i < ver1.length && j < ver2.length) {
                        int int1 = Integer.parseInt(ver1[i]);
                        int int2 = Integer.parseInt(ver2[j]);
                        if (int1 > int2) {
                                return 1;
                        }
                        if (int1 < int2) {
                                return -1;
                        }
                        i++;
                        j++;
                }
                if (i < ver1.length && Integer.parseInt(ver1[i]) != 0) {
                        return 1;
                }
                if (j < ver2.length && Integer.parseInt(ver2[j]) != 0) {
                        return -1;
                }
                return 0;
        }
}
