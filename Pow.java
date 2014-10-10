// Leetcode 050: Pow
// Author: Yinjie Huang
// Data: 10/09/2014
//
import java.util.*;

public class Pow {
        public static void main(String[] args) {
                System.out.println("Leetcode 050: Pow!!!");

                Pow p = new Pow();
                // Testcase 1:
                System.out.print("Pow(2,3) = ");
                System.out.println(p.pow(2,3));

                // Testcase 2:
                System.out.print("Pow(3,-2) = ");
                System.out.println(p.pow(3,-2));

                // Testcase 3:
                System.out.print("Pow(-2,3) = ");
                System.out.println(p.pow(-2,3));

                //Testcase 4:
                System.out.print("Pow(2,0) = ");
                System.out.println(p.pow(2,0));
        }
        
        // Method 1, O(logn)
        public double pow(double x, int n) {
                if (n == 0) {
                        return 1;
                }
                int sign = n > 0 ? 1 : -1;
                int absn = Math.abs(n);
                double v = pow(x, absn/2);
                double result = 0;
                if (absn % 2 == 0) {
                        result = v * v;
                } else {
                        result = v * v * x;
                }
                if (n > 0) {
                        return result;
                } else {
                        return 1/result;
                }
        }
}
