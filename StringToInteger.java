// Leetcode: String to Integer (atoi)
// Author: Yinjie Huang
// Time: 10/03/2014
//
import java.util.*;

class StringToInteger {
        public static void main(String[] args) {
                System.out.println("Leetcode: StringToInteger!!!");
                StringToInteger sti = new StringToInteger();
                
                // Test case 1
                String s1 = "    -123";
                System.out.println("Original String" + s1);
                System.out.println("Converted Integer: " + sti.stringToInteger_1(s1));
                System.out.println("Converted Integer: " + sti.stringToInteger_2(s1));

                // Test case 2
                String s2 = "  +-2";
                System.out.println("Original String" + s2);
                System.out.println("Converted Integer: " + sti.stringToInteger_1(s2));
                System.out.println("Converted Integer: " + sti.stringToInteger_2(s2));

                // Test case 3
                String s3 = "    ";
                System.out.println("Original String" + s3);
                System.out.println("Converted Integer: " + sti.stringToInteger_1(s3));
                System.out.println("Converted Integer: " + sti.stringToInteger_2(s3));

                // Test case 4
                String s4 = "  u888";
                System.out.println("Original String" + s4);
                System.out.println("Converted Integer: " + sti.stringToInteger_1(s4));
                System.out.println("Converted Integer: " + sti.stringToInteger_2(s4));

                // Test case 5
                String s5 = " 23456789011111";
                System.out.println("Original String" + s5);
                System.out.println("Converted Integer: " + sti.stringToInteger_1(s5));
                System.out.println("Converted Integer: " + sti.stringToInteger_2(s5));
        }
        // Method 1, I think this is like cheating, we use double to test if the value exceeds MAXIMUM or MINIMUM
        public int stringToInteger_1(String str) {
                if (str == null) {
                        return 0;
                }
                char[] array = str.toCharArray();
                int l = array.length;
                int flag = 1;
                int index = 0;
                while (index < l && array[index] == ' ') {
                        index++;
                }

                // if all the characters are all while spaces
                if (index == l) {
                        return 0;
                }
                // Detect if we have sign character, or other non valid characters
                if (array[index] == '+') {
                        flag = 1;
                        index++;
                } else if (array[index] == '-') {
                        flag = -1;
                        index++;
                }

                // Now we begin to convert the string
                double result = 0;
                for (int j = index; j < l ; j++) {
                        if (array[j] >= '0' && array[j] <= '9') {
                                result = result*10 + array[j] - '0';
                        } else {
                                break;
                        }
                }

                result =  flag * result;
                if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                } else if (result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                } else {
                        return (int) result;
                }
        }

        // Method 2, use reasonable method to check if the number is too large or too small
        public int stringToInteger_2(String str1) {
                String str = str1.trim();
                if (str.length() ==  0) {
                        return 0;
                }
                char[] array = str.toCharArray();
                int flag = 1;
                int index = 0;
                if (array[index] == '+') {
                        flag = 1;
                        index++;
                } else if (array[index] == '-') {
                        flag = -1;
                        index++;
                }

                int result = 0;
                for (int i = index; i < array.length; i++) {
                        if (array[i] >= '0' && array[i] <= '9') {
                                // Here we decide if the number exceeds the bound
                                if (result > Integer.MAX_VALUE/10 || array[i] - '0' > Integer.MAX_VALUE - result * 10) {
                                        return flag == -1 ? Integer.MIN_VALUE:Integer.MAX_VALUE;
                                } else {
                                        result = result * 10 + array[i] - '0';
                                }
                        } else {
                                break;
                        }
                }

                return flag * result;
        }
}
