// Leetcode: Candy
// Author: Yinjie Huang
// Date: 12/04/2014
//
import java.util.*;

public class Candy {
        public static void main(String[] args) {
                System.out.println("Leetcode: Candy!!!");
                Candy c = new Candy();
                int[] ratings = new int[]{4, 7, 2, 3, 5, 6};
                System.out.println(c.candy(ratings));
        }

        public int candy(int[] ratings) {
                if (ratings == null || ratings.length == 0) {
                        return 0;
                }
                int[] left = new int[ratings.length];
                int[] right = new int[ratings.length];
                left[0] = 1;
                for (int i = 1; i < ratings.length; i++) {
                        if (ratings[i] > ratings[i - 1]) {
                                left[i] = left[i - 1] + 1;
                        } else {
                                left[i] = 1;
                        }
                }
                right[ratings.length - 1] = left[ratings.length - 1];
                for (int i = ratings.length - 2; i >= 0; i--) {
                        if (ratings[i] > ratings[i + 1]) {
                                right[i] = right[i + 1] + 1;
                        } else {
                                right[i] = 1;
                        }
                }
                int res = 0;
                for (int i = 0; i < ratings.length; i++) {
                        res += Math.max(left[i], right[i]);
                }
                return res;
        }
}
