// Leetcode 069: Sqrtx
// Author: Yinjie Huang
// Date: 10/28/2014
//
import java.util.*

public class Sqrtx {
        public static void main(String[] args) {
                System.out.println("Leetcode 069: Sqrtx!!!");
                Sqrtx s = new Sqrtx();
                System.out.println(s.sqrt(25));
        }

        public int sqrt(int x) {
                if (x <= 1) {
                        return x;
                }
                long start = 0;
                long  end = x/2 + 1;
                while (start <= end) {
                        long temp = (start + end)/2;
                        long sq = temp * temp;
                        if (sq == x) {
                                return (int)temp;
                        } else if (sq > x) {
                                end = temp - 1;
                        } else {
                                start = temp + 1;
                        }
                }
                return (int)end;
    }
}
